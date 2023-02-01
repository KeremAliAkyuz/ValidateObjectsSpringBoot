package com.aliak.validation.services;

import com.aliak.validation.models.Greeting;
import com.aliak.validation.vaildators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final ObjectsValidator<Greeting> greetingObjectsValidator;
    public String saveGreeting(Greeting greeting) {
        var violations = greetingObjectsValidator.validate(greeting);
        if (!violations.isEmpty()){
            return String.join(" | ", violations);
        }
        final String greetingMsg = "Greeting message <<" +
                greeting.getMsg() +
                ">> from:" +
                greeting.getFrom().toUpperCase() +
                " to: " +
                greeting.getTo().toUpperCase();
        return greetingMsg;
    }
}
