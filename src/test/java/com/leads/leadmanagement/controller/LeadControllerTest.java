package com.leads.leadmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leads.leadmanagement.dto.LeadDTO;
import com.leads.leadmanagement.service.LeadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LeadController.class)
public class LeadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LeadService leadService;

    private LeadDTO leadDTO;
    private UUID leadId;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        leadId = UUID.randomUUID();
        leadDTO = new LeadDTO(leadId, "Jason Smith", "jason@example.com", "251-725-9878", "Example Corp", "Follow Up", null);
    }

    @Test
    void testCreateLead() throws Exception{
        when(leadService.saveLead(leadDTO)).thenReturn(leadDTO);

        mockMvc.perform(post("/leads")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(leadDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void testGetLeads() throws Exception{
        mockMvc.perform(get("/leads"))
                .andExpect(status().isOk());
    }

}
