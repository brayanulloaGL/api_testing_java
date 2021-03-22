package tests;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login extends BaseTests {

    @Parameters("post_login_url")
    @Test(groups = {"Regression", "Positive"})
    public void LoginSuccessful(String postLoginURL){
        given()
                .auth()
                .preemptive()
                .basic("eve.holt@reqres.in", "")
                .when()
                .get(postLoginURL)
                .then()
                .assertThat().statusCode(200);
    }
}


