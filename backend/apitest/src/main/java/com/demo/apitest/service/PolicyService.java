package com.demo.apitest.service;

import com.demo.apitest.dto.response.PolicyResponseDto;
import com.demo.apitest.entity.Policy;
import com.demo.apitest.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {
    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<PolicyResponseDto> getAllPolicies() {
        return policyRepository.findAll().stream()
                .map(policy -> new PolicyResponseDto(
                        policy.getId(),
                        policy.getCustomerName(),
                        policy.getPolicyType(),
                        policy.getCoverageLimit()
                ))
                .collect(Collectors.toList());
    }
}
