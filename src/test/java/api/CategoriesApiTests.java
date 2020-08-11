package api;


import org.testng.annotations.Listeners;
import reporting.Reports;
import common.Global;
import dto.CategoriesResponseDTO;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import util.ApiAsserts;
import util.ApiMethodConstants;
import util.TestGroups;


import java.io.IOException;
import java.net.URISyntaxException;

public class CategoriesApiTests extends ZomatoApiActions {
    Response response;

    Global global = new Global();
    Reports report = new Reports();
    String categories_resource;
    String user_key;
    ZomatoApiActions zomatoApiActions = new ZomatoApiActions();

    @BeforeTest
    public void setup_urls() throws Exception {
        user_key = global.init();
        global.setCategoryResource();
        categories_resource = global.getBase().get_categoriesResource();
    }

    /*
   Verify the Categories API with Valid userkey
   It should return List of categories objects
    */
    @Test(testName = "Verify Categories api response", description = "verify Categories Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCategoriesApiResponse() throws IOException, URISyntaxException {

        //getCategoriesApiResponse will get the response by executing the api
        response = zomatoApiActions.getCategoriesApiResponse( global, user_key, categories_resource, ApiMethodConstants.GET);

        CategoriesResponseDTO categoriesResponseDTO = response.getBody().as(CategoriesResponseDTO.class);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Categories Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertNotNull(categoriesResponseDTO.getCategories(), "Categories Response is Null. Expected it should not be Null");
        ApiAsserts.assertTrue(categoriesResponseDTO.getCategories().size() > 0, "Categorise size is 0. Expected It should have some values");
        ApiAsserts.assertNotEmpty(categoriesResponseDTO.getCategories().get(0).getCategories().getName(), "Categories Name is Empty. Expected It should have some values");
        ApiAsserts.assertNotEmpty(categoriesResponseDTO.getCategories().get(0).getCategories().getId(), "Categories Response is Null. Expected it should not be Null");

    }

    /*
    Verify the Categories API with invalid userkey
    It should return 403 forbidden error
     */
    @Test(testName = "Verify Categories api response with invalid user key", description = "verify categories Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 2)
    public void verifyCategoriesApiResponseWithInvalidUserKey() throws IOException, URISyntaxException {
        String user_key = "12234"; //set invalid user_key

        //getCategoriesApiResponse will get the response by executing the api
        response = zomatoApiActions.getCategoriesApiResponse(global, user_key, categories_resource, ApiMethodConstants.GET);

        JsonPath jsonPathEvaluator = response.jsonPath();
        int code = jsonPathEvaluator.get("code");
        String status = jsonPathEvaluator.get("status");
        String message = jsonPathEvaluator.get("message");

        // Validate the response
        ApiAsserts.assertEquals(response.getStatusCode(), 403, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(), "HTTP/1.1 403 Forbidden", "Categories Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertNotEmpty(response.getBody().asString(), "Categories api response is empty");
        ApiAsserts.assertEquals(code, 403, "Categories api code doesn't match");
        ApiAsserts.assertEquals(status, "Forbidden", "Categories api status doesn't match");
        ApiAsserts.assertEquals(message, "Invalid API Key", "Categories api message doesn't match");
    }

    /*
    Verify the Categories API with POST method
    It is returning the List of Categories Object
     */
    @Test(testName = "Verify Categories api response with POST method", description = "verify categories Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 3)
    public void verifyCategoriesApiResponseWithPOSTMethod() throws IOException, URISyntaxException {
        //getCategoriesApiResponse will get the response by executing the api
        response = zomatoApiActions.getCategoriesApiResponse(global, user_key, categories_resource, ApiMethodConstants.POST);

        CategoriesResponseDTO categoriesResponseDTO = response.getBody().as(CategoriesResponseDTO.class);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Categories Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        ApiAsserts.assertNotNull(categoriesResponseDTO.getCategories(), "Categories Response is Null. Expected it should not be Null");
        ApiAsserts.assertTrue(categoriesResponseDTO.getCategories().size() > 0, "Categorise size is 0. Expected It should have some values");
        ApiAsserts.assertNotEmpty(categoriesResponseDTO.getCategories().get(0).getCategories().getName(), "Categories Name is Empty. Expected It should have some values");
        ApiAsserts.assertNotEmpty(categoriesResponseDTO.getCategories().get(0).getCategories().getId(), "Categories Response is Null. Expected it should not be Null");

    }

    /*
   Verify the Categories API with invalid resource
   It is returning HTML response with status code 200
    */
    @Test(testName = "Verify Categories api response with Invalid resource", description = "verify categories Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 4)
    public void verifyCategoriesApiResponseWithInvalidResource() throws IOException, URISyntaxException {
        categories_resource = global.getBase().get_baseUrl() + "233444"; //invalid resource
        //getCategoriesApiResponse will get the response by executing the api
        response = zomatoApiActions.getCategoriesApiResponse(global, user_key, categories_resource, ApiMethodConstants.GET);

        //assertions
        ApiAsserts.assertEquals(response.getStatusCode(), 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK", "Categories Response status line does not match");
        ApiAsserts.assertEquals(response.getContentType(), "text/html; charset=UTF-8", "Content type does not match");

    }

}
