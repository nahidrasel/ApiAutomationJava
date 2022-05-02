package dummy.restapiexample.com;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class CopyOfGetAllEmployeeDataTest {

    @Test
    public void allEmployeeData() {

        //Arrange
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
        String resourceUrl = "/api/v1/employees";

        //Act
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, resourceUrl);

        //Assert
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());
        assertEquals(200, response.statusCode());

        //Verify response body
        JsonPath json = response.jsonPath();

        String message = json.get("message");
        System.out.println("Message => " + message);
        assertEquals("Successfully! All records has been fetched.", message);

        int empId = json.get("data[1].id");
        System.out.println("Employee ID is :" + empId);
        assertEquals(2, empId);


        String empName = json.get("data[1].employee_name");
        System.out.println("Employee Name is :" + empName);
        assertEquals("Garrett Winters", empName);

        int empSalary = json.get("data[1].employee_salary");
        System.out.println("Employee Salary is :" + empSalary);
        assertEquals(170750, empSalary);

        var empAge = json.get("data[1].employee_age");
        System.out.println("Employee Age is :" + empAge);
        assertEquals(63, empAge);

    }
}