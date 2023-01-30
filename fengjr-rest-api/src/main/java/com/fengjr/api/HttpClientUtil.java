package com.fengjr.api;


import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import android.content.Context;

public class HttpClientUtil {
	
	private static final int TIMEOUT = 60 * 1000;
	
	public static HttpClientUtil httpUtilInstance;
	
	public static HttpClientUtil getHttpUtilInstantce(){
		if(null == httpUtilInstance){
			httpUtilInstance = new HttpClientUtil();
		}
		return httpUtilInstance;
	}
	
	private HttpClient httpClient;

	
	public HttpResponse GetRequest(String url){
		HttpGet getReq = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = httpClient.execute(getReq);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	public void PostRequest(){
		
	}

	private HttpClientUtil(){
		httpClient = getTrustAllClient();
	}
	
	//获取普通的HttpClient
	public static HttpClient getClient() {
        BasicHttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
        HttpProtocolParams.setUseExpectContinue(params, true);

        SchemeRegistry schReg = new SchemeRegistry();
        schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));

        ClientConnectionManager connMgr = new ThreadSafeClientConnManager(params, schReg);
        LogHelper.d("httpClient", "normal http client");
        return new DefaultHttpClient(connMgr, params);
    }
	
	//获得普通的针对SSL的HttpClient
	public static HttpClient getHttpsClient() {
        BasicHttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
        HttpProtocolParams.setUseExpectContinue(params, true);

        SchemeRegistry schReg = new SchemeRegistry();
        schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));

        ClientConnectionManager connMgr = new ThreadSafeClientConnManager(params, schReg);
        LogHelper.d("httpClient", "normal https client");
        return new DefaultHttpClient(connMgr, params);
    }
	
	//获得相信所有服务器证书的支持SSL证书的HttpClient
	public static HttpClient getTrustAllClient() {
        BasicHttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
        HttpProtocolParams.setUseExpectContinue(params, true);

        SchemeRegistry schReg = new SchemeRegistry();
        schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schReg.register(new Scheme("https", SSLTrustAllSocketFactory.getSocketFactory(), 443));

        ClientConnectionManager connMgr = new ThreadSafeClientConnManager(params, schReg);
        LogHelper.d("httpClient", "TrustAll https client");

        return new DefaultHttpClient(connMgr, params);
    }
	
	//获得制定服务器证书的支持SSL的HttpsClient
    public static HttpClient getCustomFengjrClient(Context context) {
        BasicHttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
        HttpProtocolParams.setUseExpectContinue(params, true);

        HttpConnectionParams.setConnectionTimeout(params, TIMEOUT);
        HttpConnectionParams.setSoTimeout(params, TIMEOUT);

        SchemeRegistry schReg = new SchemeRegistry();
        schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schReg.register(new Scheme("https", SSLFengjrSocketFactory.getSocketFactory(context), 443));

        ClientConnectionManager connMgr = new ThreadSafeClientConnManager(params, schReg);
        LogHelper.d("httpClient", "custom fengjr https client");
        return new DefaultHttpClient(connMgr, params);
    }

}
