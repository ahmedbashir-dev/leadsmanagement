package com.leads.leadmanagement.service;

import com.leads.leadmanagement.dto.LeadDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * LeadService interface for managing lead operations.
 */
public interface LeadService {

    LeadDTO saveLead(LeadDTO leadDTO);
    List<LeadDTO> getAllLeads();
    Optional<LeadDTO> getLeadById(UUID id);
    void deleteLead(UUID id);
}
