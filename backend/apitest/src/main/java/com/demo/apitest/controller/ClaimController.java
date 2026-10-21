package com.demo.apitest.controller;

import com.demo.apitest.dto.request.ClaimRequestDto;
import com.demo.apitest.dto.response.ClaimResponseDto;
import com.demo.apitest.service.ClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ClaimResponseDto createClaim(@RequestBody ClaimRequestDto requestDto) {
        return claimService.createClaim(requestDto);
    }

    @GetMapping("/policy/{policyId}")
    public List<ClaimResponseDto> getClaimsByPolicy(@PathVariable Long policyId) {
        return claimService.getClaimsByPolicy(policyId);
    }
}