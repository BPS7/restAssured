package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

public class CreateUserTest extends BaseTest {

    @Test(description = "Validate POST /users API")
    @Description("Create a new user and verify response status and content")
    public void createUser() {
        JSONObject payload = new JSONObject();
        payload.put("name", "Bhanu");
        payload.put("job", "QA Engineer");

        Response response = ApiUtils.postRequest("/api/users", payload.toString());

        try {
            Assert.assertEquals(response.statusCode(), 201, "Expected 201 Created");
            Assert.assertTrue(response.asString().contains("id"), "Response missing ID");
        } catch (AssertionError e) {
            Assert.fail("Validation failed: " + e.getMessage());
        }
    }
}

