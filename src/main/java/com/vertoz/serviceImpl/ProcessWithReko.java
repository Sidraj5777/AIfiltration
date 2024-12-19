package com.vertoz.serviceImpl;

import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.DetectFacesRequest;
import com.amazonaws.services.rekognition.model.DetectFacesResult;
import com.amazonaws.services.rekognition.model.DetectModerationLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectModerationLabelsResult;
import com.amazonaws.services.rekognition.model.Image;

public class ProcessWithReko {

	private static final String ACCESS_KEY = "AWS access key"; // Replace with your AWS access key
    private static final String SECRET_KEY = "AWS secret key"; // Replace with your AWS secret key
    private static final String REGION = "AWS region"; // Specify your desired AWS region

    private static AmazonRekognition rekognitionClient;
    
    static {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        rekognitionClient = AmazonRekognitionClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(REGION)
                .build();
    }
    
    
	public void processWithRekognition(String imageUrl) {
        try {
        	
        	imageUrl ="https://images.unsplash.com/photo-1717388836215-1f443f01c4b3?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
        	
            // Create an InputStream from the image URL
            InputStream inputStream = new URL(imageUrl).openStream();
            byte[] imageBytes = inputStream.readAllBytes(); // Read image bytes

            if (imageBytes.length == 0) {
                System.out.println("Failed to fetch image or image is empty.");
                return;
            }
            
            System.out.println("Image fetched successfully. Size: " + imageBytes.length + " bytes");

            
            // Convert image bytes to Image object for Rekognition
            Image rekognitionImage = new Image()
                    .withBytes(ByteBuffer.wrap(imageBytes)); // Use ByteBuffer for image bytes

            // Create a request to detect moderation labels
            DetectModerationLabelsRequest request = new DetectModerationLabelsRequest()
                    .withImage(rekognitionImage)
                    .withMinConfidence(75F); // Set confidence threshold

            // Call AWS Rekognition
            DetectModerationLabelsResult result = rekognitionClient.detectModerationLabels(request);

            System.out.println("result :- " + result);
            
            
//            DetectFacesRequest requstfaces = new DetectFacesRequest()
//            		.withImage(rekognitionImage);
//            
//            DetectFacesResult resultfaces = rekognitionClient.detectFaces(requstfaces);
//            
//            System.out.println("result :- " + resultfaces);
            
            // Process results
            result.getModerationLabels().forEach(label -> {
                System.out.println("Detected label: " + label.getName() + ", Confidence: " + label.getConfidence());
                // Implement logic to block the creative based on labels
                if (label.getName().equalsIgnoreCase("Explicit Nudity") || label.getName().equalsIgnoreCase("Adult")) {
                    System.out.println("Content flagged as adult. Blocking creative.");
                    // Implement blocking logic (e.g., log the incident, notify advertisers, etc.)
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
