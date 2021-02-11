package tests;

import base.BaseTests;
import constants.Constants;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login extends BaseTests {

    // use groups for all test cases to mark them as regression, smoke, etc (APPLY ON ALL TESTCASES)
    // try to validate not only the status code, but also de response body, and response time (APPLY ON ALL TESTCASES)
    @Test
    public void LoginSuccessful(){
        // read authentication username as a parameter from testng
        given()
                .auth()
                .preemptive()
                .basic("eve.holt@reqres.in", "")
                .when()
                .get(Constants.POST_LOGIN)
                .then()
                .statusCode(200)
                .log().all();
    }
}


