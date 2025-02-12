package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CRUDOperations extends BaseTest{
    public final String createUserPayload = "src/test/resources/testData/createUserPayload.json";
    public final String updateUserPayload = "src/test/resources/testData/updateUserPayload.json";




   // Create user
    @Test(priority = 1)
    public void testCreateUser() throws IOException {
        Response response = postRequest("/users",createUserPayload);
        Assert.assertEquals(response.statusCode(),201);

        JsonPath js = response.jsonPath();
        String name = js.getString("name");
        createdUserId = js.getString("id");
        Assert.assertEquals(name, ConfigManager.getProperty("name"));
        Assert.assertNotNull(createdUserId, "User ID should not be null");
    }

    // Get user by id
    @Test(priority = 2)
    public void getCreatedUserById() throws IOException {
       Response response = getRequest("/users/"+createdUserId);
        Assert.assertEquals(response.statusCode(), 404, "Mock API does not persist users.");

    }

    //update user
    @Test(priority = 3)
    public void updateUser() throws IOException {
       Response response =putRequest("/users/"+createdUserId,updateUserPayload);

        Assert.assertEquals(response.statusCode(),200);
        JsonPath js = response.jsonPath();
        String name  = js.getString("name");
        Assert.assertEquals(name,"Ahmed Mohamed");

    }
}
