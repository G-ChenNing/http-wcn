package com.github.wangchenning.httpwcn.http;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpHelper {


    public static String UrlBuilder(Map<String, Object> params) {
        String url = "?";
        if (params != null) {
            Set<Entry<String, Object>> entrys = params.entrySet();
            int size = entrys.size();
            int index = 0;
            for (Entry<String, Object> entry : entrys) {
                url += entry.getKey() + "=" + entry.getValue();
                if (++index < size) {
                    url += "&";
                }
            }
        }
        return url;

    }


}
