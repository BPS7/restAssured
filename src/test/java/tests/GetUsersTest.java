package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

public class GetUsersTest extends BaseTest {

    @Test(description = "Validate GET /users API")
    @Description("Fetch user list and validate 200 response")
    public void getUsersList() {
        Response response = ApiUtils.getRequest("/api/users?page=2");

        try {
            Assert.assertEquals(response.statusCode(), 200, "Status code mismatch");
            Assert.assertTrue(response.asString().contains("email"), "Email field missing");
        } catch (AssertionError e) {
            Assert.fail("Validation failed: " + e.getMessage());
        }
    }
}
