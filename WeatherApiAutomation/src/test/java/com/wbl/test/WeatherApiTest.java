package com.wbl.test;

import static org.testng.Assert.*;

//import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.wbl.base.BaseApi;
import com.wbl.base.BaseApiTest;
import com.wbl.helper.RestResponse;

public class WeatherApiTest extends BaseApiTest {
	
	BaseApi api;
	RestResponse restResponse;
	@BeforeClass
	public void beforeClass(){
		api= new BaseApi(endPoint);
	}
	@Test
	public void getTest(){
	restResponse= api.get("/weather?zip=95009,us",Key);
	System.out.println("Get request status code :"+restResponse.getStatusCode());
	System.out.println("Get request status message :"+restResponse.getStatusMessage());
	assertEquals(restResponse.getStatusCode(),200);
	assertTrue(restResponse.getStatusMessage().contains("OK"));
	JSONObject jsonObject= new JSONObject(restResponse.getPayLoad());
	System.out.println(jsonObject.toString());
//	JSONArray jsonArray= new JSONArray(restResponse.getPayLoad());
//	System.out.println(jsonArray.toString());
//	System.out.println("id :"+ ((JSONObject) jsonArray.get(0)).get("id"));
	}
	@Test(enabled=false)
	public void postTest(){
	restResponse= api.post("/weather?zip=95009,us",Key);
	System.out.println("post request status code :"+restResponse.getStatusCode());
	System.out.println("post request status message :"+restResponse.getStatusMessage());
	assertEquals(restResponse.getStatusCode(), 201);
	assertTrue(restResponse.getStatusMessage().contains("Created"));
	JSONObject jsonObject= new JSONObject(restResponse.getPayLoad());
	System.out.println(jsonObject.toString());
	//System.out.println("id"+ jsonObject.getInt("id"));
	}

}
