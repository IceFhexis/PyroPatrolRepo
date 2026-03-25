package com.pyropatrol.pyro.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pyropatrol.pyro.Util.GeoService;
import com.pyropatrol.pyro.Util.RiskAnalyzer;
import com.pyropatrol.pyro.client.NasaFeignClient;
import com.pyropatrol.pyro.model.Point;
import com.pyropatrol.pyro.model.RiskResponse;

@Service
public class FireRiskService {

    private final NasaFeignClient nasaClient;

    @Value("${nasa.api-key}")
    private String apiKey;

    public FireRiskService(NasaFeignClient nasaClient) {
        this.nasaClient = nasaClient;
    }

    public RiskResponse calculateRisk() {
        double[] loc = GeoService.getCurrentLocation();
        return calculateRisk(loc[0], loc[1]);
    }

    public RiskResponse calculateRisk(double lat, double lon) {

        Point p1 = GeoService.getNewPoint(lat, lon, 1000, 45);
        Point p2 = GeoService.getNewPoint(lat, lon, 1000, 225);

        String coords = GeoService.formatCoordinates(p1, p2);

        String data = nasaClient.getFireData(apiKey, coords, 1);

        String risk = RiskAnalyzer.analyze(data);

        return new RiskResponse(lat, lon, risk);
    }
}