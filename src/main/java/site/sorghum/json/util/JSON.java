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
    public static JSONObject toJSON(Object json) throws IOException {
        return JsonUtils.toJSONObject(json);
    }

    public static JSONObject toJSON(String json) throws IOException {
        return JsonUtils.toJSONObject(json);
    }

    public static Object parse(String json) throws IOException {
        return JsonUtils.toObject(json);
    }

    public static  <T> T toJavaObject(String json, Class<T> valueType) throws IOException {
        return JsonUtils.toObject(json, valueType);
    }
}
