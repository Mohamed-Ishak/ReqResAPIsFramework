package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import utils.ConfigManager;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected String baseUrl;
    protected String createdUserId;

    @BeforeClass
    public void setup(){
        baseUrl = ConfigManager.getProperty("baseURI");
        RestAssured.baseURI=baseUrl;
    }

    protected Response postRequest(String endPoint, String payload){
        return given()
                .header("Content-Type", "application/json")
                .body(JsonUtils.readJsonFile(payload))
                .when()
                .post(endPoint)
                .then()
                .log().body()
                .extract().response();
    }

    protected Response getRequest(String endPoint){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(endPoint)
                .then()
                .log().body()
                .extract().response();
    }


    protected Response putRequest(String endPoint, String payload){
        return given()
                .header("Content-Type", "application/json")
                .body(JsonUtils.readJsonFile(payload))
                .when()
                .put(endPoint)
                .then()
                .log().body()
                .extract().response();
    }
}
