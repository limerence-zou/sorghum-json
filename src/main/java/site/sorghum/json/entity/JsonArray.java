package site.sorghum.json.entity;

import site.sorghum.json.util.JsonUtils;
import site.sorghum.json.util.TypeUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: Sorghum
 * @Date: 2021/3/25 16:44
 */
public class JsonArray extends ArrayList<JsonObject> {

    public String getString(int index) {
        return TypeUtils.castToString(super.get(index));
    }

    public Integer getInteger(int index) {
        return TypeUtils.castToInt(super.get(index));
    }

    public long getLong(int index) {
        return TypeUtils.castToLong(super.get(index));
    }

    public double getDouble(int index) {
        return TypeUtils.castToDouble(super.get(index));
    }

    public boolean getBoolean(int index) {
        return TypeUtils.castToBoolean(super.get(index));
    }

    public Date getDate(int index) throws ParseException {
        Object value = super.get(index);
        return TypeUtils.castToDate(value);
    }

    public JsonObject getJsonObject(int index) throws IOException {
        Object v = super.get(index);
        return JsonUtils.toJsonObject(JsonUtils.toJsonString(v));
    }
    public JsonArray getJsonArray(int index) throws IOException {
        Object v = super.get(index);
        return JsonUtils.toJsonArray(JsonUtils.toJsonString(v));
    }
    @SuppressWarnings("unchecked")
    public <T> T getObject(int index, Class<T> valueType) {
        Object v = super.get(index);
        return (T) v;
    }
}
