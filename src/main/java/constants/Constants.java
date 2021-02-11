package constants;

public class Constants {

    // I would say this can be moved to the test folder, to be all together
    // I would say that this file can be removed and read these values from the testng xml file instead as paremeters
    public static final String BASE_URL = "https://reqres.in/api";
    public static final String GET_USERS = "/users?page=2";
    public static final String POST_USERS = "/users";
    public static final String PUT_PATCH_DELETE_USERS = "/users/2";
    public static final String POST_SUCCESSFUL_REGISTER = "/api/register";
    public static final String POST_UNSUCCESSFUL_REGISTER = "/register";
    public static final String POST_LOGIN = "/login";
}
