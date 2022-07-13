package Projects;

import API.BaseAPI;
import Token.GetAccessToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static constant.Constant.devTodoist.baseURL;
import static constant.Constant.devTodoist.project;

public class CreateProject extends BaseAPI {
    GetAccessToken getAccessToken = new GetAccessToken();
    public static String id;

    @Test
    public void createAProject() {
        String accessToken = getAccessToken.generateAccessToken();
        System.out.println(accessToken);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Test");
        RestAssured.baseURI = baseURL;
        Response res = sendPost(project, accessToken, map);
        res.prettyPrint();
        Object response = res.as(Object.class);
        String a = new Gson().toJson(response);
        JsonObject j = new Gson().fromJson(a, JsonObject.class);
        id = j.get("url").getAsString().substring(35);
        System.out.println(id);
    }
}
