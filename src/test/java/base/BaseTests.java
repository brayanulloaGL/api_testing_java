package base;

import io.restassured.RestAssured;
import constants.Constants;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = Constants.BASE_URL;
    }
}
