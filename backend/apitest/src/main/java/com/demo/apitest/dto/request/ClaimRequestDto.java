package com.demo.apitest.dto.request;

public class ClaimRequestDto {
    private Long policyId;
    private Double claimAmount;
    private String description;

    public ClaimRequestDto() {}

    public Long getPolicyId() { return policyId; }
    public void setPolicyId(Long policyId) { this.policyId = policyId; }

    public Double getClaimAmount() { return claimAmount; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}