package org.bk.web;

import org.bk.model.Message;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@GetMapping("/greetings")
	public ResponseEntity<Message> greetings() {
		return ResponseEntity.ok(new Message("Hello"));
	}

	@GetMapping(path = "/greetings", params = "payload")
	public ResponseEntity<Message> greetings(@RequestParam("payload") String payload) {
		return ResponseEntity.ok(new Message(payload));
	}
}
