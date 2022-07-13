package Projects;

import API.BaseAPI;
import Token.GetAccessToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static constant.Constant.devTodoist.baseURL;
import static constant.Constant.devTodoist.project;

public class GetAllProject extends BaseAPI {
    GetAccessToken getAccessToken = new GetAccessToken();
    @Test
    public void getProject() {
        String accessToken = getAccessToken.generateAccessToken();
        RestAssured.baseURI = baseURL;
        Response res = sendGet(project, accessToken);
        res.prettyPrint();
    }
}
