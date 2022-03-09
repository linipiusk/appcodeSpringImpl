package com.ecommerce.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java.model.SignoutCheck;
import com.ecommerce.java.model.SignupLogin;
import com.ecommerce.java.service.SignupLoginService;

@RestController
@RequestMapping("/grocerystore")
public class SignupLoginController {

	@Autowired
	SignupLoginService signupLoginService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody SignupLogin details){
		
		signupLoginService.handleSignup(details);
		return ResponseEntity.ok("Successful");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody SignupLogin details){
		
		String userrole = signupLoginService.handleLogin(details);
		return ResponseEntity.ok(userrole);
	}
	
	@PostMapping("/logout/{username}")
	public ResponseEntity<SignoutCheck> logout(@PathVariable String username, @RequestParam String userrole){
		
		SignoutCheck response = signupLoginService.handleLogout(username, userrole);
		return ResponseEntity.ok(response);
	}
}
