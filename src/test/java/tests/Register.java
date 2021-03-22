package tests;

import base.BaseTests;
import base.RegisterPojo;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class Register extends BaseTests{

    RegisterPojo registerPojo = new RegisterPojo();

    @Parameters("post_successful_register_url")
    @Test (groups = {"Regression", "Positive"})
    public void RegistrationSuccessful(String postSuccessfulRegisterURL){

        registerPojo.setEmail("brayan.ulloa@gl.com");
        registerPojo.setPassword("brayan");

        given()
                .contentType("application/json")
                .body(registerPojo)
                .when()
                .post(postSuccessfulRegisterURL)
                .then()
                .assertThat().statusCode(201);
    }

    @Parameters("post_unsuccessful_register_url")
    @Test (groups = {"Regression", "Negative"})
    public void RegistrationUnsuccessful(String postUnsuccessfulRegisterURL){

        registerPojo.setEmail("brayan.ulloa@gl.com");

        given()
                .contentType("application/json")
                .body(registerPojo)
                .when()
                .post(postUnsuccessfulRegisterURL)
                .then()
                .assertThat().statusCode(400);
    }
}
