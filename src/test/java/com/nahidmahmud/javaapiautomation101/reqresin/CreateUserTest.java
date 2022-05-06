package com.nahidmahmud.javaapiautomation101.reqresin;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class CreateUserTest extends BaseTestClass {

    @Test
    public void CreateUserId_StatusCode() {

        //Arrange
        String requestBody = "{\"name\":\"morpheus\",\n\"job\":\"leader\"}";
        String resourceUrl = "/api/users/";

        Response response = createPostRequest(resourceUrl, requestBody);

        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());
        assertEquals(201, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

        String name = json.get("name");
        System.out.println("Name is => " + name);
        assertEquals("morpheus", name);

        String job = json.get("job");
        System.out.println("Job is => " + job);
        assertEquals("leader", job);
    }
}