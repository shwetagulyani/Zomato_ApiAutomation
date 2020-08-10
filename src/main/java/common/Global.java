package common;

import util.PropertyReader;
import util.RestUrlMapper;

import java.io.IOException;
import java.net.URISyntaxException;

public class Global {


    Api_Base base = new Api_Base();

    public Api_Base getBase() {
        return base;
    }

    public void setBaseUrl() throws IOException, URISyntaxException {
        String base_url = PropertyReader.fileload("base_url");
        base.set_baseUrl(base_url);
    }

    public void setUserKey() throws IOException, URISyntaxException {
        String user_key = PropertyReader.fileload("user_key");
        base.set_Userkey(user_key);
    }

    public void setCategoryResource() throws IOException, URISyntaxException {
        String categories_resourceUrlPath = RestUrlMapper.CATEGORIES_RESOURCE.getUrlPath();
        base.set_categoriesResource(categories_resourceUrlPath);
    }

    public void setCitiesResource() throws IOException, URISyntaxException {
        String cities_resourceUrlPath = RestUrlMapper.CITIES_RESOURCE.getUrlPath();
        base.set_citiesResource(cities_resourceUrlPath);
    }

    public void setContentType() throws IOException, URISyntaxException {
        String contentType = PropertyReader.fileload("content_type");
        base.set_content_type(contentType);
    }

    public String init() throws Exception {
        setBaseUrl();
        setContentType();
        setUserKey();
        String user_key = getBase().get_userkey();
        return user_key;
    }

}
