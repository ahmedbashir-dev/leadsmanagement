package com.leads.leadmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) for representing lead information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeadDTO {
    private UUID id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String company;
    private String notes;
    private LocalDateTime createdAt = LocalDateTime.now();
}
