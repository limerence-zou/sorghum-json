package site.sorghum.json.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
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
@SuppressWarnings({"rawtypes", "AlibabaClassNamingShouldBeCamel", "unused", "AlibabaLowerCamelCaseVariableNaming", "unchecked"})
public class JSONObject extends HashMap {
    public JSONObject() {
    }

    public JSONObject(Object o){
        JSONObject jsonObject = JsonUtils.toJsonObject(o);
        this.putAll(jsonObject);
    }

    public JSONObject(String o){
        JSONObject jsonObject = JsonUtils.toJsonObject(o);
        this.putAll(jsonObject);
    }

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

    public Date getDate(Object key) {
        Object value = this.get(key);
        return TypeUtils.castToDate(value);
    }

    public JSONObject getJSONObject(Object key){
        Object v = this.get(key);
        return JsonUtils.toJsonObject(JsonUtils.toJsonString(v));
    }

    public JSONArray getJSONArray(Object key){
        Object v = this.get(key);
        return JsonUtils.toJsonArray(JsonUtils.toJsonString(v));
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Object key, Class<T> valueType) {
        Object v = this.get(key);
        return (T) v;
    }

    public String toJSONString(){
        return JsonUtils.toJsonString(this);
    }

    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }
}
