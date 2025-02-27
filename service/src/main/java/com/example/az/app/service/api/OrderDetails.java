package com.example.az.app.service.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Optional;

@Builder
public record OrderDetails(
        @NotBlank // bean validation used for capturing errors with the input
        String title,

        @NotBlank
        @Size(max = 20)
        String firstName,

        @NotBlank
        String lastName,

        Optional<@Past LocalDate> dateOfBirth) { // optional used here to represent non-mandatory values
}
