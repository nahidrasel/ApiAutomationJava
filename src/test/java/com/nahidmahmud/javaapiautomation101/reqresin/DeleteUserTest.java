package com.nahidmahmud.javaapiautomation101.reqresin;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class DeleteUserTest extends BaseTestClass {

    @Test
    public void DeleteUserId_StatusCode() {

        //Arrange
        String requestBody = "";
        String resourceUrl = "/api/users/2";

        Response response = deletePostRequest(resourceUrl, requestBody);

        //Assert Status Code
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint() + "Should be Nothing");
        assertEquals(204, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();
    }
}

