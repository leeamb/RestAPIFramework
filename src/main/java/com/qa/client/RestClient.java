package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	
	/**
	 * GET method
	 * 1. Get request	
		//1. Http client creation
		//2. get request
		//3. execute GET request
	 * 2.Status Code
	 * 3. get response payload
	 	//1. retrive response body
	 	//2. parse the response to JSON format
	 * 4. Get All headers
	 	//1. retrive all headers in an array
	 	//2. create hash map to store it in key value pair
	 	//3. iterate through array to store data in hash 												map
	 * @param url
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	
	public void get(String url) throws ClientProtocolException, IOException {
	
		/*This line creates an instance of CloseableHttpClient using the HttpClients.createDefault() method. 
		This client will be used to send the HTTP request.*/
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//This object represents http GET request
		HttpGet httpget = new HttpGet(url); 
		
		/*This line executes the GET request using the httpClient and 
		 * stores the response from the server in a CloseableHttpResponse object.*/
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); // hit the get URL
		
		
	//2. Status Code
		/*This line retrieves the status code from the response using getStatusCode() method. 
		 * The status code indicates whether the request was successful 
		 * (e.g., 200 for OK) or resulted in an error (e.g., 404 for Not Found). 
		 * The code then prints the status code to the console.*/
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is ...."+statusCode);
		
		
	// 3. get response payload	
		/*This line retrieves the response body (payload) from the response object. 
		 * It uses the EntityUtils.toString() method with character encoding "UTF-8" to convert the response entity 
		 * (which might be in binary format) to a String.*/
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		
		/*this line parses the responseString into a JSONObject object using the JSONObject class 
		 * (likely from a JSON parsing library). This allows you to access the data within the JSON response more easily.*/
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response in json format:  "+responseJson);
		
		
	//4. All headers
		/* This line retrieves all the headers sent by the server in the response using getAllHeaders() method. 
		 * It stores them in an array of Header objects.*/
		Header[] headerArray = closeableHttpResponse.getAllHeaders();
		
		//a HashMap is created to store the headers in a key-value format for easier access.
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		
		//This loop iterates through the headerArray and adds each header's name and value to the allHeaders map.
		for(Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array---"+allHeaders);
	}

}
