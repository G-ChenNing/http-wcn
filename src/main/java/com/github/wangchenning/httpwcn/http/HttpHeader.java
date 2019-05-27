package com.github.wangchenning.httpwcn.http;

import org.apache.http.client.methods.HttpRequestBase;

public interface HttpHeader {

	void AddHader(HttpRequestBase requset, boolean isupload) ;
}
