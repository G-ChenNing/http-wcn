//package com.github.wangchenning.httpwcn.http;
//
//import com.alibaba.fastjson.JSONObject;
//
//public class test {
//    public static void main(String[] args) {
//        DefaultHandle defaultHandle = new DefaultHandle();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("app_key","150751581616010122");
//        jsonObject.put("secret","15075150751581616010122");
//
//        String token = defaultHandle.getToken(jsonObject.toJSONString());
//        System.out.println(token);
//
//        JSONObject jsonObject1 = JSONObject.parseObject(token);
//
//        DefaultHandle defaultHandle2 = new DefaultHandle("http://117.27.128.121:18081/input/http/iot/ict/v2/data/httpinput");
//
//        JSONObject jsonObject2 = new JSONObject();
//        jsonObject2.put("app_key", "150751581616010122");
//        jsonObject2.put("device_id", "AE10-12424-12414");
//        jsonObject2.put("lighting_status", "");
//        jsonObject2.put("brightness", "");
//        jsonObject2.put("voltage", "");
//        jsonObject2.put("electricity", "");
//        jsonObject2.put("charge_status", "");
//        jsonObject2.put("charge_port", "");
//        jsonObject2.put("alarm_type", "0");
//        jsonObject2.put("recordtime", "");
//
//        String s = defaultHandle2.uploadMessage(jsonObject2.toJSONString(),jsonObject1.getString("accessToken"));
//        System.out.println(s);
//        s.toLowerCase().contains("SNAPSHOT".toLowerCase());
//    }
//}
