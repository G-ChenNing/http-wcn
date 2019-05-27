package com.github.wangchenning.httpwcn.http;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class HttpGetMethod implements RequestMethod {

	private HttpUrl url;
	private final HttpGet request;
	private boolean isUpload=false;
	private Map<String, Object> urlParamter;

	public HttpGetMethod(HttpUrl url) {
		this.url = url;
		request = new HttpGet();
	}
 
	@Override
	public void setEntity(HttpEntity paramer) {
		this.setEntity(paramer.toMap());
	}

	@Override
	public void setEntity(Map<String, Object> urlParamter) {
		this.urlParamter = urlParamter;
	}

	@Override
	public String run(HttpHeader header) {
		String strResult = "";
		try {
			header.AddHader(request,isUpload);
			request.setURI(this.urlParamter==null? url.getUrl():this.url.getUrl(this.urlParamter));
			HttpClient client = HttpClientBuilder.create().build();
			HttpResponse response = client.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/
				strResult = EntityUtils.toString(response.getEntity());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strResult;

	}

}
