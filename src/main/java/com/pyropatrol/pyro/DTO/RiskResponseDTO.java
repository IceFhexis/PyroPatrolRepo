package com.pyropatrol.pyro.DTO;

public record RiskResponseDTO(
        double latitude,
        double longitude,
        String risk
) {}