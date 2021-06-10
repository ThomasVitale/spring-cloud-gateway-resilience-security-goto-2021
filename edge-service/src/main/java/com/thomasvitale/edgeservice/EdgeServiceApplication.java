package com.thomasvitale.edgeservice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class EdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeServiceApplication.class, args);
	}

	@Bean
	KeyResolver keyResolver() {
		return exchange -> Mono.just("USER");
	}

}

@RestController
class FallbackController {

	@GetMapping("/book-fallback")
	public Flux<String> getBookFallback() {
		return Flux.empty();
	}
}
