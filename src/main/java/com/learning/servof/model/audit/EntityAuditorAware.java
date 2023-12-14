package com.learning.servof.model.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class EntityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Find and return authenticate user to jpa auditor to know who created and modified data
        var name = " ";
        if (SecurityContextHolder.getContext().getAuthentication() != null)
            name = SecurityContextHolder.getContext().getAuthentication().getName();

        return Optional.ofNullable(name);
    }
}
