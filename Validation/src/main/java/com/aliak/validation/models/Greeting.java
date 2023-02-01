package com.aliak.validation.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Greeting {
    @NotNull(message = "The message should not be empty")
    @NotEmpty(message = "The message should not be empty")
    private String msg;
    @NotNull(message = "The FROM should not be empty")
    @NotEmpty(message = "The FROM should not be empty")
    private String from;
    @NotNull(message = "The TO should not be empty")
    @NotEmpty(message = "The TO should not be empty")
    private String to;
}
