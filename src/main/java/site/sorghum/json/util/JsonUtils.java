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

    public static String toJsonString(Object o) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public static <T> T toObject(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public static JSONObject toJsonObject(String json) {
        return JsonUtils.toObject(json, JSONObject.class);
    }

    public static JSONObject toJSONObject(Object json){
        return JsonUtils.toObject(JsonUtils.toJsonString(json), JSONObject.class);
    }

    public static JSONObject toJSONObject(String json) {
        return JsonUtils.toObject(json, JSONObject.class);
    }

    public static JSONObject toJsonObject(Object json){
        return JsonUtils.toObject(JsonUtils.toJsonString(json), JSONObject.class);
    }

    public static JSONArray toJsonArray(String json) {
        return JsonUtils.toObject(json, JSONArray.class);
    }

    public static JSONArray toJsonArray(Object json){
        return JsonUtils.toObject(JsonUtils.toJsonString(json), JSONArray.class);
    }

    public static JSONArray toJSONArray(String json){
        return JsonUtils.toObject(json, JSONArray.class);
    }

    public static JSONArray toJSONArray(Object json){
        return JsonUtils.toObject(JsonUtils.toJsonString(json), JSONArray.class);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> toObject(String json){
        return JsonUtils.toObject(json, HashMap.class);
    }

}
