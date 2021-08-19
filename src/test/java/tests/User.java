package tests;

import base.BaseTests;
import base.UserPojo;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;


import com.google.gson.Gson;

import javax.xml.ws.Response;
import java.nio.file.Paths;

public class User extends BaseTests {

    UserPojo userPojo = new UserPojo();

    @Parameters("get_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void GetListOfUsers(String getUsersURL){
        given()
                .get(getUsersURL)
                .then()
                .assertThat().statusCode(200);
    }

    @Parameters("get_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void VerifyUserEmail(String getUsersURL){
        given()
                .get(getUsersURL)
                .then()
                .assertThat().body("data.email[0]", equalTo("michael.lawson@reqres.in"));
    }

    @Parameters("post_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void CreateUser(String postUserURL){

        userPojo.setName("Bryan");
        userPojo.setJob("QA");

        given()
                .contentType("application/json")
                .body(userPojo)
                .when()
                .post(postUserURL)
                .then()
                .assertThat().statusCode(201);
    }

    @Parameters("put_patch_delete_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void UpdateUser(String putPatchDeleteUserURL){

        userPojo.setName("Carlos");
        userPojo.setJob("Developer");

        given()
                .contentType("application/json")
                .body(userPojo)
                .when()
                .put(putPatchDeleteUserURL)
                .then()
                .assertThat().statusCode(200);
    }

    @Parameters("put_patch_delete_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void PatchUpdateUser(String putPatchDeleteUserURL){

        userPojo.setName("Roberto");
        userPojo.setJob("Product Owner");

        given()
                .contentType("application/json")
                .body(userPojo)
                .when()
                .patch(putPatchDeleteUserURL)
                .then()
                .assertThat().statusCode(200);
    }

    @Parameters("put_patch_delete_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void deleteUser(String putPatchDeleteUserURL){
        when()
                .delete(putPatchDeleteUserURL)
                .then()
                .assertThat().statusCode(204);
    }

    @Parameters("get_users_url")
    @Test
    public void VerifyResponseTime(String getUsersURL){
        when()
                .get(getUsersURL)
                .then()
                .assertThat().time(lessThan(2000L)); // Milliseconds
    }
}
