package com.onebill.billingapp.productcontrollertest;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tests {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}

	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateBundel() {

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("planDetailId", "17");
		requestParams.put("details", "car rental charged on hourily bases");
		requestParams.put("planType", "hourly car rental");
		requestParams.put("planId", 6);

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.put("/billingapp/plandetails/manage-bundle");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response body: " + response.body().asString());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateCharges() {

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("chargeId", "17");
		requestParams.put("chargeFor", "4 hours");
		requestParams.put("chargeFrequency", "per hour");
		requestParams.put("charge", 20.0);
		requestParams.put("chargeType", "one time");
		requestParams.put("planId", "1");

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.put("/billingapp/charges/manage-charges");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response body: " + response.body().asString());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateService() {

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("serviceId", "3");
		requestParams.put("serviceName", "messaging");
		requestParams.put("serviceType", "messaging services");
		requestParams.put("companyId", "1");

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());

		Response response = request.put("/billingapp/product/manage-product");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		System.out.println("Response body: " + response.body().asString());

	}
}
