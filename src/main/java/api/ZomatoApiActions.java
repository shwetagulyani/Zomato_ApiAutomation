package api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import common.Global;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class ZomatoApiActions {

    Response response;


    public Response getCategoriesApiResponse(Global global, String user_key, String resource, String methodType) throws IOException, URISyntaxException
    {
        if(methodType.equalsIgnoreCase("GET"))
        {
            RestAssured.baseURI= global.getBase().get_baseUrl();
            response = given().header("user-key", user_key).
                    when().
                    get(resource).then().extract().response();
        }
        else if(methodType.equalsIgnoreCase("POST"))
        {
            RestAssured.baseURI= global.getBase().get_baseUrl();
            response = given().header("user-key", user_key).
                    when().
                    post(resource).then().contentType(global.getBase().get_content_type()).extract().response();

        }
        return response;
    }

    public Response getCitiesApiResponse(Global global, String user_key, String resource, String methodType) throws IOException, URISyntaxException
    {
        if(methodType.equalsIgnoreCase("GET"))
        {
            RestAssured.baseURI= global.getBase().get_baseUrl();
            response = given().header("user-key", user_key).
                    when().

                    get(resource).then().extract().response();
        }
        else if(methodType.equalsIgnoreCase("POST"))
        {
            RestAssured.baseURI= global.getBase().get_baseUrl();
            response = given().header("user-key", user_key).
                    when().
                    post(resource).then().contentType(global.getBase().get_content_type()).extract().response();

        }
        return response;
    }

    public Response getCitiesApiResponseWithParams(Global global, String user_key, String resource, String methodType, Map params) throws IOException, URISyntaxException
    {
            System.out.println(params.containsKey("q"));
            RestAssured.baseURI= global.getBase().get_baseUrl();
            response = given().header("user-key", user_key).
                    when().parameters(params).

                    get(resource).then().extract().response();

        return response;
    }

}
