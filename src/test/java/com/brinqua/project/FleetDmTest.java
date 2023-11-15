package com.brinqua.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FleetDmTest {

	private FleetDm fleetDm;

	private String authUrl;
	private String email;
	private String password;
	private String tokenUrl;

	@BeforeEach
	public void setUp() {
		fleetDm = new FleetDm();
		authUrl = "http://10.10.17.162:1337";
		email = "admin@example.com";
		password = "preview1337#";
		tokenUrl = "http://10.10.17.162:1337";
	}

	@Test
	public void testExtractApiKey_SuccessfulLogin() throws IOException {

		String apiKey = fleetDm.ExtractApiKey(authUrl, email, password);
		assertNotNull(apiKey);
		assertTrue(apiKey.length() > 0);
	}
	
	@Test
	public void fetchTargets_SuccessfulRequest() throws Exception {

		String result = fleetDm.fetchTargets(authUrl, email, password, tokenUrl);
		assertNotNull(result);
		assertTrue(result.contains("targets")); // it has in out put
	}

	@Test
	public void testSuccessfulFetchHostsData() throws Exception {

		String result = fleetDm.fetchHostsData(authUrl, email, password, tokenUrl);
		assertTrue(result.contains("hosts"));
		assertNotEquals(null, result);
	}
	@Test
	public void testSuccessfulFetchSoftwareData() throws Exception {
		String result = fleetDm.FetchSoftwaresData(authUrl, email, password, tokenUrl);
		assertTrue(result.contains("software"));
		assertNotEquals(null, result);
	}
	
//****************************************************************************************************
	@ParameterizedTest
	@CsvSource({ "2313546" })
	public void testExtractApiKey_FailedLogin(String password) throws IOException {

		String result = fleetDm.ExtractApiKey(authUrl, email, password);
		assertEquals(null, result);

	}
	
	@ParameterizedTest
	@CsvSource({ "112223556" })
	public void fetchTargets_FailedRequest(String password) throws Exception {
		String result = fleetDm.fetchTargets(authUrl, email, password, tokenUrl);
		assertTrue(result.contains("API request failed with status code: 401")); // failure message
	}
	
	@ParameterizedTest
	@CsvSource({ "112223556" })
	public void fetchHosts_FailedRequest(String password) throws Exception {
		String result = fleetDm.fetchHostsData(authUrl, email, password, tokenUrl);
		assertTrue(result.contains("API request failed with status code: 401")); // failure message
	}
	
	@ParameterizedTest
	@CsvSource({ "112223556" })
	public void fetchSoftwares_FailedRequest(String password) throws Exception {
		String result = fleetDm.FetchSoftwaresData(authUrl, email, password, tokenUrl);
		assertTrue(result.contains("API request failed with status code: 401")); // failure message
	}
	
//****************************************************************************************************

	@Test
	public void testExtractApiKey_ExceptionThrown() {
		assertThrows(Exception.class, () -> fleetDm.ExtractApiKey(anyString(), anyString(), anyString()));
	}

//****************************************************************************************************

	@Test
	void testFetchTargetsIOException() {
		assertThrows(IOException.class, () -> {
			fleetDm.fetchTargets(anyString(), anyString(), anyString(), anyString());
		});
	}

	@Test
	void testFetchTargetsClientProtocolException() {
		assertThrows(ClientProtocolException.class, () -> {
			fleetDm.fetchTargets(anyString(), anyString(), anyString(), anyString());
		});
	}

	@Test
	void testFetchTargetsGenericException() {

		assertThrows(Exception.class, () -> {
			fleetDm.fetchTargets(anyString(), anyString(), anyString(), anyString());
		});
	}

//****************************************************************************************************

	@Test
	void testFetchHostsIOException() {
		assertThrows(IOException.class, () -> {
			fleetDm.fetchHostsData(anyString(), anyString(), anyString(), anyString());
		});
	}

	@Test
	void testFetchHostsClientProtocolException() {
		assertThrows(ClientProtocolException.class, () -> {
			fleetDm.fetchHostsData(anyString(), anyString(), anyString(), anyString());
		});
	}

	@Test
	void testFetchHostsGenericException() {

		assertThrows(Exception.class, () -> {
			fleetDm.fetchHostsData(anyString(), anyString(), anyString(), anyString());
		});
	}

//****************************************************************************************************
	@Test
	void testFetchSoftWareIOException() {
		assertThrows(IOException.class, () -> {
			fleetDm.FetchSoftwaresData(anyString() , anyString(), anyString(), anyString());
		});
	}

	@Test
	void testFetchSoftWareClientProtocolException() {
		assertThrows(ClientProtocolException.class, () -> {
			fleetDm.FetchSoftwaresData(anyString(), anyString(), anyString(), anyString());
		});
	}

	@Test
	void testFetchSoftWareGenericException() {

		assertThrows(Exception.class, () -> {
			fleetDm.FetchSoftwaresData(anyString(), anyString(), anyString(), anyString());
		});
	}
	
	//****************************************************************************************************

		@Test
		public void fetchApiKey() throws Exception {
			String apiKey = fleetDm.ExtractApiKey(authUrl, email, password);
			System.out.println(apiKey);
		}

		@Test
		public void fetchallTargets() throws Exception {
			String fetchTargets = fleetDm.fetchTargets(authUrl, email, password, tokenUrl);
			System.out.println(fetchTargets);
		}

		@Test
		public void getALLHOsts() throws Exception {
			String fetchHostsData = fleetDm.fetchHostsData(authUrl, email, password, tokenUrl);
			System.out.println(fetchHostsData);
		}

		@Test
		public void getALLSoftwares() throws Exception {
			String fetchSoftware = fleetDm.FetchSoftwaresData(authUrl, email, password, tokenUrl);
			System.out.println(fetchSoftware);
		}
}
