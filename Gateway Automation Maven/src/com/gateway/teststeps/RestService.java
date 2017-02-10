package com.gateway.teststeps;

import static com.jayway.restassured.RestAssured.given;

import org.apache.commons.codec.binary.Base64;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RestService {

	Response response = null;
	private ExtentTest test;
	public RestService(ExtentTest test) {
		this.test = test;
	}

	public String generateBasicAuthHeader(String clientId, String clientSecret) {

		String plainCreds = clientId + ":" + clientSecret;

		byte[] bytesEncoded = Base64.encodeBase64(plainCreds.getBytes());
		String base64Creds = new String(bytesEncoded);

		String encodedString = "Basic " + base64Creds;
		Response response = given().header("Authorization", encodedString).parameter("grant_type", "client_credentials")
				.post("http://stage-gw.wavemakeronline.com/security-portal/oauth/token");

		return response.jsonPath().getString("access_token");

	}

	public void doGet(String clientId, String clientSecret, String Uri) {

		String token = "Bearer " + generateBasicAuthHeader(clientId, clientSecret);

		response = given().header("Authorization", token).get(Uri);
		
		if(response.getStatusLine().toString().contains("200")){
			
		test.log(LogStatus.PASS, "Status: "+response.getStatusLine().toString());
		test.log(LogStatus.PASS, "StatusCode: "+response.body().asString());
		}else{
			test.log(LogStatus.FAIL, "Status: "+response.getStatusLine().toString());
			test.log(LogStatus.FAIL, "Response Body: "+response.body().asString());
			
		}
		
		System.out.println(response.headers().toString());
		

	}

	public void doPost(String clientId, String clientSecret, String Uri, String body) {
		String token = "Bearer " + generateBasicAuthHeader(clientId, clientSecret);
		response = given().contentType("application/json").header("Authorization", token).body(body).post(Uri);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine().toString());
		System.out.println(response.headers().toString());
		System.out.println(response.body().asString());

	}

}
