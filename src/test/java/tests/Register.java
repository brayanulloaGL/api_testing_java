package tests;

import base.BaseTests;
import constants.Constants;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Register extends BaseTests{

    @Test
    public void RegistrationSuccessful(){
        JSONObject request = new JSONObject();

        // read the username as testng parameter (APPLY ON ALL TESTCASES)
        // read the password as a secret (env variable, or maven parameter) (APPLY ON ALL TESTCASES)
        request.put("email", "brayan@gl.com");
        request.put("password", "brayan");

        System.out.println(request.toJSONString());


        // validate more than just the status code
        given()
                .body(request.toJSONString())
                .when()
                .post(Constants.POST_SUCCESSFUL_REGISTER)
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void RegistrationUnsuccessful(){
        JSONObject request = new JSONObject();

        request.put("email", "brayan@gl.com");

        System.out.println(request.toJSONString());

        // validate more than just the status code
        given()
                .body(request.toJSONString())
                .when()
                .post(Constants.POST_UNSUCCESSFUL_REGISTER)
                .then()
                .statusCode(400)
                .log().all();
    }
}
