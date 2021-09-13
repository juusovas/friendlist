package com.example.friendlist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.friendlist.domain.Friend;

@Controller
public class ControllerClass {

	// ATTRIBUUTISSA PIDETÄÄN KAVERILISTAA
	private List<Friend> friends = new ArrayList<>();
	
	
	// ENDPOINT LANDING PAGELLE, KUN SIVUSTOLLE
	// TULLAAN ENSIMMÄISEN KERRAN
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	
	public String start(@RequestParam(name="friend", required=false) String name, Model model) {
		
		System.out.println("You are in Controller");
		
		friends = new ArrayList<Friend>();
		Friend friend = new Friend();
		model.addAttribute("friend", friend);
		
		return "index";
	}
	
	// ENDPOINT
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String post(@ModelAttribute(name="friend") Friend friend, Model model ) {
		
		System.out.println("You are adding friends to the friendlist");
		
		friends.add(friend);
		model.addAttribute("friends", friends);
		
		System.out.println(friend);
		System.out.println(friends);
		
		
		// HALUTAAN TYHJÄTÄ LOMAKE SEURAAVAA VARTEN
		
		friend = new Friend();
		model.addAttribute("friend", friend);
		
		return "index";
	}

}
