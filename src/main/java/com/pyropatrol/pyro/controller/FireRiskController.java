package com.pyropatrol.pyro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pyropatrol.pyro.DTO.RiskResponseDTO;
import com.pyropatrol.pyro.Util.RiskMapper;
import com.pyropatrol.pyro.service.FireRiskService;

@RestController
@RequestMapping("/api/v1/risk")
public class FireRiskController {

    private final FireRiskService service;

    public FireRiskController(FireRiskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<RiskResponseDTO> getRisk() {
        return ResponseEntity.ok(
                RiskMapper.toDTO(service.calculateRisk())
        );
    }

    @GetMapping("/custom")
    public ResponseEntity<RiskResponseDTO> getCustomRisk(
            @RequestParam double lat,
            @RequestParam double lon
    ) {
        return ResponseEntity.ok(
                RiskMapper.toDTO(service.calculateRisk(lat, lon))
        );
    }
}