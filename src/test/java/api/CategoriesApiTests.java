package api;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import common.Api_Base;
import dto.CategoriesDTO;
import dto.CategoriesResponseDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.ApiMethodConstants;
import util.Global;
import util.Helper;
import util.TestGroups;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class CategoriesApiTests extends ZomatoApiActions{
    Response response;

    Global global = new Global();
    String categories_resource;
    String user_key;

    @BeforeTest
    public void setup_urls() throws IOException, URISyntaxException
    {
        global.setBaseUrl();
        global.setCategoryResource();
        global.setContentType();
        global.setUserKey();
        user_key = global.getBase().get_userkey();
        System.out.println(global.getBase().get_userkey());
        categories_resource = global.getBase().get_categoriesResource();
    }


    @Test(testName = "Verify users api response", description= "verify users Api response with status code 200", groups = {TestGroups.API, TestGroups.Sanity}, priority=1)
    public void verifyUsersApiResponse() throws IOException, URISyntaxException
    {

        response = getCategoriesApiResponse(global,user_key,categories_resource,  ApiMethodConstants.GET);

        int status = response.getStatusCode();

        Assert.assertEquals(status, 200, "Status returned is incorrect");

        System.out.println("User Api Response Body: " + response.getBody().asString());

         //get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        ArrayList<CategoriesDTO> categoriesDTOArrayList;
        CategoriesDTO categoriesDTO = response.getBody().as(CategoriesDTO.class);

        CategoriesResponseDTO categoriesResponseDTO= (CategoriesResponseDTO) Helper.convertJsonToDTO(response.getBody(), CategoriesResponseDTO.class);

//
//        // simply query the JsonPath object to get a String value of the node
//        // specified by JsonPath
//        String first_name = jsonPathEvaluator.get("[0].first_name");
//        String last_name = jsonPathEvaluator.get("[0].last_name");
//        String career = jsonPathEvaluator.get("[0].career");
//        String phone = jsonPathEvaluator.get("[0].phone");
//
//        // Validate the response
//        ApiAsserts.assertNotEmpty(response.getBody().asString(),"Users api response is empty");
//        ApiAsserts.assertNotEmpty(first_name, "first name  is empty in the Response");
//        ApiAsserts.assertNotEmpty(last_name, "last name  is empty in the Response");
//        ApiAsserts.assertNotEmpty(career, "career  is empty in the Response");
//        ApiAsserts.assertNotEmpty(phone, "phone  is empty in the Response");

    }

}
