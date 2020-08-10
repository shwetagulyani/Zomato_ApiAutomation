package common;


public class Api_Base {

    private String userkey = null;
    private String base_url = null;
    private String content_type = null;
    private String categoriesResource = null;
    private String citiesResource = null;

    public void set_Userkey(String userkey) {
        this.userkey = userkey;
    }

    public String get_userkey() {
        return userkey;
    }

    public void set_baseUrl(String base_url) {
        this.base_url = base_url;
    }

    public String get_baseUrl() {
        return base_url;
    }

    public void set_content_type(String content_type) {
        this.content_type = content_type;
    }

    public String get_content_type() {
        return content_type;
    }

    public void set_categoriesResource(String categoriesResource) {
        this.categoriesResource = categoriesResource;
    }

    public String get_categoriesResource() {
        return categoriesResource;
    }

    public void set_citiesResource(String citiesResource) {
        this.citiesResource = citiesResource;
    }

    public String get_citiesResource() {
        return citiesResource;
    }

}

