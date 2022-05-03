package dummy.restapiexample.com;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class DeleteEmployeeDataTest extends BaseTestClass {

    @Test
    public void DeleteEmployer_StatusCode() {
        String requestBody = "";
        String resourceUrl = "/api/v1/delete/2";

        Response response = deletePostRequest(resourceUrl, requestBody);

        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.print());
        assertEquals(200, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

        String message = json.get("message");
        System.out.println("Message => " + message);
        assertEquals("Successfully! Record has been deleted", message);
    }
}