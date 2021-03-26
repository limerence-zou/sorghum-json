package site.sorghum.json.entity;

import site.sorghum.json.util.JsonUtils;
import site.sorghum.json.util.TypeUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author: Sorghum 和 FastJson相关人员
 * @Date: 2021/3/25 15:23
 */
@SuppressWarnings("rawtypes")
public class JsonObject extends HashMap {
    public String getString(Object key) {
        return TypeUtils.castToString(this.get(key));
    }

    public Integer getInteger(Object key) {
        return TypeUtils.castToInt(this.get(key));
    }

    public long getLong(Object key) {
        return TypeUtils.castToLong(this.get(key));
    }

    public double getDouble(Object key) {
        return TypeUtils.castToDouble(this.get(key));
    }

    public boolean getBoolean(Object key) {
        return TypeUtils.castToBoolean(this.get(key));
    }

    public Date getDate(Object key) throws ParseException {
        Object value = this.get(key);
        return TypeUtils.castToDate(value);
    }

    public JsonObject getJsonObject(Object key) throws IOException {
        Object v = this.get(key);
        return JsonUtils.toJsonObject(JsonUtils.toJsonString(v));
    }
    public JsonArray getJsonArray(Object key) throws IOException {
        Object v = this.get(key);
        return JsonUtils.toJsonArray(JsonUtils.toJsonString(v));
    }
    @SuppressWarnings("unchecked")
    public <T> T getObject(Object key, Class<T> valueType) {
        Object v = this.get(key);
        return (T) v;
    }
}
