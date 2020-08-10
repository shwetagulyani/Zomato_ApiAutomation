package util;

public enum RestUrlMapper {

    //API resources
    CATEGORIES_RESOURCE("/categories"),
    CITIES_RESOURCE("/cities");

    String baseUrl;

    RestUrlMapper(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUrlPath(String... args) {
        String format = String.format(this.baseUrl, (Object[]) args);
        return format;
    }

}
