package com.santosh.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
//    @Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name="sample-api", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name="sample-api")//limit the number of calls like 10000 calls per second
    @Bulkhead(name="sample-api")
    public ResponseEntity<?> sampleApi() {
        logger.info("sample-api call received");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-url", String.class);
        return responseEntity;
    }

    public ResponseEntity<?> hardcodedResponse(Exception ex) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Fallback-Response", HttpStatus.OK);

        return responseEntity;
    }
}
