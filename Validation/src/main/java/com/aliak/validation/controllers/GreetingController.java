package com.aliak.validation.controllers;

import com.aliak.validation.models.Greeting;
import com.aliak.validation.services.GreetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @PostMapping
    public ResponseEntity<String> postGreeting
            (@RequestBody Greeting greeting){

        final String greetingMsg = service.saveGreeting(greeting);
        return  ResponseEntity
                .accepted()
                .body(greetingMsg);
    }
}
