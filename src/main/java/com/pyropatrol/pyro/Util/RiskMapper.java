package com.pyropatrol.pyro.Util;

import com.pyropatrol.pyro.DTO.RiskResponseDTO;
import com.pyropatrol.pyro.model.RiskResponse;

public class RiskMapper {

    public static RiskResponseDTO toDTO(RiskResponse model) {
        return new RiskResponseDTO(
                model.getLat(),
                model.getLon(),
                model.getRisk()
        );
    }
}