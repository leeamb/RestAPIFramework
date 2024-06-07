package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {

	TestBase testBase;
	String weburl;
	String serviceUrl;
	String url;
	RestClient restClient;

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testBase = new TestBase();
		weburl = prop.getProperty("URL");
		serviceUrl = prop.getProperty("serviceURL");

		url = weburl + serviceUrl;
		System.out.println(url);
		// https://reqres.in//api/users

	}

	@Test
	public void getAPItest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		restClient.get(url);
	}

}
