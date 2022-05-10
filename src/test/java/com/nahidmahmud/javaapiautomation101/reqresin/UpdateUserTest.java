package com.nahidmahmud.javaapiautomation101.reqresin;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static junit.framework.Assert.assertEquals;

public class UpdateUserTest extends BaseTestClass {

    @Test
    public void putMethodByJson_StatusCode() {

        //  Response response = given().contentType("application/json");
        String requestBody = "{\"name\":\"morpheus\",\n\"job\":\"zion resident\"}";

        String id = "2";
        String resourceUrl = "/api/users/" + id;

        Response response = updatePutRequest(resourceUrl, requestBody);

        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.print());
        assertEquals(200, response.statusCode());
    }

    @Test
    public void putMethodByJson_Body() {

        String requestBody = "{\"name\":\"morpheus\",\n\"job\":\"zion resident\"}";

        String id = "2";
        String resourceUrl = "/api/users/" + id;

        Response response = updatePutRequest(resourceUrl, requestBody);

        //Verify response body
        JsonPath json = response.jsonPath();

        String name = json.get("name");
        System.out.println("Name is => " + name);
        assertEquals("morpheus", name);

        String job = json.get("job");
        System.out.println("Job is => " + job);
        assertEquals("zion resident", job);
    }
}
