package com.vertoz.serviceImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RedirectionCheck {

	
	public static void checkRedirect(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(false);  // Disable automatic redirects
            connection.connect();

            int status = connection.getResponseCode();
            if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM) {
                // Get redirected URL
                String redirectUrl = connection.getHeaderField("Location");
                System.out.println("Redirected to: " + redirectUrl);

                // You can recursively call this method to follow the redirects
                checkRedirect(redirectUrl);
            } else {
                System.out.println("Final URL: " + urlString + " (Response Code: " + status + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }	
	
}
