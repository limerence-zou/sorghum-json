package site.sorghum.json.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
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
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel", "AlibabaLowerCamelCaseVariableNaming"})
public class JSONArray extends ArrayList<JSONObject> {

    public JSONArray() {
    }

    public JSONArray(Object o){
        JSONArray jsonArray = JsonUtils.toJsonArray(o);
        this.addAll(jsonArray);
    }
    public JSONArray(String o){
        JSONArray jsonArray = JsonUtils.toJsonArray(o);
        this.addAll(jsonArray);
    }
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

    public Date getDate(int index){
        Object value = super.get(index);
        return TypeUtils.castToDate(value);
    }

    public JSONObject getJSONObject(int index){
        Object v = super.get(index);
        return JsonUtils.toJsonObject(JsonUtils.toJsonString(v));
    }
    public JSONArray getJSONArray(int index){
        Object v = super.get(index);
        return JsonUtils.toJsonArray(JsonUtils.toJsonString(v));
    }
    @SuppressWarnings("unchecked")
    public <T> T getObject(int index, Class<T> valueType) {
        Object v = super.get(index);
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
