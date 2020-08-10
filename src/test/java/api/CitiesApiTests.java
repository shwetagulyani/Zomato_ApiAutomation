package api;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import dto.CategoriesObjectDTO;
import dto.CitiesResponseDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.ApiAsserts;
import util.ApiMethodConstants;
import common.Global;
import util.Helper;
import util.TestGroups;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CitiesApiTests extends ZomatoApiActions {

    Response response;

    Global global = new Global();
    String cities_resource;
    String user_key;



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
    @Test(testName = "Verify Cities api response", description = "verify Cities Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCitiesApiResponse() throws IOException, URISyntaxException {
        response = getCitiesApiResponse(global, user_key, cities_resource, ApiMethodConstants.GET);

        int status = response.getStatusCode();
        List<CategoriesObjectDTO> categoriesObjectDTOList = new LinkedList<>();
        ApiAsserts.assertEquals(status, 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");

        System.out.println("Cities Api Response Body: " + response.getBody().asString());
        CitiesResponseDTO citiesResponseDTO = (CitiesResponseDTO) Helper.convertJsonToDTO(response.getBody(),CitiesResponseDTO.class.getCanonicalName());

        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(),"Category is found to be null");
//        ApiAsserts.assertNotEmpty(categoriesResponseDTO.getCategories(), "Categories can not be null");


       // ArrayList<CategoriesDTO> categoriesDTOArrayList;
//        CategoriesDTO categoriesDTO = response.getBody().as(CategoriesDTO.class);
//
//        CategoriesResponseDTO categoriesResponseDTO= (CategoriesResponseDTO) Helper.convertJsonToDTO(response.getBody(), CategoriesResponseDTO.class);
//        ApiAsserts.assertNotNull(categoriesResponseDTO.getCategories(),"Category is found to be null");
//        ApiAsserts.assertNotEmpty(categoriesResponseDTO.getCategories(), "Categories can not be null");



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

    @Test(testName = "Verify Cities api response", description = "verify Cities Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCitiesApiResponseWithParamCityName() throws Exception {
        HashMap<String,String> params = new HashMap<>();
        params.put("q","delhi");
        response = getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        int status = response.getStatusCode();
       // List<CategoriesObjectDTO> categoriesObjectDTOList = new LinkedList<>();
        ApiAsserts.assertEquals(status, 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");

        System.out.println("Cities Api Response Body: " + response.getBody().asString());
//        CitiesResponseDTO citiesResponseDTO = (CitiesResponseDTO) Helper.convertJsonToDTO(response.getBody(), CitiesResponseDTO.class.getCanonicalName());
//
//        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Category is found to be null");
    }

    @Test(testName = "Verify Cities api response", description = "verify Cities Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCitiesApiResponseWithLatitudeAndLongitudeParam() throws Exception {
        HashMap<String,Object> params = new HashMap<>();
        params.put("lat",28.7014);
        params.put("lon","77.1025");
        response = getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        int status = response.getStatusCode();
        //List<CategoriesObjectDTO> categoriesObjectDTOList = new LinkedList<>();
        ApiAsserts.assertEquals(status, 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");

        System.out.println("Cities Api Response Body: " + response.getBody().asString());
//        CitiesResponseDTO citiesResponseDTO = (CitiesResponseDTO) Helper.convertJsonToDTO(response.getBody(), CitiesResponseDTO.class.getCanonicalName());
//
//        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Category is found to be null");
    }

    @Test(testName = "Verify Cities api response", description = "verify Cities Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCitiesApiResponseWithLongitudeParam() throws Exception {
        HashMap<String,Object> params = new HashMap<>();
        params.put("lon",77.1025);
        response = getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        int status = response.getStatusCode();
        //List<CategoriesObjectDTO> categoriesObjectDTOList = new LinkedList<>();
        ApiAsserts.assertEquals(status, 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");

        System.out.println("Cities Api Response Body: " + response.getBody().asString());
//        CitiesResponseDTO citiesResponseDTO = (CitiesResponseDTO) Helper.convertJsonToDTO(response.getBody(), CitiesResponseDTO.class.getCanonicalName());
//
//        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Category is found to be null");
    }


    @Test(testName = "Verify Cities api response", description = "verify Cities Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCitiesApiResponseWithCityIdsParam() throws Exception {
        HashMap<String,Object> params = new HashMap<>();
        params.put("city_ids","1,2,3");

        response = getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        int status = response.getStatusCode();
        //List<CategoriesObjectDTO> categoriesObjectDTOList = new LinkedList<>();
        ApiAsserts.assertEquals(status, 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");

        System.out.println("Cities Api Response Body: " + response.getBody().asString());
//        CitiesResponseDTO citiesResponseDTO = (CitiesResponseDTO) Helper.convertJsonToDTO(response.getBody(), CitiesResponseDTO.class.getCanonicalName());
//
//        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Category is found to be null");
    }

    @Test(testName = "Verify Cities api response", description = "verify Cities Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority = 1)
    public void verifyCitiesApiResponseWithCountParam() throws Exception {
        HashMap<String,Object> params = new HashMap<>();
        params.put("q","delhi");
        params.put("count",2);

        response = getCitiesApiResponseWithParams(global, user_key, cities_resource, ApiMethodConstants.GET,params);

        int status = response.getStatusCode();
        //List<CategoriesObjectDTO> categoriesObjectDTOList = new LinkedList<>();
        ApiAsserts.assertEquals(status, 200, "Status returned is incorrect");
        ApiAsserts.assertEquals(response.getContentType(), global.getBase().get_content_type(), "Content type does not match");

        System.out.println("Cities Api Response Body: " + response.getBody().asString());
//        CitiesResponseDTO citiesResponseDTO = (CitiesResponseDTO) Helper.convertJsonToDTO(response.getBody(), CitiesResponseDTO.class.getCanonicalName());
//
//        ApiAsserts.assertNotNull(citiesResponseDTO.getHas_more(), "Category is found to be null");
    }

    @Test(testName = "Verify Cities api response with invalid user key", description = "verify categories Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 2)
    public void verifyUsersApiResponseWithInvalidUserKey() throws IOException, URISyntaxException {
        String user_key = "12234";
        response = getCategoriesApiResponse(global, user_key, cities_resource, ApiMethodConstants.GET);

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
    @Test(testName = "Verify Cities api response with POST method", description = "verify Cities Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 3)
    public void verifyCitiesApiResponseWithPOSTMethod() throws IOException, URISyntaxException {
        response = getCategoriesApiResponse(global, user_key, cities_resource, ApiMethodConstants.POST);

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

    @Test(testName = "Verify Cities api response with Invalid resource", description = "verify Cities Api response with status code 403", groups = {TestGroups.API, TestGroups.Regression}, priority = 4)
    public void verifyCitiesApiResponseWithInvalidResource() throws IOException, URISyntaxException {
        cities_resource = global.getBase().get_baseUrl() + "233444";
        response = getCategoriesApiResponse(global, user_key, cities_resource, ApiMethodConstants.GET);

        int statusCode = response.getStatusCode();
        System.out.println("User Api Response Body: " + response.getBody().asString());

        ApiAsserts.assertEquals(statusCode, 200, "Status returned is incorrect");
//        ApiAsserts.assertEquals(response.getContentType(),"", "Content type does not match");
    }
}
