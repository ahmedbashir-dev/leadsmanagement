package com.leads.leadmanagement.controller;

import com.leads.leadmanagement.dto.LeadDTO;
import com.leads.leadmanagement.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {
    private final LeadService leadService;

    public LeadController(LeadService leadService){
        this.leadService = leadService;
    }

    @GetMapping
    public ResponseEntity<List<LeadDTO>> getAllLeads(){
        List<LeadDTO> leads = leadService.getAllLeads();
        return new ResponseEntity<>(leads, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LeadDTO> createLead(@Valid @RequestBody LeadDTO leadDTO){
        LeadDTO createdLead = leadService.saveLead(leadDTO);
        return new ResponseEntity<>(createdLead, HttpStatus.CREATED);
    }
}
