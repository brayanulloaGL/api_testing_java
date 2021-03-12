package base;

import io.restassured.RestAssured;
import constants.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTests {

    @BeforeClass
    @Parameters("base_url")
    public void setUp(String baseURL){
        RestAssured.baseURI = baseURL;
    }
}
