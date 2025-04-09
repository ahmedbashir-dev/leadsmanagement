package com.leads.leadmanagement.mapper;


import com.leads.leadmanagement.dto.LeadDTO;
import com.leads.leadmanagement.model.Lead;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeadMapper {
    LeadMapper INSTANCE = Mappers.getMapper(LeadMapper.class);

    LeadDTO leadToLeadDTO(Lead lead);
    Lead leadDTOToLead(LeadDTO leadDTO);
    List<LeadDTO> leadsToLeadDTOs(List<Lead> leads);

}
