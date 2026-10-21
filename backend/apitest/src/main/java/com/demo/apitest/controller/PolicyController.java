package com.demo.apitest.controller;

import com.demo.apitest.dto.response.PolicyResponseDto;
import com.demo.apitest.service.PolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public List<PolicyResponseDto> getAllPolicies() {
        return policyService.getAllPolicies();
    }
}