package com.github.wangchenning.httpwcn.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpPutMethod implements RequestMethod {
	private HttpUrl url;
	private final HttpPut request;
	private boolean isUpload=false;
	private String  onlyKey;
	public HttpPutMethod(HttpUrl url,String onlyKey) {
		this.url = url;
		this.onlyKey =onlyKey;
		request = new HttpPut();
	}

	@Override
	public String run(HttpHeader header) {
		String resultString="";
		header.AddHader(request,isUpload);
		 
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			request.setURI( this.onlyKey==null? url.getUrl():url.getUrl(this.onlyKey));
			response = httpClient.execute(request);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			 
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}

	@Override
	public void setEntity(HttpEntity paramer) {
		  this.setEntity(paramer.toMap());
		
	}

	public void setEntity(String json) {
		 try
		 {
			 StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			 request.setEntity(entity);
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	}

	@Override
	public void setEntity(Map<String, Object> paramer) {
		if (paramer != null) {
			List<NameValuePair> paramList = new ArrayList<>();
			for (String key : paramer.keySet()) {
				paramList.add(new BasicNameValuePair(key, paramer.get(key).toString()));
			}
			try {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				request.setEntity(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 模拟表单
		}
		
	}

}
