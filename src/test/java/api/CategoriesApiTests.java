package api;

import com.google.gson.reflect.TypeToken;
import common.Global;
import dto.CategoriesDTO;
import dto.CategoriesObjectDTO;
import dto.CategoriesResponseDTO;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import util.*;


import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CategoriesApiTests extends ZomatoApiActions {
    Response response;

    Global global = new Global();
    String categories_resource;
    String user_key;

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
        response = getCategoriesApiResponse(global, user_key, categories_resource, ApiMethodConstants.GET);

        int status = response.getStatusCode();
        List<CategoriesObjectDTO> categoriesObjectDTOList = new LinkedList<>();
        ApiAsserts.assertEquals(status, 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");

        System.out.println("User Api Response Body: " + response.getBody().asString());
        ArrayList<CategoriesDTO> categoriesDTOArrayList;
        //CategoriesDTO categoriesDTO = response.getBody().as(CategoriesDTO.class);
        //Type categoriesListType = new TypeToken<List<CategoriesObjectDTO>>(){}.getType();
        CategoriesResponseDTO categoriesResponseDTO = (CategoriesResponseDTO) JsonUtils.jsonToDto(response.getBody().asString(), CategoriesResponseDTO.class);
              //  (Helper.convertJsonToDTO(response.getBody().asString(), categoriesListType));

        //get the JsonPath object instance from the Response interface
        //JsonPath jsonPathEvaluator = response.jsonPath();
//        ArrayList<CategoriesDTO> categoriesDTOArrayList;
//        CategoriesDTO categoriesDTO = response.getBody().as(CategoriesDTO.class);

//        String medicineJson = initArray("Medicines.json").toString();
//        Gson gson = new Gson();
//        Type medicineListType = new TypeToken<List<Medicine>>() {}.getType();
//        List<Medicine> medicineArray = gson.fromJson(medicineJson, medicineListType);
//        return medicineArray

//        Type categoriesListType = new TypeToken<List<CategoriesObjectDTO>>(){}.getType();
//
//         categoriesObjectDTOList= (List<CategoriesObjectDTO>) (Helper.convertJsonToDTO(response.getBody().asString(), categoriesListType));
//        ApiAsserts.assertTrue(categoriesObjectDTOList.size()>0,"Category is found to be null");
        // ApiAsserts.assertNotEmpty(categoriesResponseDTO.getCategories(), "Categories can not be null");
    }

    /*
    Verify the Categories API with invalid userkey
    It should return 403 forbidden error
     */
    @Test(testName = "Verify Categories api response with invalid user key", description = "verify categories Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 2)
    public void verifyCategoriesApiResponseWithInvalidUserKey() throws IOException, URISyntaxException {
        String user_key = "12234";
        response = getCategoriesApiResponse(global, user_key, categories_resource, ApiMethodConstants.GET);

        int statusCode = response.getStatusCode();
        System.out.println("User Api Response Body: " + response.getBody().asString());


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

    @Test(testName = "Verify Categories api response with POST method", description = "verify categories Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 3)
    public void verifyCategoriesApiResponseWithPOSTMethod() throws IOException, URISyntaxException {
        response = getCategoriesApiResponse(global, user_key, categories_resource, ApiMethodConstants.POST);

        int statusCode = response.getStatusCode();
        System.out.println("User Api Response Body: " + response.getBody().asString());


        ApiAsserts.assertEquals(statusCode, 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");
        // Validate the response

    }

     /*
    Verify the Categories API with invalid resource
    It is returning HTML response with status code 200
     */

    @Test(testName = "Verify Categories api response with Invalid resource", description = "verify categories Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 4)
    public void verifyCategoriesApiResponseWithInvalidResource() throws IOException, URISyntaxException {
        categories_resource = global.getBase().get_baseUrl() + "233444";
        response = getCategoriesApiResponse(global, user_key, categories_resource, ApiMethodConstants.GET);

        int statusCode = response.getStatusCode();
        System.out.println("User Api Response Body: " + response.getBody().asString());

        ApiAsserts.assertEquals(statusCode, 200, "Status returned is incorrect");
//        ApiAsserts.assertEquals(response.getContentType(),"", "Content type does not match");


    }

}
