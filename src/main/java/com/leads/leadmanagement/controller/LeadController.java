package com.leads.leadmanagement.controller;

import com.leads.leadmanagement.dto.LeadDTO;
import com.leads.leadmanagement.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Controller for managing lead-related endpoints
 * This class exposes RESTful API endpoints for fetching, creating, and deleting leads.
 * It interacts with the {@link LeadService} to handle business logic.
 */
@RestController
@RequestMapping("/leads")
public class LeadController {
    private final LeadService leadService;

    /**
     * Constructor that initializes the LeadService
     * @param leadService The service to manage lead operations
     */
    public LeadController(LeadService leadService){
        this.leadService = leadService;
    }

    /**
     * Retrieves all leads
     * @return A {@link ResponseEntity} containing a list of {@link LeadDTO}s
     */
    @GetMapping
    public ResponseEntity<?> getAllLeads(){
        try {
            List<LeadDTO> leads = leadService.getAllLeads();
            return new ResponseEntity<>(leads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve leads", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Creates a new lead.
     *
     * @param leadDTO The {@link LeadDTO} to be created.
     * @return A {@link ResponseEntity} containing the created {@link LeadDTO}.
     */
    @PostMapping
    public ResponseEntity<?> createLead(@Valid @RequestBody LeadDTO leadDTO) {
        try {
            LeadDTO createdLead = leadService.saveLead(leadDTO);
            return new ResponseEntity<>(createdLead, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Duplicate entry or invalid data", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating lead", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
