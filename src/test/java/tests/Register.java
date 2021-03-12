package tests;

import base.BaseTests;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Register extends BaseTests{

    @Parameters("post_successful_register_url")
    @Test (groups = {"Regression", "Positive"})
    public void RegistrationSuccessful(String postSuccessfulRegisterURL){
        JSONObject request = new JSONObject();

        request.put("email", "brayan@gl.com");
        request.put("password", "brayan");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
                .when()
                .post(postSuccessfulRegisterURL)
                .then()
                .statusCode(201)
                .log().all();
    }

    @Parameters("post_unsuccessful_register_url")
    @Test (groups = {"Regression", "Negative"})
    public void RegistrationUnsuccessful(String postUnsuccessfulRegisterURL){
        JSONObject request = new JSONObject();

        request.put("email", "brayan@gl.com");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())
                .when()
                .post(postUnsuccessfulRegisterURL)
                .then()
                .statusCode(400)
                .log().all();
    }
}
