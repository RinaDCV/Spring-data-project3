package com.skillstorm.project3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class WelcomeController {
	
	@RestController
	@RequestMapping ("/welcome")
	public class WecomeController {
		
		@GetMapping
		public String Welcome() {
			return "Welcome";
		}
	}
}
