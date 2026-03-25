package com.pyropatrol.pyro.Util;

public class RiskAnalyzer {

    public static String analyze(String data) {

        String[] lines = data.split("\n");
        int maxRisk = 0;

        for (int i = 1; i < lines.length; i++) {

            String[] cols = lines[i].split(",");

            if (cols.length < 10) continue;

            int risk = switch (cols[9]) {
                case "l" -> 1;
                case "n" -> 2;
                case "h" -> 3;
                default -> 0;
            };

            if (risk > maxRisk) maxRisk = risk;
        }

        return switch (maxRisk) {
            case 1 -> "low";
            case 2 -> "medium";
            case 3 -> "high";
            default -> "no_risk";
        };
    }
}