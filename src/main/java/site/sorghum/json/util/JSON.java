package site.sorghum.json.util;

import org.springframework.stereotype.Component;
import site.sorghum.json.entity.JSONObject;
import java.io.IOException;

/**
 * @author Sorghum
 */
@SuppressWarnings({"unused", "AlibabaClassNamingShouldBeCamel"})
@Component
public class JSON extends JsonUtils {
    public static JSONObject toJSON(Object json){
        return JsonUtils.toJSONObject(json);
    }

    public static JSONObject toJSON(String json){
        return JsonUtils.toJSONObject(json);
    }

    public static Object parse(String json){
        return JsonUtils.toObject(json);
    }

    public static  <T> T toJavaObject(String json, Class<T> valueType){
        return JsonUtils.toObject(json, valueType);
    }
}
