package com.github.wangchenning.httpwcn.http;


import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class HttpEntity {

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        try {

            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;

    }

    public String toJson() {
//
//        Gson json = new Gson();
//        return json.toJson(this);
        return JSON.toJSONString(this);

    }
}
