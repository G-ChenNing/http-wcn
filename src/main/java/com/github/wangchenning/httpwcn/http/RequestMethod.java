package com.github.wangchenning.httpwcn.http;

import java.util.Map;


public interface RequestMethod {


    String run(HttpHeader header);

    void setEntity(HttpEntity paramer);

    void setEntity(Map<String, Object> paramer);




}
 