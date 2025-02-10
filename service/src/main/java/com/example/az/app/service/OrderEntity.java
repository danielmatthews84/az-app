package com.example.az.app.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
public class OrderEntity {

    @Id
    private UUID id;

    private String title;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    protected OrderEntity() {
    }

    public OrderEntity(String title,
                       String firstName,
                       String lastName,
                       LocalDate dateOfBirth) {
        id = UUID.randomUUID();
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}