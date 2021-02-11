package base;

import io.restassured.RestAssured;
import constants.Constants;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    @BeforeClass
    public void setUp(){
        // Read the url as a parameter from the TestNG file
        RestAssured.baseURI = Constants.BASE_URL;
    }
}
