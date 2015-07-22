package com.vg.spring.mvc;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMvcJsp.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })

/**
 * Has annotation integration test and could be executed as simple test
 * 
 * @author windname
 *
 */
public class WelcomeControllerTestIT {

	@Value("${local.server.port}")
	private int port;

	private URL base;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void getHello() throws Exception {
		String response = getData(base);
		System.out.println("Body: " + response);
		assertTrue(response.contains("welcome!"));
	}

	private String getData(URL url) throws Exception {
		StringBuilder builder = new StringBuilder();
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) (url).openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				builder.append(line);
			}
			in.close();
		} finally {
			if (null != connection) {
				connection.disconnect();
			}
		}
		String result = builder.toString();
		if (result.contains("error")) {
			throw new Exception("invalid response");
		}
		return result;
	}
}