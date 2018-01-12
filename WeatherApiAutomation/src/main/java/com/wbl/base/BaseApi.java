package com.wbl.base;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.wbl.helper.RestResponse;

public class BaseApi {

	private String url;
	RestResponse restResponse;
	HttpClient httpClient;

public BaseApi(String url){
	this.url=url;
	httpClient= HttpClientBuilder.create().build();
	setAuthentication();
}

private void setAuthentication() {
}
public RestResponse get(String resource,String Key){
	HttpGet get= new HttpGet(url+resource);
	get.addHeader("x-api-key",Key);
	restResponse= new RestResponse();
	try {
		HttpResponse response= httpClient.execute(get);
		restResponse.setStatusCode(response.getStatusLine().getStatusCode());
		restResponse.setStatusMessage(response.getStatusLine().toString());
		restResponse.setPayLoad(IOUtils.toString(response.getEntity().getContent()));
		
	} catch (ClientProtocolException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return restResponse;
}
public RestResponse post(String resource,String Key){
	HttpPost post= new HttpPost(url+resource);
	restResponse= new RestResponse();
	try {
		post.setHeader("content-type","application/json");
		post.addHeader("x-api-key",Key);
		HttpEntity entity= new StringEntity(createRequestPayload());
		post.setEntity(entity);
	
		HttpResponse response= httpClient.execute(post);
		restResponse.setStatusCode(response.getStatusLine().getStatusCode());
		restResponse.setStatusMessage(response.getStatusLine().toString());
		restResponse.setPayLoad(IOUtils.toString(response.getEntity().getContent()));
		
	} catch (ClientProtocolException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return restResponse;
}
public String createRequestPayload() {
	String reqPayLoad= "{\"temp\": 218.64,\"pressure\": 1019,\"humidity\":72,\"temp_min\": 286.15,\"temp_max\": 291.15}";
	return reqPayLoad;
}	
	
	
	
}
