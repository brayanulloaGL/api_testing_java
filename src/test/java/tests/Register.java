package tests;

import base.BaseTests;
import constants.Constants;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Register extends BaseTests{

    @Test
    public void RegistrationSuccessful(){
        /*
             APPLY THIS TO ALL CLASSES
             Create a separate POJO class and let an ObjectMapper like Jackson do the deserialization and serialization
             Don’t fiddle with string concatenation or the cumbersome JsonObject to create JSON for a request or to check the responded JSON. This is verbose, not typesafe and error-prone.
             Reference: https://www.baeldung.com/java-pojo-class 
             Reference: https://java-design-patterns.com/patterns/fluentinterface/#:~:text=Fluent%20Interface%20pattern%20provides%20easily,%2Dspecific%20language%20(DSL).
        */
        JSONObject request = new JSONObject();

        request.put("email", "brayan@gl.com");
        request.put("password", "brayan");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())//the POJO object will be used here.
                .when()
                .post(Constants.POST_SUCCESSFUL_REGISTER)
                .then()
                .statusCode(201)
                .log().all();

    /*
        Missing Assertions, try to use AssertJ and validate the response against the POJO Object 
        The test is missing validations, validating the response code doesn't means that everything is working as expected
        Consider validate the response body as well
        Reference: https://joel-costigliola.github.io/assertj/
    */
    }

    @Test
    public void RegistrationUnsuccessful(){
        /*
             Create a separate POJO class and let an ObjectMapper like Jackson do the deserialization and serialization
             Don’t fiddle with string concatenation or the cumbersome JsonObject to create JSON for a request or to check the responded JSON. This is verbose, not typesafe and error-prone.
        */
        JSONObject request = new JSONObject();

        request.put("email", "brayan@gl.com");

        System.out.println(request.toJSONString());

        given()
                .body(request.toJSONString())//the POJO object will be used here.
                .when()
                .post(Constants.POST_UNSUCCESSFUL_REGISTER)
                .then()
                .statusCode(400)
                .log().all();


    }
}
