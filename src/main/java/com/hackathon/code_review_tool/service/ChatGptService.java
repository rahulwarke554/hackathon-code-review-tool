package com.hackathon.code_review_tool.service;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hackathon.code_review_tool.model.ChatGptRequest;
import com.hackathon.code_review_tool.model.ChatGptResponse;


@Service
public class ChatGptService {
	
	@Value("${OPEN_AI_URL}")
	private String OPEN_AI_URL;
	
	@Value("${OPEN_AI_KEY}")
	private String OPEN_AI_KEY;
	
	public String processSearch(String search) {
		try {
		ChatGptRequest chatGptRequest = new ChatGptRequest();
		chatGptRequest.setPrompt(search);
	
		HttpPost post = new HttpPost(OPEN_AI_URL);
		post.addHeader("Content-type", "application/json");
		post.addHeader("Authorization", "Bearer " + OPEN_AI_KEY);
		Gson gson = new Gson();
		String body =gson.toJson(chatGptRequest);
		final StringEntity entity = new StringEntity(body);
		post.setEntity(entity);
		try(CloseableHttpClient client = HttpClients.custom().build();
				CloseableHttpResponse response = client.execute(post)){
			String responseBody = EntityUtils.toString(response.getEntity());
			System.out.println("responseBody" + responseBody);
			ChatGptResponse chatGptResponse = gson.fromJson(responseBody,ChatGptResponse.class);
			return chatGptResponse.getChoiceList().get(0).getText();
		}catch(Exception ee) {
			return "failed";
		}
		}catch(Exception ex)	{
			return "failed";
		}
		
		
	};

}
