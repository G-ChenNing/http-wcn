package com.github.wangchenning.httpwcn.http;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class HttpDeleteMethod implements RequestMethod {
	private HttpUrl url;
	private final HttpDelete request;
	private boolean isUpload=false;
	private String  onlyKey;
	public HttpDeleteMethod(HttpUrl url,String onlyKey) {
		this.url = url;
		this.onlyKey =onlyKey;
		request = new HttpDelete();
	}

	@Override
	public String run(HttpHeader header) {
		String strResult = "";
		try {
			header.AddHader(request,isUpload);
			request.setURI(this.onlyKey==null? url.getUrl():this.url.getUrl(this.onlyKey));
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

	@Override
	public void setEntity(HttpEntity paramer) {
		  this.setEntity(paramer.toMap());
	}

 
	@Override
	public void setEntity(Map<String, Object> paramer) {

	}

}
