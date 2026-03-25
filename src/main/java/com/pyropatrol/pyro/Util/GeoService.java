package com.pyropatrol.pyro.Util;

import com.pyropatrol.pyro.model.Point;

public class GeoService {

    public static Point getNewPoint(double lat, double lon, double distanceKm, double bearing) {

        double radius = 6371.0;

        double newLat = lat + (distanceKm / radius) * Math.cos(Math.toRadians(bearing));
        double newLon = lon + (distanceKm / radius) * Math.sin(Math.toRadians(bearing));

        return new Point(newLat, newLon);
    }

    public static String formatCoordinates(Point p1, Point p2) {
        return p2.getLat() + "," + p2.getLon() + "," + p1.getLat() + "," + p1.getLon();
    }

    public static double[] getCurrentLocation() {
        return new double[]{-22.9, -43.2};
    }
}