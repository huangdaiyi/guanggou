package com.hlhj.guanggou.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class HttpUtils {

	public static <T>  T sendGet(String url, Map<String, String> headers,  Class<T> clazz) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		
		connection.setRequestMethod("GET");
		setHeader(connection, headers);
		
		BufferedReader reader = null;
		StringBuffer response = new StringBuffer();
		try {
			int responseCode = connection.getResponseCode();
			if (isOK(responseCode)) {
				reader = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				String inputLine;

				while ((inputLine = reader.readLine()) != null) {
					response.append(inputLine);
				}
			} else {
				// TODO: failed
				System.out.println("get failed! resposne code:" + responseCode);
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		
		return JsonUtil.fromJson(response.toString(), clazz);

	}

	// HTTP POST request
	public static <T> T sendPost(String url, Object params, Map<String, String> headers, Class<T> clazz) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		setHeader(connection, headers);

		String jsonParam = JsonUtil.toJson(params);
		DataOutputStream outputStream = null;
		BufferedReader reader = null;
		StringBuffer response;
		try {
			connection.setDoOutput(true);
			outputStream = new DataOutputStream(connection.getOutputStream());
			outputStream.writeBytes(jsonParam);
			outputStream.flush();

			response = new StringBuffer();
			int responseCode = connection.getResponseCode();
			if (isOK(responseCode)) {

				reader = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				String inputLine;

				while ((inputLine = reader.readLine()) != null) {
					response.append(inputLine);
				}
			} else {
				// TODO: failed
				System.out
						.println("post failed! resposne code:" + responseCode);
			}
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
		 
		return JsonUtil.fromJson(response.toString(), clazz);

	}

	private static boolean isOK(int code) {
		// TODO: other code
		return code == 200;
	}
	
	private static void setHeader(HttpURLConnection connection, Map<String, String> headers){
		for (String key : headers.keySet()) {
			connection.setRequestProperty(key, headers.get(key));
		}
	}

//	private static void setCommomHeader(HttpURLConnection connection,
//			String token, String username) {
//		connection.setRequestProperty("X-Token", "token_value");
//		connection.setRequestProperty("X-Username", "username");
//		connection.setRequestProperty("Content-Type", "application/json");
//	}

}
