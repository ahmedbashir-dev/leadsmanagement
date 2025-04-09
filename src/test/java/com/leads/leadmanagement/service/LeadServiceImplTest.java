package com.leads.leadmanagement.service;

import com.leads.leadmanagement.dto.LeadDTO;
import com.leads.leadmanagement.mapper.LeadMapper;
import com.leads.leadmanagement.model.Lead;
import com.leads.leadmanagement.repository.LeadRepository;
import com.leads.leadmanagement.service.impl.LeadServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class LeadServiceImplTest {

    @Mock
    private LeadRepository leadRepository;

    @Mock
    private LeadMapper leadMapper;

    @InjectMocks
    private LeadServiceImpl leadService;

    private Lead lead;
    private LeadDTO leadDTO;
    private UUID leadId;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        leadId = UUID.randomUUID();
        lead = new Lead(leadId, "Jason Smith", "jason@example.com", "251-725-9878", "Example Corp", "Follow Up", null);
        leadDTO = new LeadDTO(leadId, "Jason Smith", "jason@example.com", "251-725-9878", "Example Corp", "Follow Up", null);
    }

    @Test
    void testCreateLead(){
        when(leadMapper.leadDTOToLead(any())).thenReturn(lead);
        when(leadRepository.save(any())).thenReturn(lead);
        when(leadMapper.leadToLeadDTO(any())).thenReturn(leadDTO);

        LeadDTO savedLead = leadService.saveLead(leadDTO);

        assertNotNull(savedLead);
        assertEquals("Jason Smith", savedLead.getFullName());
    }

    @Test
    void testGetAllLeads(){
        when(leadRepository.findAll()).thenReturn(List.of(lead));
        when(leadMapper.leadsToLeadDTOs(any())).thenReturn(List.of(leadDTO));

        List<LeadDTO> leads = leadService.getAllLeads();

        assertFalse(leads.isEmpty());
        assertEquals(1, leads.size());
    }

    @Test
    void testDeleteLead(){
        when(leadRepository.existsById(leadId)).thenReturn(true);
        doNothing().when(leadRepository).deleteById(leadId);

        assertDoesNotThrow(()-> leadService.deleteLead(leadId));
    }
}
