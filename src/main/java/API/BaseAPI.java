package API;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    public static Response sendPost(String basePath, Object body) {
        return given().basePath(basePath).header("Content-Type", "application/json").when().body(body).post();
    }

    public static Response sendPost(Object body) {
        return given().header("Content-Type", "application/json").when().body(body).post();
    }

    public static Response sendPost(String basePath, String accessToken, Object body) {
        return given().basePath(basePath).header("authorization", "Bearer " + accessToken).header("Content-Type", "application/json").when().body(body).post();
    }

    public static Response sendGet(String basePath) {
        return given().basePath(basePath).header("Content-Type", "application/json").when().get();
    }

    public static Response sendGet(String basePath, String accessToken) {
        return given().basePath(basePath).header("authorization", "Bearer " + accessToken).header("Content-Type", "application/json").when().get();
    }
}
