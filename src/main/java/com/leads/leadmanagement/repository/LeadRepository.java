package com.leads.leadmanagement.repository;

import com.leads.leadmanagement.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeadRepository extends JpaRepository<Lead, UUID> {
}
