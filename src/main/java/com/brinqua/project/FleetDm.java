package com.brinqua.project;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.client5.http.HttpHostConnectException;
import org.apache.http.HttpResponse;

public class FleetDm {

	public FleetDm(CloseableHttpClient createExceptionMockHttpClient) {
		// TODO Auto-generated constructor stub
	}

	public FleetDm() {
		// TODO Auto-generated constructor stub
	}

	public String ExtractApiKey(String authUrl, String email, String password) throws IOException {
		String extractedApiKey = null;
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			// Create an HTTP POST request to the login endpoint

			// Set the email and password in the request body
			String requestBody = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";

			HttpPost httpPost = new HttpPost(authUrl + "/api/v1/fleet/login");
			httpPost.setEntity(new StringEntity(requestBody));

			// Execute the request
			HttpResponse response = httpClient.execute(httpPost);

			// Check if the request was successful (status code 200)
			if (response.getStatusLine().getStatusCode() == 200) {
				
				// Parse the response to extract the API key
				String responseBody = EntityUtils.toString(response.getEntity());

				// Parse the JSON response using Gson
				JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();

				// Extract the API key from the JSON response
				extractedApiKey = jsonResponse.get("token").getAsString();
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new ClientProtocolException("HTTP protocol error: " + e.getMessage(), e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Error executing HTTP request: " + e.getMessage(), e);
		}

		return extractedApiKey;
	}

	public String fetchTargets(String authUrl, String email, String password, String tokenUrl) throws IOException {
		String apiKey = ExtractApiKey(authUrl, email, password);
		String data = "";
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//			int pageNumber = 1;
//			int pageSize = 1;
//			// Construct the URL with pagination parameters
//	        String apiUrl = tokenUrl + "/api/v1/fleet/hosts?page=" + pageNumber + "&size=" + pageSize;
			String apiUrl = tokenUrl + "/api/v1/fleet/targets";
			HttpPost httpPost = new HttpPost(apiUrl);

			String query = "1";
			int hosts = 5;
			int lables = 7;
			String jsonBody = "{" + "\"query\":\"" + query + "\"," + "\"selected\":{" + "\"hosts\":[" + hosts + "],"
					+ "\"labels\":[" + lables + "]" + "}," + "\"include_observer\":true" + "}";

			httpPost.setEntity(new StringEntity(jsonBody));

			// Set the API token in the Authorization header
			httpPost.setHeader("Authorization", "Bearer " + apiKey);

			HttpResponse response = httpClient.execute(httpPost);

			if (response.getStatusLine().getStatusCode() == 200) {
				String responseBody = EntityUtils.toString(response.getEntity());
				data = responseBody;
			} else {
				data = ("API request failed with status code: " + response.getStatusLine().getStatusCode());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new ClientProtocolException("HTTP protocol error: " + e.getMessage(), e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Error executing HTTP request: " + e.getMessage(), e);
		}

		return data;
	}

	public String fetchHostsData(String authUrl, String email, String password, String tokenUrl) throws IOException {
		String apiKey = ExtractApiKey(authUrl, email, password);
		String data = "";

		String apiUrl = tokenUrl + "/api/v1/fleet/hosts";

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet(apiUrl);

			// Set the API token in the Authorization header
			httpGet.setHeader("Authorization", "Bearer " + apiKey);

			HttpResponse response = httpClient.execute(httpGet);

			if (response.getStatusLine().getStatusCode() == 200) {
				String responseBody = EntityUtils.toString(response.getEntity());

				data = responseBody;
			} else {
				data = ("API request failed with status code: " + response.getStatusLine().getStatusCode());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new ClientProtocolException("HTTP protocol error: " + e.getMessage(), e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Error executing HTTP request: " + e.getMessage(), e);
		}
		return data;
	}

	public String FetchSoftwaresData(String authUrl, String email, String password, String tokenUrl) throws IOException
		{
		String data = "";
		String ApiKey = ExtractApiKey(authUrl, email, password);

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet(tokenUrl + "/api/v1/fleet/software");

			// Set the API token in the Authorization header
			httpGet.setHeader("Authorization", "Bearer " + ApiKey);

			HttpResponse response = httpClient.execute(httpGet);

			if (response.getStatusLine().getStatusCode() == 200) {
				String responseBody = EntityUtils.toString(response.getEntity());

				data = responseBody;
			} else {
				data = ("API request failed with status code: " + response.getStatusLine().getStatusCode());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new ClientProtocolException("HTTP protocol error: " + e.getMessage(), e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Error executing HTTP request: " + e.getMessage(), e);
		}
		return data;
	}

//	******************************************************************************************************************************

	public void convertJsonToJavaHosts(String jsonHosts, int numOfHosts) {
		ArrayList<Host> Hlist = new ArrayList<>();// i we want what are the things then we can get those things
		try {
			Gson gson = new Gson();

			Targets targetsData = gson.fromJson(jsonHosts, Targets.class);

			if (targetsData != null) {
				List<Host> Hosts = targetsData.getHosts();

//		            int numberOfHostsToPrint = Math.min(10, hosts.size());
				System.out.println(Hosts.size());
				for (int i = 0; i < numOfHosts; i++) {
					Host host = Hosts.get(i);
					System.out.println("Host #" + (i + 1));
					System.out.println("Hostname: " + host.getHostname());
					System.out.println("Platform: " + host.getPlatform());
					// Print other fields as needed
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void convertJsonToJavaTargets(String jsonHosts) {
		ArrayList<Host> Hlist = new ArrayList<>();// we want what are the things then we can get those things
		try {
			Gson gson = new Gson();

			HostsData hostsData = gson.fromJson(jsonHosts, HostsData.class);

			if (hostsData != null) {
				Targets targets = hostsData.getTargets();

//		            int numberOfHostsToPrint = Math.min(10, hosts.size());
				System.out.println(targets);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void convertJsonToJavaSoftware(String jsonSoftware) {
		ArrayList<Host> Hlist = new ArrayList<>();// i we want what are the things then we can get those things
		try {
			Gson gson = new Gson();

			SoftwaresData softwaresData = gson.fromJson(jsonSoftware, SoftwaresData.class);

			System.out.println(softwaresData.getSoftwares());

			if (softwaresData != null) {
				List<SoftwareValue> softwares = softwaresData.getSoftwares();

//		            int numberOfHostsToPrint = Math.min(10, hosts.size());
//		            System.out.println(softwares.size());
				for (int i = 0; i <= 10; i++) {
					SoftwareValue software = softwares.get(i);
					System.out.println("software #" + (i + 1));
					System.out.println("software name : " + software.getName());
					System.out.println("version: " + software.getVersion());
					// Print other fields as needed
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
