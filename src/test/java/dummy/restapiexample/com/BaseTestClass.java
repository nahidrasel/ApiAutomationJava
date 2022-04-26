package dummy.restapiexample.com;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTestClass {
    public String baseUrl = "https://dummy.restapiexample.com";

    public Response createPostRequest(String resourceUrl, String body){
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json").body(body);
        return httpRequest.request(Method.POST, resourceUrl);
    }

    public Response deletePostRequest(String resourceUrl, String body){
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json").body(body);
        return httpRequest.request(Method.DELETE, resourceUrl);
    }
}
