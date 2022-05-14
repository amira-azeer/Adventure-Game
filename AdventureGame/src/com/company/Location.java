package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits; // To store the available exits from the location

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>();
        this.exits.put("Q", 0); // To quit the game
    }

    public void addExit(String direction, int location){ // Method allows directions to be added to the map
        exits.put(direction, location);
        // Location contains a location ID and a description
    }

    // GETTERS SO WE CAN GET ACCESS TO THESE VARIABLES FROM ANOTHER CLASS
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits); // A new map is created with all the mappings from the Exit map
    }
}
