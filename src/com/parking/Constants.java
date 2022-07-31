package com.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Constants {
    /**
     * PriorityQueue to get the nearest slot available from the entry point
     */
    public static PriorityQueue<Integer> nearestSlot
            = new PriorityQueue<Integer>();
    /**
     * Maintains list of vehicles that are mapped to a particular age
     */
    public static HashMap<String, ArrayList<String>> AGE_TO_VEHICLE_REGISTRATION = new HashMap<>();
    /**
     * Maintains the mapping between vehicle and slot alloted to that vehicle
     */
    public static HashMap<String, Integer> VEHICLE_REGISTRATION_TO_SLOT = new HashMap<>();
    /**
     * Maintains list of slot numbers that are mapped to a particular age group
     */
    public static HashMap<String, ArrayList<String>> AGE_TO_SLOT_NUMBERS = new HashMap<>();
    /**
     * Maintains the mapping between slot numbers allocated to that vehicle and its registration number
     */
    public static HashMap<Integer, String> SLOT_NUMBERS_TO_VEHICLE_REGISTRATION = new HashMap<>();
    /**
     * Map of Slot nnumber to slot details(age and registration)
     */
    public static HashMap<Integer, SlotDetails> SLOT_DETAILS = new HashMap<>();


}
