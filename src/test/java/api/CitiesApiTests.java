package api;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import dto.CitiesResponseDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.ApiAsserts;
import util.ApiMethodConstants;
import common.Global;
import util.TestGroups;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class CitiesApiTests extends ZomatoApiActions {

    Response response;

   Global global = new Global();
    String cities_resource;
    String user_key;
    ZomatoApiActions zomatoApiActions = new ZomatoApiActions();

    @BeforeTest
    public void setup_urls() throws Exception {
        user_key = global.init();
        global.setCitiesResource();

        cities_resource= global.getBase().get_citiesResource();
        System.out.println(cities_resource);
    }

    /*
   Verify the Categories API with Valid user_key
   It should return List of categories objects
    */
    @Test(testName = "Verify Cities api response Without Params", description = "verify Cities Api response Without Params status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCitiesApiResponseWithoutParams() throws IOException, URISyntaxException {
        //getCitiesApiResponse will get the response by executing the api
        response = zomatoApiActions.getCitiesApiResponse(global, user_key, cities_resource, ApiMethodConstants.GET);

        CitiesResponseDTO citiesResponseDTO = response.getBody().as(CitiesResponseDTO.class);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Cities Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertEquals(citiesResponseDTO.getLocation_suggestions().size(),0,"Cities Location_suggestions size expected is 0");
        ApiAsserts.assertNotEmpty(citiesResponseDTO.getStatus(), "Cities Status is Empty. Expected It should have some values");
        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Cities api response has_more is null. Expected not null value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_more(),0, "Cities api response has_more is not same as Expected value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_total(), 0, "Cities api response has_total is not same as Expected value");
        ApiAsserts.assertTrue(citiesResponseDTO.isUser_has_addresses(),"Cities User_has_addresses found false, expected true");
    }

    @Test(testName = "Verify Cities api response with Parameter q", description = "verify Cities Api response with Parameter q status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 2)
    public void verifyCitiesApiResponseWithParamCityName() throws Exception {
        //To add params to the request
        HashMap<String,String> params = new HashMap<>();
        params.put("q","delhi");
        //getCitiesApiResponse will get the response by executing the api
        response = zomatoApiActions.getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        CitiesResponseDTO citiesResponseDTO = response.getBody().as(CitiesResponseDTO.class);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Cities Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertTrue(citiesResponseDTO.getLocation_suggestions().size()>0,"Cities Location_suggestions is not greater than 0. Expected It should have some values");
        ApiAsserts.assertNotEmpty(citiesResponseDTO.getStatus(), "Cities Status is Empty. Expected It should have some values");
        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Cities api response has_more is null. Expected not null value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_more(),0, "Cities api response has_more is not same as Expected value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_total(), 0, "Cities api response has_total is not same as Expected value");
        ApiAsserts.assertTrue(citiesResponseDTO.isUser_has_addresses(),"Cities User_has_addresses found false, expected true");
    }

    @Test(testName = "Verify Cities api response with params Latitude And Longitude", description = "verify Cities Api response with params Latitude And Longitude status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 3)
    public void verifyCitiesApiResponseWithLatitudeAndLongitudeParam() throws Exception {
        //To add params to the request
        HashMap<String,Object> params = new HashMap<>();
        params.put("lat",28.7014);
        params.put("lon","77.1025");
        //getCitiesApiResponse will get the response by executing the api
        response = zomatoApiActions.getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        CitiesResponseDTO citiesResponseDTO = response.getBody().as(CitiesResponseDTO.class);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Categories Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertTrue(citiesResponseDTO.getLocation_suggestions().size()>0,"Cities Location_suggestions is not greater than 0. Expected It should have some values");
        ApiAsserts.assertNotEmpty(citiesResponseDTO.getStatus(), "Cities Status is Empty. Expected It should have some values");
        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Cities api response has_more is null. Expected not null value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_more(),0, "Cities api response has_more is not same as Expected value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_total(), 0, "Cities api response has_total is not same as Expected value");
        ApiAsserts.assertTrue(citiesResponseDTO.isUser_has_addresses(),"Cities User_has_addresses found false, expected true");
    }

    @Test(testName = "Verify Cities api response with Longitude Param", description = "verify Cities Api response with Longitude Param status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 4)
    public void verifyCitiesApiResponseWithLongitudeParam() throws Exception {
        //To add params to the request
        HashMap<String,Object> params = new HashMap<>();
        params.put("lon",77.1025);
        response = zomatoApiActions.getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        CitiesResponseDTO citiesResponseDTO = response.getBody().as(CitiesResponseDTO.class);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Cities Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertEquals(citiesResponseDTO.getLocation_suggestions().size(),0,"Cities Location_suggestions size expected is 0");
        ApiAsserts.assertNotEmpty(citiesResponseDTO.getStatus(), "Cities Status is Empty. Expected It should have some values");
        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Cities api response has_more is null. Expected not null value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_more(),0, "Cities api response has_more is not same as Expected value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_total(), 0, "Cities api response has_total is not same as Expected value");
        ApiAsserts.assertTrue(citiesResponseDTO.isUser_has_addresses(),"Cities User_has_addresses found false, expected true");
    }


    @Test(testName = "Verify Cities api response With CityIds Param", description = "verify Cities Api response With CityIds Param status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 5)
    public void verifyCitiesApiResponseWithCityIdsParam() throws Exception {
        HashMap<String,Object> params = new HashMap<>();
        params.put("city_ids","1,2,3");

        response = zomatoApiActions.getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        CitiesResponseDTO citiesResponseDTO = response.getBody().as(CitiesResponseDTO.class);
        System.out.println("Cities Api Response Body: " + response.getBody().asString());
        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Categories Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertEquals(citiesResponseDTO.getLocation_suggestions().size(),3,"Cities Location_suggestions is not greater than 0. Expected It should have some values");
        ApiAsserts.assertNotEmpty(citiesResponseDTO.getStatus(), "Cities Status is Empty. Expected It should have some values");
        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Cities api response has_more is null. Expected not null value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_more(),0, "Cities api response has_more is not same as Expected value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_total(), 0, "Cities api response has_total is not same as Expected value");
        ApiAsserts.assertTrue(citiesResponseDTO.isUser_has_addresses(),"Cities User_has_addresses found false, expected true");
    }

    @Test(testName = "Verify Cities api response", description = "verify Cities Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCitiesApiResponseWithCountParam() throws Exception {
        HashMap<String,Object> params = new HashMap<>();
        params.put("q","delhi");
        params.put("count",2);

        response = zomatoApiActions.getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        CitiesResponseDTO citiesResponseDTO = response.getBody().as(CitiesResponseDTO.class);
        System.out.println("Cities Api Response Body: " + response.getBody().asString());
        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Categories Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertEquals(citiesResponseDTO.getLocation_suggestions().size(),2,"Cities Location_suggestions is not greater than 0. Expected It should have some values");
        ApiAsserts.assertNotEmpty(citiesResponseDTO.getStatus(), "Cities Status is Empty. Expected It should have some values");
        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Cities api response has_more is null. Expected not null value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_more(),0, "Cities api response has_more is not same as Expected value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_total(), 0, "Cities api response has_total is not same as Expected value");
        ApiAsserts.assertTrue(citiesResponseDTO.isUser_has_addresses(),"Cities User_has_addresses found false, expected true");
    }

    @Test(testName = "Verify Cities api response with invalid user key", description = "verify categories Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 2)
    public void verifyUsersApiResponseWithInvalidUserKey() throws IOException, URISyntaxException {
        String user_key = "12234";
        response = zomatoApiActions.getCategoriesApiResponse(global, user_key, cities_resource, ApiMethodConstants.GET);

        int statusCode = response.getStatusCode();

        JsonPath jsonPathEvaluator = response.jsonPath();
        int code = jsonPathEvaluator.get("code");
        String status = jsonPathEvaluator.get("status");
        String message = jsonPathEvaluator.get("message");

        ApiAsserts.assertEquals(statusCode, 403, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");

        // Validate the response
        ApiAsserts.assertNotEmpty(response.getBody().asString(), "Categories api response is empty");
        ApiAsserts.assertEquals(code, 403, "Categories api code doesn't match");
        ApiAsserts.assertEquals(status, "Forbidden", "Categories api status doesn't match");
        ApiAsserts.assertEquals(message, "Invalid API Key", "Categories api message doesn't match");
    }

    /*
    Verify the Categories API with POST method
    It is returning the List of Categories Object
     */
    @Test(testName = "Verify Cities api response with POST method", description = "verify Cities Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 6)
    public void verifyCitiesApiResponseWithPOSTMethod() throws IOException, URISyntaxException {
        response = zomatoApiActions.getCategoriesApiResponse(global, user_key, cities_resource, ApiMethodConstants.POST);

        CitiesResponseDTO citiesResponseDTO = response.getBody().as(CitiesResponseDTO.class);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Cities Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertEquals(citiesResponseDTO.getLocation_suggestions().size(),0,"Cities Location_suggestions size expected is 0");
        ApiAsserts.assertNotEmpty(citiesResponseDTO.getStatus(), "Cities Status is Empty. Expected It should have some values");
        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Cities api response has_more is null. Expected not null value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_more(),0, "Cities api response has_more is not same as Expected value");
        ApiAsserts.assertEquals(citiesResponseDTO.getHas_total(), 0, "Cities api response has_total is not same as Expected value");
        ApiAsserts.assertTrue(citiesResponseDTO.isUser_has_addresses(),"Cities User_has_addresses found false, expected true");
    }

      /*
    Verify the Categories API with invalid resource
    It is returning HTML response with status code 200
     */

    @Test(testName = "Verify Cities api response with Invalid resource", description = "verify Cities Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 7)
    public void verifyCitiesApiResponseWithInvalidResource() throws IOException, URISyntaxException {

        cities_resource = global.getBase().get_baseUrl() + "233444";
        response = zomatoApiActions.getCategoriesApiResponse(global, user_key, cities_resource, ApiMethodConstants.GET);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Categories Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), "text/html; charset=UTF-8", "Content type does not match");
    }
}
