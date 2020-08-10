package util;

import java.lang.reflect.Type;

import com.google.gson.Gson;


public class Helper {
    private static Gson gson = new Gson();

    /*Utility method to convert json input to dto object
     * json - The input json as String
     * containterClassName -  class name of the dto
     * Usage : listeningExternalDTO = (ListeningExternalDTO)Helper.convertJsonToDTO(json, ListeningExternalDTO.class.getCanonicalName());
     */
    public static Object convertJsonToDTO(String json, String dtoClassName) {
        //UiLogger.logInfo("Converting Json input to " + dtoClassName + " Object ");
        Object containerObject = null;
        //UiLogger.logInfo("Json is - " + json);
        try {
            containerObject = Class.forName(dtoClassName);
            ApiAsserts.assertNotNull(containerObject, "Failed to load the target class for Class Name: " + dtoClassName);
            containerObject = gson.fromJson(json, containerObject.getClass());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return containerObject;
    }

    /*Utility method to convert json input to dto object
     * json - The input json as String
     * Type -  Dynamic Type
     * Usage : Type lstGrps = new TypeToken<ArrayList<ListeningGroup>>(){}.getType();
     * lstGroups = (List<ListeningGroup>)Helper.convertJsonToDTO(response.getResponseBody(),lstGrps);
     */
    public static Object convertJsonToDTO(String json, Type type) {

        Object containerObject = null;

        try {
            containerObject = gson.fromJson(json, type);
        } catch (Exception ex) {
            System.out.println(json);
            ex.printStackTrace();
        }
        return containerObject;
    }

    /*Utility method to convert object to json string
     * object - Dynamic DTO object
     * Usage :
     * jsonString = Helper.convertDTOToJson(restrictedCallValidationResponse);
     */
    public static String convertDTOToJson(Object object) {
        try {
            return gson.toJson(object);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
