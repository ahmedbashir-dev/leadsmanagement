package com.leads.leadmanagement.service.impl;

import com.leads.leadmanagement.dto.LeadDTO;
import com.leads.leadmanagement.mapper.LeadMapper;
import com.leads.leadmanagement.model.Lead;
import com.leads.leadmanagement.repository.LeadRepository;
import com.leads.leadmanagement.service.LeadService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service implementation for managing leads.
 * This class handles business logic for lead operations such as saving, fetching, and deleting leads.
 * It interacts with the {@link LeadRepository} for data access and uses {@link LeadMapper} for mapping
 * between entities and DTOs.
 */
@Service
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;
    private final LeadMapper leadMapper;

    /**
     * Constructor for initializing the LeadRepository and LeadMapper.
     *
     * @param leadRepository The repository for performing database operations.
     * @param leadMapper The mapper for converting between Lead and LeadDTO.
     */
    public LeadServiceImpl(LeadRepository leadRepository, LeadMapper leadMapper){
        this.leadRepository = leadRepository;
        this.leadMapper = leadMapper;
    }

    /**
     * Saves a new lead.
     *
     * @param leadDTO The {@link LeadDTO} to be saved.
     * @return The saved {@link LeadDTO}.
     */
    @Override
    public LeadDTO saveLead(LeadDTO leadDTO) {
        Lead lead = leadMapper.leadDTOToLead(leadDTO);
        Lead savedLead = leadRepository.save(lead);
        return leadMapper.leadToLeadDTO(savedLead);
    }

    /**
     * Retrieves all leads.
     *
     * @return A list of {@link LeadDTO}s representing all leads.
     */
    @Override
    public List<LeadDTO> getAllLeads() {
        List<Lead> leads = leadRepository.findAll();
        return leadMapper.leadsToLeadDTOs(leads);
    }

    /**
     * Retrieves a lead by its unique identifier.
     *
     * @param id The UUID of the lead.
     * @return An {@link Optional} containing the corresponding {@link LeadDTO} if found.
     */
    @Override
    public Optional<LeadDTO> getLeadById(UUID id) {
        Optional<Lead> lead = leadRepository.findById(id);
        return lead.map(leadMapper::leadToLeadDTO);
    }

    /**
     * Deletes a lead by its unique identifier.
     *
     * @param id The UUID of the lead to delete.
     * @throws EntityNotFoundException if the lead with the specified ID does not exist.
     */
    @Override
    public void deleteLead(UUID id) {
        if(!leadRepository.existsById(id)){
            throw new EntityNotFoundException("Lead with id" + id + " not found");
        }
        leadRepository.deleteById(id);
    }
}
