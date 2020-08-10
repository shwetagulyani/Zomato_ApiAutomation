package util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.lang.reflect.Type;
import java.util.Objects;

public class JsonUtils {

    private static Gson gson;

    private static Gson getInstance() {
        return gson;
    }

    public static <T> String dtoToJson(T dto) {
        return getInstance().toJson(dto);
    }

    public static <T> T jsonToDto(String json, Type type) {
        return getInstance().fromJson(json, type);
    }

    public static <T> T jsonToDto(String json, Class<T> clazz) {
        return getInstance().fromJson(json, clazz);
    }

    public static <T> T jsonToDto(JsonReader reader, Class<T> clazz) {
        return getInstance().fromJson(reader, clazz);
    }
}
