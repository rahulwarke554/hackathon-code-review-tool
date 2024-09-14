package com.hackathon.code_review_tool.model;

import java.util.List;

public class ChatGptResponse {
	
	List<ChatGptChoices> choiceList;

	public List<ChatGptChoices> getChoiceList() {
		return choiceList;
	}

	public void setChoiceList(List<ChatGptChoices> choiceList) {
		this.choiceList = choiceList;
	}

}
