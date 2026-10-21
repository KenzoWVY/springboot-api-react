package com.demo.apitest.service;

import com.demo.apitest.dto.request.ClaimRequestDto;
import com.demo.apitest.dto.response.ClaimResponseDto;
import com.demo.apitest.entity.Claim;
import com.demo.apitest.entity.Policy;
import com.demo.apitest.repository.ClaimRepository;
import com.demo.apitest.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClaimService {
    private final ClaimRepository claimRepository;
    private final PolicyRepository policyRepository;

    public ClaimService(ClaimRepository claimRepository, PolicyRepository policyRepository) {
        this.claimRepository = claimRepository;
        this.policyRepository = policyRepository;
    }

    public Claim createClaim(Long policyId, Double claimAmount, String description) {
        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        Claim claim = new Claim();
        claim.setPolicy(policy);
        claim.setClaimAmount(claimAmount);
        claim.setDescription(description);

        if (claimAmount > policy.getCoverageLimit()) {
            claim.setStatus("REJECTED");
        } else {
            claim.setStatus("PENDING");
        }

        return claimRepository.save(claim);
    }

    public List<ClaimResponseDto> getClaimsByPolicy(Long policyId) {
        return claimRepository.findByPolicyId(policyId).stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    public ClaimResponseDto createClaim(ClaimRequestDto requestDto) {
        Policy policy = policyRepository.findById(requestDto.getPolicyId())
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        Claim claim = new Claim();
        claim.setPolicy(policy);
        claim.setClaimAmount(requestDto.getClaimAmount());
        claim.setDescription(requestDto.getDescription());

        if (requestDto.getClaimAmount() > policy.getCoverageLimit()) {
            claim.setStatus("REJECTED");
        } else {
            claim.setStatus("PENDING");
        }

        Claim savedClaim = claimRepository.save(claim);
        return mapToResponseDto(savedClaim);
    }

    private ClaimResponseDto mapToResponseDto(Claim claim) {
        return new ClaimResponseDto(
                claim.getId(),
                claim.getPolicy().getId(),
                claim.getPolicy().getCustomerName(),
                claim.getClaimAmount(),
                claim.getDescription(),
                claim.getStatus()
        );
    }
}
