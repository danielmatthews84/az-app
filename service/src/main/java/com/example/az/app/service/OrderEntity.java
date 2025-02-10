package com.example.az.app.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    private UUID id; // UUID as PK might be preferrable in a distributed system/db over a sequential number

    private String title;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID();
    }
}