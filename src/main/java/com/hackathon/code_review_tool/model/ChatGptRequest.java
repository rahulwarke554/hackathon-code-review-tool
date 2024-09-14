package com.hackathon.code_review_tool.model;

import com.google.gson.annotations.SerializedName;

public class ChatGptRequest {
	
	private String model ="gpt-4o";
	
	private String prompt;
	
	private int temperature = 1;
	
	@SerializedName(value="max_tokens")
	private int maxtTokens = 100;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public int getMaxtTokens() {
		return maxtTokens;
	}

	public void setMaxtTokens(int maxtTokens) {
		this.maxtTokens = maxtTokens;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

}
