package com.fengjr.api;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Created by suetming on 14-3-4.
 */
public class HttpRequestInterceptor implements ClientHttpRequestInterceptor {

	private static final String SET_COOKIE = "set-Cookie";
	private static final String COOKIE = "cookie";
	public static final String COOKIE_STORE = "cookieStore";

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] bytes,
			ClientHttpRequestExecution execution)
			throws IOException {
		List<String> cookies = request.getHeaders().get(COOKIE);
		// if the header doesn't exist, add any existing, saved cookies
		if (cookies == null) {
			List<String> cookieStore = (List<String>) StaticCacheHelper
					.retrieveObjectFromCache(COOKIE_STORE);
			// if we have stored cookies, add them to the headers
			if (cookieStore != null) {
				for (String cookie : cookieStore) {
					request.getHeaders()
							.add(COOKIE, cookie);
				}
			}
		}
		// execute the request
		ClientHttpResponse response = execution.execute(request, bytes);
		// pull any cookies off and store them
		if (response.getHeaders() == null) return response;
		cookies = response.getHeaders().get(SET_COOKIE);
		if (cookies != null) {
			StaticCacheHelper.storeObjectInCache(COOKIE_STORE,
					cookies);
		}
		return response;
	}
}
