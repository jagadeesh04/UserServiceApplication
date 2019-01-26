package com.quiz.GradleProject101.integrationTest;

import com.google.gson.Gson;
import com.quiz.GradleProject101.User;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*public class UserControllerITTest implements BeforeAllCallback, AfterAllCallback {

    private static final String path ="/user";


    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        RestAssured.reset();
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testGetAllUsersReturnsNotNullList(){
        List<User> userList = RestAssured.given().get(path+"/getAllUsers").as(List.class);

        Assert.assertTrue(userList!=null);
        Assert.assertFalse(userList.isEmpty());
    }


    @Test
    public void testPutUsersToUpdateUser1() throws Exception
    {
        RestAssured.given().body("{\"id\":1,\"userName\":\"cat\",\"email\":\"cat@cat.com\"}").
                header("Content-Type", "application/json").when().put(path + "/1").then().assertThat().statusCode(200).body("userName", containsString("cat"));
    }

    @Test
    public void testPutUsersToNotUpdateUserForInvalidUserName() throws Exception
    {
        RestAssured.given().body("{\"id\":1,\"userName\":\",\"email\":\"cat@cat.com\"}").
                header("Content-Type", "application/json").when().put(path + "/1").then().assertThat().statusCode(400);
    }

    @Test
    public void testPutUsersToNotUpdateUserForInvalidEmail() throws Exception
    {
        RestAssured.given().body("{\"id\":1,\"userName\":\"cat\",\"email\":\"cat.com\"}").
                header("Content-Type", "application/json").when().put(path + "/1").then().assertThat().statusCode(400);
    }

    @Test
    public void testPutUsersToNotUpdateUserForNullInputs() throws Exception
    {
        RestAssured.given().body("{\"id\":1,\"userName\":,\"email\":}").
                header("Content-Type", "application/json").when().put(path + "/1").then().assertThat().statusCode(400);
    }


}*/
