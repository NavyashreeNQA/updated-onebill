package com.onebill.billingapp.productcontrollertest;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestSample {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}

	@Test
	public void testGetService() {
		RequestSpecification request = RestAssured.given();
		request.get("/billingapp/product/services");
	}
	
	@Test
	public void testGetPlan() {
		RequestSpecification request = RestAssured.given();
		request.get("/billingapp/productplan/plans");
	}
	
	@Test
	public void testGetCharges() {
		RequestSpecification request = RestAssured.given();
		request.get("/billingapp/plandetails/bundles");

	}
}
