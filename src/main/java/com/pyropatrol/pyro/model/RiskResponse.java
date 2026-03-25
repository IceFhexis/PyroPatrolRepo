package com.pyropatrol.pyro.model;

public class RiskResponse {

    private double lat;
    private double lon;
    private String risk;

    public RiskResponse(double lat, double lon, String risk) {
        this.lat = lat;
        this.lon = lon;
        this.risk = risk;
    }

    public double getLat() { return lat; }
    public double getLon() { return lon; }
    public String getRisk() { return risk; }
}