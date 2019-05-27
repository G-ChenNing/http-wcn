package com.github.wangchenning.httpwcn.http;

import org.apache.http.client.methods.HttpPost;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

//import lombok.extern.slf4j.Slf4j;


@Service(value = "defaultHandle")
public class DefaultHandle implements HttpUrl {

    private String str;

    public DefaultHandle() {
        str = "http://117.27.128.121:18081/input/http/iot/ict/login";
    }

    public DefaultHandle(String str) {
        this.str = str;
    }

    @Override
    public URI getUrl(Object onlyKey) throws URISyntaxException {

        return new URI(str + "/" + onlyKey.toString());
    }

    @Override
    public URI getUrl() throws URISyntaxException {
        return new URI(str);
    }

    @Override
    public URI getUrl(Map<String, Object> paramer) throws URISyntaxException {

        return new URI(str + HttpHelper.UrlBuilder(paramer));
    }


    public String getToken(String body) {
        HttpPostMethod postMethod = new HttpPostMethod(this);
        postMethod.setEntity(body);
        String run = postMethod.run(BaseHaeder.getBaseHaeder());
        return run;
    }

    public String uploadMessage(String body, String authorization) {
        HttpPostMethod postMethod = new HttpPostMethod(this);
        postMethod.setEntity(body);
        HttpPost request = postMethod.getRequest();
        request.addHeader("app_key", "{150751581616010122}");
        request.addHeader("Authorization", "Bearer {" + authorization + "}");
        String run = postMethod.run(BaseHaeder.getBaseHaeder());
        return run;

    }


//    /*
//     * @param onenetId onenet 平台设备id
//     * */
//    public int update(DeviceModel model, String onenetId) {
//        HttpPutMethod putMethod = new HttpPutMethod(this, onenetId);
//        putMethod.setEntity(model.toJson());
//        String string = putMethod.run(OneNetHaeder.getOneNetHaeder());
//        System.out.println("OneNet返回值：" + string);
//        JsonParser parse = new JsonParser();
//        JsonObject jsonObject = (JsonObject) parse.parse(string);
//        return jsonObject.get("errno").getAsInt();
//
//    }
//
//    /*
//     * @param onenetId onenet 平台设备id
//     * */
//    public int updateJson(JSONObject json, String onenetId) {
//        HttpPutMethod putMethod = new HttpPutMethod(this, onenetId);
//        putMethod.setEntity(json.toJSONString());
//        String string = putMethod.run(OneNetHaeder.getOneNetHaeder());
//        System.out.println("OneNet返回值：" + string);
//        JsonParser parse = new JsonParser();
//        JsonObject jsonObject = (JsonObject) parse.parse(string);
//        return jsonObject.get("errno").getAsInt();
//
//    }
//
//    /*
//     *
//     * */
//    public DeviceBackModel add(DeviceModel model) {
//        HttpPostMethod postMethod = new HttpPostMethod(this);
//        String jsonStr = JSONObject.toJSONString(model);
//
////        postMethod.setEntity(model.toJson());
//        postMethod.setEntity(jsonStr);
//        String string = postMethod.run(OneNetHaeder.getOneNetHaeder());
//        System.out.println("OneNet返回值：" + string);
//        JsonParser parse = new JsonParser();
//        JsonObject jsonObject = (JsonObject) parse.parse(string);
//        if (jsonObject.get("errno").getAsInt() == 0) {
//            Gson gson = new Gson();
//            DeviceBackModel backModel = gson.fromJson(jsonObject.get("data"), DeviceBackModel.class);
//            return backModel;
//        }
//        return null;
//    }
//
//    /*
//     * @param onenetId onenet 平台设备id
//     * */
//    public int delete(String onenetId) {
//        HttpDeleteMethod putMethod = new HttpDeleteMethod(this, onenetId);
//        String string = putMethod.run(OneNetHaeder.getOneNetHaeder());
//        System.out.println("OneNet返回值：" + string);
//        JsonParser parse = new JsonParser();
//        JsonObject jsonObject = (JsonObject) parse.parse(string);
//        return jsonObject.get("errno").getAsInt();
//    }

}
