package com.leads.leadmanagement.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class LeadDTO {
    private UUID id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String company;
    private String notes;
    private LocalDateTime createdAt;
}
