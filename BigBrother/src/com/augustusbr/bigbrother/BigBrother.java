package com.augustusbr.bigbrother;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public final class BigBrother {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.google.com");
        long stexec=0, endexec=0, elap=0;

        HttpResponse response1 = null;
        
		try {
			stexec = System.nanoTime();
			response1 = httpclient.execute(httpGet);
			endexec = System.nanoTime();
			elap = (endexec - stexec)/1000000;
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

        // The underlying HTTP connection is still held by the response object 
        // to allow the response content to be streamed directly from the network socket. 
        // In order to ensure correct deallocation of system resources 
        // the user MUST either fully consume the response content  or abort request 
        // execution by calling HttpGet#releaseConnection().

        try {
            System.out.println(response1.getStatusLine());
            System.out.println("Response Time (ms): " + elap);
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity1);
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
            httpGet.releaseConnection();
        }

        /*
        HttpPost httpPost = new HttpPost("http://targethost/login");
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        HttpResponse response2 = httpclient.execute(httpPost);

        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            httpPost.releaseConnection();
        }
        */
        
        try {
            PieChart demo = new PieChart("Comparison", "Which operating system are you using?");
            demo.pack();
            demo.setVisible(true);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
