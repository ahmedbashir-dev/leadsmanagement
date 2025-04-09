package com.leads.leadmanagement.mapper;


import com.leads.leadmanagement.dto.LeadDTO;
import com.leads.leadmanagement.model.Lead;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mapper interface for converting between {@link Lead} and {@link LeadDTO}
 */

@Mapper(componentModel = "spring")
public interface LeadMapper {
    // Singleton instance of the LeadMapper
    LeadMapper INSTANCE = Mappers.getMapper(LeadMapper.class);

    /**
     * Converts a {@link Lead} entity to a {@link LeadDTO}
     * @param lead The {@link Lead} entity
     * @return The corresponding {@link LeadDTO}
     */
    LeadDTO leadToLeadDTO(Lead lead);

    /**
     * Converts a {@link LeadDTO} to a {@link Lead} entity
     * @param leadDTO The {@link LeadDTO}
     * @return The corresponding {@link Lead} entity
     */
    Lead leadDTOToLead(LeadDTO leadDTO);

    /**
     * Converts a list of {@link Lead} entities to a list of {@link LeadDTO}
     * @param leads The list of {@link Lead} entities
     * @return A list of corresponding {@link LeadDTO}s
     */
    List<LeadDTO> leadsToLeadDTOs(List<Lead> leads);

}
