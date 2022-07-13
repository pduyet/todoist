package Token;

import API.BaseAPI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static constant.Constant.Todoist.baseURL;
import static io.restassured.RestAssured.given;

public class GetAccessToken extends BaseAPI {
    Gson g = new Gson();

    public String generateAccessToken() {
        RestAssured.baseURI = baseURL;
        Map<String, Object> credentials = new HashMap<>();
        credentials.put("email", "duyetpham.se@gmail.com");
        credentials.put("password", "dp281097");
        RestAssured.baseURI = baseURL;
        Response res = sendPost(credentials);
        Object response = res.as(Object.class);
        String a = g.toJson(response);
        JsonObject j = g.fromJson(a, JsonObject.class);
        return j.get("token").getAsString();
    }
}
