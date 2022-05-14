package com.company;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        // EXITS AVAILABLE IF ENTERED ROOM 1
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        // EXITS AVAILABLE IF ENTERED ROOM 2
        locations.get(2).addExit("N", 5);

        // EXITS AVAILABLE IF ENTERED ROOM 3
        locations.get(3).addExit("W", 1);

        // EXITS AVAILABLE IF ENTERED ROOM 4
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        // EXITS AVAILABLE IF ENTERED ROOM 5
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        // MAKING THE GAME MORE FLEXIBLE
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        int loc = 1; 
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit : exits.keySet()){
                System.out.print(exit +" ,");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();

            // Could simply use AI for this component
            if(direction.length()>1){ //Not a single character command entered by the user thus needs splitting
                String[] words = direction.split(" ");
                for(String word : words){
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction); // Getting the integer corresponding to the valid direction entered based on the ey that has been typed in
            } else{
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
