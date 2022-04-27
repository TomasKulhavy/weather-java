/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kulhavy;

import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 *
 * @author tomas.kulhavy
 */
public class Institute {
    private String name;
    private ArrayList<Station> stations = new ArrayList<Station>();

    public Institute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        boolean isHere = false;

        for (int i = 0; i < stations.size(); i++) {
            if (station.getName() == stations.get(i).getName()) {
                isHere = true;
                break;
            }
        }

        if(!isHere) {
            stations.add(station);
        }
    }

    public void removeStation(String station) {
        boolean isHere = false;
        int tempPos = 0;

        for (int i = 0; i < stations.size(); i++) {
            if (station == stations.get(i).getName()) {
                isHere = true;
                break;
            }
        }

        if(isHere) {
            stations.remove(tempPos);
        } else {
            throw new UnsupportedOperationException("This station is not in " + getName() + " institute!");
        }
    }

    public void editStation(String station, double longitude, double latitude) {
        boolean isHere = false;
        int tempPos = 0;

        for (int i = 0; i < stations.size(); i++) {
            if (station == stations.get(i).getName()) {
                isHere = true;
                break;
            }
        }

        if(isHere) {
            Station stationToEdit = stations.get(tempPos);
            stationToEdit.setLongitude(longitude);
            stationToEdit.setLatitude(latitude);
        } else {
            throw new UnsupportedOperationException("This station is not in " + getName() + " institute!");
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
            if(temp < nearestDistance)
            {
                tempPos = i;
            }
        }

        return stations.get(tempPos);
    }

    public ArrayList<Station> getStationSorted(double longitude, double latitude) {
        return stations; // TODO
    }

    // TODO

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        return str.append(stations).toString();
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