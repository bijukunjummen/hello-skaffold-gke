package org.bk.web;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(GreetingsController.class)
class GreetingsControllerTest {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void greetingsWithCannedMessage() {
		webTestClient.get()
				.uri("/greetings")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectBody()
				.jsonPath("$.payload").isEqualTo("Hello");
	}

	@Test
	void greetingsWithPayload() {
		webTestClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/greetings")
						.queryParam("payload", "Good Morning").build())
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectBody()
				.jsonPath("$.payload").isEqualTo("Good Morning");
	}
}
