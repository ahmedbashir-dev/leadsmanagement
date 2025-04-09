package com.leads.leadmanagement.repository;

import com.leads.leadmanagement.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * JPA Repository for interacting with Lead
 */
public interface LeadRepository extends JpaRepository<Lead, UUID> {
}
