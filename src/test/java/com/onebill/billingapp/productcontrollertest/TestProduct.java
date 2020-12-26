package com.onebill.billingapp.productcontrollertest;


import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestProduct {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}


	@SuppressWarnings("unchecked")
	@Test
	public void testaddService() {

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("serviceName", "Car rental service");
		requestParams.put("serviceType", "Rental service");
		requestParams.put("companyId", "3");

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());

		Response response = request.post("/billingapp/product/service");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		System.out.println("Response body: " + response.body().asString());

	}

//	@SuppressWarnings("unchecked")
//	@Test
//	public void testaddPlans() {
//
//		RequestSpecification request = RestAssured.given();
//
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("planName", "happy riding");
//		requestParams.put("planType", "hourly car rental");
//		requestParams.put("data", "charged on hourily basis");
//		requestParams.put("amount", "400.0");
//		requestParams.put("planValidity", "on the day of usage");
//		requestParams.put("serviceId", "4");
//		requestParams.put("userId", "4");
//
//		request.header("Content-Type", "application/json");
//		request.body(requestParams.toJSONString());
//		Response response = request.post("/billingapp/productplan/plan");
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 200);
//		System.out.println("Response body: " + response.body().asString());
//	}

	@SuppressWarnings("unchecked")
	@Test
	public void testaddBundel() {

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("details", "car rental charged on hourily bases with free wifi facility");
		requestParams.put("planType", "hourly car rental");
		requestParams.put("planId", 6);

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.post("/billingapp/plandetails/bundle");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response body: " + response.body().asString());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testaddCharges() {

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("chargeFor", "3 hours");
		requestParams.put("chargeFrequency", "per hour");
		requestParams.put("charge", 1200.0);
		requestParams.put("chargeType", "one time");
		requestParams.put("planId", "1");

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.post("/billingapp/charges/charge");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Response body: " + response.body().asString());
	}
}


