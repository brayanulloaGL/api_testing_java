package tests;

import base.BaseTests;
import base.UserPojo;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import com.google.gson.Gson;

public class User extends BaseTests {

    UserPojo userPojo = new UserPojo();

    @Parameters("get_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void GetListOfUsers(String getUsersURL){

        userPojo.setName("Bryan");
        userPojo.setJob("QA");
        given()
                .get(getUsersURL)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Parameters("get_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void VerifyUserEmail(String getUsersURL){
        given()
                .get(getUsersURL)
                .then()
                .statusCode(200)
                .body("data.email[0]", equalTo("michael.lawson@reqres.in"))
                .log().all();
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
                .statusCode(201)
                .log().all();
    }

    @Parameters("put_patch_delete_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void UpdateUser(String putPatchDeleteUserURL){
        JSONObject request = new JSONObject();

        request.put("name", "Rodolfo");
        request.put("job", "Practice Lead");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
                .when()
                .put(putPatchDeleteUserURL)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Parameters("put_patch_delete_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void PatchUpdateUser(String putPatchDeleteUserURL){
        JSONObject request = new JSONObject();

        request.put("name", "Rafa");
        request.put("job", "QA Engineer");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
                .when()
                .patch(putPatchDeleteUserURL)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Parameters("put_patch_delete_users_url")
    @Test (groups = {"Regression", "Positive"})
    public void deleteUser(String putPatchDeleteUserURL){
        when().
                delete(putPatchDeleteUserURL).
                then().
                statusCode(204).
                log().all();
    }
}
