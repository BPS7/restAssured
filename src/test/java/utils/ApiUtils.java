package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    private static RequestSpecification getRequestSpec() {
        return RestAssured
                .given()
                .baseUri("https://reqres.in")   // Base URL
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")  // ✅ Your API key added here
                .log().all(); // Optional: logs the request for debugging
    }

    public static Response getRequest(String endpoint) {
        return getRequestSpec()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response postRequest(String endpoint, String body) {
        return getRequestSpec()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response putRequest(String endpoint, String body) {
        return getRequestSpec()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response patchRequest(String endpoint, String body) {
        return getRequestSpec()
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response deleteRequest(String endpoint) {
        return getRequestSpec()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
