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

@Service
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;
    private final LeadMapper leadMapper;

    public LeadServiceImpl(LeadRepository leadRepository, LeadMapper leadMapper){
        this.leadRepository = leadRepository;
        this.leadMapper = leadMapper;
    }

    @Override
    public LeadDTO saveLead(LeadDTO leadDTO) {
        Lead lead = leadMapper.leadDTOToLead(leadDTO);
        Lead savedLead = leadRepository.save(lead);
        return leadMapper.leadToLeadDTO(savedLead);
    }

    @Override
    public List<LeadDTO> getAllLeads() {
        List<Lead> leads = leadRepository.findAll();
        return leadMapper.leadsToLeadDTOs(leads);
    }

    @Override
    public Optional<LeadDTO> getLeadById(UUID id) {
        Optional<Lead> lead = leadRepository.findById(id);
        return lead.map(leadMapper::leadToLeadDTO);
    }

    @Override
    public void deleteLead(UUID id) {
        if(!leadRepository.existsById(id)){
            throw new EntityNotFoundException("Lead with id" + id + " not found");
        }
        leadRepository.deleteById(id);
    }
}
