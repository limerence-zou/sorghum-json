package site.sorghum.json.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.sorghum.json.entity.JSONArray;
import site.sorghum.json.entity.JSONObject;


import java.io.IOException;
import java.util.HashMap;

/**
 * @author Sorghum
 */
@Component
public class JsonUtils {
    public static ObjectMapper objectMapper;

    @Autowired
    public void setDatastore(ObjectMapper objectMapper) {
        JsonUtils.objectMapper = objectMapper;
    }

    public static String toJsonString(Object o) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

    public static <T> T toObject(String json, Class<T> valueType) throws IOException {
        return objectMapper.readValue(json, valueType);
    }
    public static JSONObject toJsonObject(String json) throws IOException {
        return JsonUtils.toObject(json, JSONObject.class);
    }
    public static JSONObject toJsonObject(Object json) throws IOException {
        return JsonUtils.toObject(JsonUtils.toJsonString(json), JSONObject.class);
    }
    public static JSONArray toJsonArray(String json) throws IOException {
        return JsonUtils.toObject(json, JSONArray.class);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> toObject(String json) throws IOException {
        return JsonUtils.toObject(json, HashMap.class);
    }

}
