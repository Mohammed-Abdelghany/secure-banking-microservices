package com.example.account.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditConfig implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // في نظام حقيقي، نأتي بالاسم من Spring Security
        // حالياً، سنضع اسماً ثابتاً لحل المشكلة
        return Optional.of("ACCOUNTS_MS");
    }
}
