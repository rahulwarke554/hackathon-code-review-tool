package com.hackathon.code_review_tool.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackathon.code_review_tool.model.SearchContent;
import com.hackathon.code_review_tool.service.ChatGptService;


@RestController

@RequestMapping("/api/gpt")
public class GPTController {
	
	private ChatGptService chatGptService;

    public GPTController(ChatGptService chatGptService) {
		super();
		this.chatGptService = chatGptService;
	}

	@PostMapping("/searchRequst")
    public String  searchRequst(@RequestBody SearchContent searchContent) {
		
    	System.out.println("data "+searchContent.getSearchQuery());
    	
        return chatGptService.processSearch(searchContent.getSearchQuery());
    }
}

