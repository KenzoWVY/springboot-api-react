package com.demo.apitest.dto.response;

public class PolicyResponseDto {
    private Long id;
    private String customerName;
    private String policyType;
    private Double coverageLimit;

    public PolicyResponseDto() {}

    public PolicyResponseDto(Long id, String customerName, String policyType, Double coverageLimit) {
        this.id = id;
        this.customerName = customerName;
        this.policyType = policyType;
        this.coverageLimit = coverageLimit;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getPolicyType() { return policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }

    public Double getCoverageLimit() { return coverageLimit; }
    public void setCoverageLimit(Double coverageLimit) { this.coverageLimit = coverageLimit; }
}