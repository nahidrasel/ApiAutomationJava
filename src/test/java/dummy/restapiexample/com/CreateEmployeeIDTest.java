package dummy.restapiexample.com;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class CreateEmployeeIDTest extends BaseTestClass {

    @Test
    public void CreateNewEmployer_StatusCode() {
        String requestBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
        String resourceUrl = "/api/v1/EmployerCreate";

        Response response = createPostRequest(resourceUrl, requestBody);

        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.print());
        assertEquals(200, response.statusCode());
    }


    @Test
    public void CreateNewEmployee_Body() {

        String requestBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
        String resourceUrl = "/api/v1/create";

        Response response = createPostRequest(resourceUrl, requestBody);


        //Verify response body

        JsonPath json = response.jsonPath();

        String name = json.get("data.name");
        System.out.println("Name is => " + name);
        assertEquals("test", name);

        String salary = json.get("data.salary");
        System.out.println("Salary is => " + salary);
        assertEquals("123", salary);

        String age = json.get("data.age");
        System.out.println("Age is => " + age);
        assertEquals("23", age);

        String message = json.get("message");
        System.out.println("Message => " + message);
        assertEquals("Successfully! Record has been added.", message);

    }
}

