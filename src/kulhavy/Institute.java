/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kulhavy;

import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Comparator;
import java.util.List;

/**
 * @author tomas.kulhavy
 */
public class Institute {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Institute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        for (Station value : stations) {
            if (station.getName().equals(value.getName())) {
                throw new UnsupportedOperationException("Tato stanice jiz exituje!");
            }
        }

        stations.add(station);
    }

    public void removeStation(String station) {
        boolean isHere = false;
        int tempPos = 0;

        for (int i = 0; i < stations.size(); i++) {
            if (station.equals(stations.get(i).getName())) {
                isHere = true;
                tempPos = i;
                break;
            }
        }

        if (isHere) {
            stations.remove(tempPos);
        } else {
            throw new UnsupportedOperationException("Tato stanice: " + getName() + "neexistuje!");
        }
    }

    public void editStation(String station, double longitude, double latitude) {
        boolean isHere = false;
        int tempPos = 0;

        for (Station value : stations) {
            if (station.equals(value.getName())) {
                isHere = true;
                break;
            }
        }

        if (isHere) {
            Station stationToEdit = stations.get(tempPos);
            stationToEdit.setLongitude(longitude);
            stationToEdit.setLatitude(latitude);
        } else {
            throw new UnsupportedOperationException("Tato stanice: " + getName() + "neexistuje!");
        }
    }

    public int getStationCount() {
        return stations.size();
    }

    public Station getNearestStation(double longitude, double latitude) {
        double nearestDistance = Integer.MAX_VALUE;
        int tempPos = 0;
        Station target = new Station("Target to measure", longitude, latitude);
        for (int i = 0; i < stations.size(); i++) {
            double temp = stations.get(i).getDistance(target);
            if (temp < nearestDistance) {
                tempPos = i;
            }
        }

        return stations.get(tempPos);
    }

    public String getClosestStation(double longitude, double latitude) {
        double closestValue = Double.MAX_VALUE;
        String closestName = "";
        Station stationToTest = new Station("testovaci", longitude, latitude);
        for (Station station : stations) {
            double currentDistance = station.getDistance(stationToTest);
            if (currentDistance < closestValue) {
                closestValue = currentDistance;
                closestName = station.getName();
            }
        }

        return String.format("Nejblizsi stanice je %s, vzdalena %s km", closestName, closestValue);
    }

    @Override
    public String toString() {
        stations.sort(Comparator.comparing(Station::getName));

        StringBuilder returnString = new StringBuilder("Vsechny stanice:\n");

        int i = stations.size() - 1;
        for (Station station : stations) {
            if (i-- == 0) {
                returnString.append(station.getName());
                continue;
            }
            returnString.append(station.getName()).append(", ");
        }

        return returnString.toString();
    }

    public static void main(String[] args) {
        Institute institute = new Institute("Liberec");
        System.out.println(institute.getName());

        Station station = new Station("Liberec", 50.77, 15.07);
        Station station2 = new Station("Sofia", 42.69, 23.32);
        institute.addStation(station);
        institute.addStation(station2);
        System.out.println(institute);
    }
}