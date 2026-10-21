package com.demo.apitest.dto.response;

public class ClaimResponseDto {
    private Long id;
    private Long policyId;
    private String customerName;
    private Double claimAmount;
    private String incidentDescription;
    private String status;

    public ClaimResponseDto() {}

    public ClaimResponseDto(Long id, Long policyId, String customerName, Double claimAmount, String incidentDescription, String status) {
        this.id = id;
        this.policyId = policyId;
        this.customerName = customerName;
        this.claimAmount = claimAmount;
        this.incidentDescription = incidentDescription;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPolicyId() { return policyId; }
    public void setPolicyId(Long policyId) { this.policyId = policyId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public Double getClaimAmount() { return claimAmount; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }

    public String getIncidentDescription() { return incidentDescription; }
    public void setIncidentDescription(String incidentDescription) { this.incidentDescription = incidentDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}