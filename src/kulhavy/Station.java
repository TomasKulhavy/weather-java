/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kulhavy;

/**
 *
 * @author tomas.kulhavy
 */
public class Station implements Comparable<Station> {

    private String name;
    private double longitude = 190.0;
    private double latitude = 190.0;

    private final int EARTH_R = 6371;
    private final double MIN_LONG = -180;
    private final double MAX_LONG = 180;
    private final double MIN_LAT = -90;
    private final double MAX_LAT = 90;

    public Station(String name) {
        this.name = name;
    }

    public Station(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        if (checkLatitude(latitude)) {
            return latitude;
        } else {
            throw new UnsupportedOperationException("Latitude is not definied!");
        }
    }

    public double getLongitude() {
        if (checkLongitude(longitude)) {
            return longitude;
        } else {
            throw new UnsupportedOperationException("Longitude is not definied!");
        }
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean setPosition(double longitude, double latitude) {
        if (checkLongitude(this.longitude) && checkLatitude(this.latitude)) {
            throw new UnsupportedOperationException("Longitude and latitude is already definied!");
        }
        if (checkPosition(longitude, latitude)) {
            return false;
        }

        this.longitude = longitude;
        this.latitude = latitude;
        return true;
    }

    public double getDistance(Station station) {
        return 2 * EARTH_R * Math.asin(Math.sqrt(Math.pow(Math.sin(((Math.toRadians(station.latitude - latitude))/2)),2) + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(station.latitude)) * Math.pow(Math.sin(((Math.toRadians(station.longitude - longitude))/2)),2)));
    }

    public double getDistanceFromTUL() {
        Station TUL = new Station("TUL", 50.773234, 15.074443);
        return getDistance(TUL);
    }

    public boolean checkPosition(double longitude, double latitude) {
        return checkLongitude(longitude) && checkLatitude(latitude);
    }

    public boolean checkLongitude(double longitude) {
        return (longitude > MIN_LONG && longitude < MAX_LONG);
    }

    public boolean checkLatitude(double latitude) {
        return (latitude > MIN_LAT && latitude < MAX_LAT);
    }

    @Override
    public String toString() {
        return "Stanice " + getName() + " má souřadnice: " + getLongitude() + ", " + getLatitude();
    }

    public static void main(String[] args) {
        Station station1 = new Station("Jablonec nad Nisou");
        Station station2 = new Station("Liberec", 50.77, 15.07);
        Station station3 = new Station("Amsterdam", 52.37, 4.84);

        System.out.println(station1.getName());
        System.out.println(station2.getLongitude());
        // Testování výjimky
        // System.out.println(station1.getLongitude());
        System.out.println(station2);
        // Test vkládání pozice 
        // station2.setPosition(50.6, 18.6);
        // --> Výjimka
        System.out.println("Vzdálenost je: " + station2.getDistance(station3) + " km");
    }

    @Override
    public int compareTo(Station o) {
        return this.name.compareTo(o.name);
    }
}