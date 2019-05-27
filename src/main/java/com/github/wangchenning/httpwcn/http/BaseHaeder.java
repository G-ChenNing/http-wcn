package com.github.wangchenning.httpwcn.http;

import org.apache.http.client.methods.HttpRequestBase;


public class BaseHaeder implements HttpHeader {

	private static final BaseHaeder instance;
	static
	{
		instance = new BaseHaeder();
	}
	@Override
	public void AddHader(HttpRequestBase requset,boolean isupload) {
//		requset.setHeader("api-key", "9ss7ke6Xdd1HYUrLZHWlME38wPQ=");
//		requset.setHeader("api-key", "=a2zSMV9ts3uSm=1IwPRkHJYWhQ=");
//		requset.setHeader("api-key", "HojvfViBVfEW5XLSM9VBEpRbh1k=");  //liangzhi
//		requset.setHeader("api-key", "UenWvyWFZKG=Lp8qj=JWy3T17UQ=");  //landsky
		if (!isupload) {
			requset.addHeader("Content-type","application/json; charset=utf-8");  
			requset.addHeader("Accept", "application/json");
		}
	}



	
	public static BaseHaeder getBaseHaeder()
	{
		 return instance ;
	}
	

	 

}
