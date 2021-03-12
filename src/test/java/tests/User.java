package tests;

import base.BaseTests;
import constants.Constants;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class User extends BaseTests {

    @Test (groups = {"Regression", "Positive"})
    public void GetListOfUsers(){
        given()
                .get(Constants.GET_USERS)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test (groups = {"Regression", "Positive"})
    public void VerifyUserEmail(){
        given()
                .get(Constants.GET_USERS)
                .then()
                .statusCode(200)
                .body("data.email[0]", equalTo("michael.lawson@reqres.in"))
                .log().all();
    }

    @Test (groups = {"Regression", "Positive"})
    public void CreateUser(){
        JSONObject request = new JSONObject();

        request.put("name", "Bryan");
        request.put("job", "QA Engineer");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
                .when()
                .post(Constants.POST_USERS)
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test (groups = {"Regression", "Positive"})
    public void UpdateUser(){
        JSONObject request = new JSONObject();

        request.put("name", "Rodolfo");
        request.put("job", "Practice Lead");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
                .when()
                .put(Constants.PUT_PATCH_DELETE_USERS)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test (groups = {"Regression", "Positive"})
    public void PatchUpdateUser(){
        JSONObject request = new JSONObject();

        request.put("name", "Rafa");
        request.put("job", "QA Engineer");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
                .when()
                .patch(Constants.PUT_PATCH_DELETE_USERS)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test (groups = {"Regression", "Positive"})
    public void deleteUser(){
        when().
                delete(Constants.PUT_PATCH_DELETE_USERS).
                then().
                statusCode(204).
                log().all();
    }
}
