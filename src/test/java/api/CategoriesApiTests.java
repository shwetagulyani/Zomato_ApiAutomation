package api;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import common.Api_Base;
import dto.CategoriesDTO;
import dto.CategoriesResponseDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.*;

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

        categories_resource = global.getBase().get_categoriesResource();
        response = getCategoriesApiResponse(global,user_key,categories_resource,  ApiMethodConstants.GET);

        int status = response.getStatusCode();

        Assert.assertEquals(status, 200, "Status returned is incorrect");

        System.out.println("User Api Response Body: " + response.getBody().asString());

         //get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        ArrayList<CategoriesDTO> categoriesDTOArrayList;
        CategoriesDTO categoriesDTO = response.getBody().as(CategoriesDTO.class);

        CategoriesResponseDTO categoriesResponseDTO= (CategoriesResponseDTO) Helper.convertJsonToDTO(response.getBody(), CategoriesResponseDTO.class);
        ApiAsserts.assertNotNull(categoriesResponseDTO.getCategories(),"Category is found to be null");
        ApiAsserts.assertNotEmpty(categoriesResponseDTO.getCategories(), "Categories can not be null");



    }

}
