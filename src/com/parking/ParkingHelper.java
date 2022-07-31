package com.parking;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingHelper {

    /**
     * creates parkig lot of given size
     *
     * @param size
     */
    public  void createParkingLot(int size) {
        initialiseProperty(size);
    }

    /**
     * initialises the priority queue with the parking lot size
     *
     * @param size
     */
    public  void initialiseProperty(int size) {
        for (int i = 1; i <= size; i++) {
            Constants.nearestSlot.add(i);
        }
    }

    /**
     * returns the nearest slot number available
     *
     * @param registrationNumber
     * @param age
     * @return
     */
    public  int parkVehicle(String registrationNumber, String age) {
        if (Constants.nearestSlot.size() > 0) {
            int slotNumber = Constants.nearestSlot.poll();
            ArrayList<String> temp = Constants.AGE_TO_VEHICLE_REGISTRATION.getOrDefault(age, new ArrayList<>());
            temp.add(registrationNumber);
            Constants.AGE_TO_VEHICLE_REGISTRATION.put(age, temp);
            Constants.VEHICLE_REGISTRATION_TO_SLOT.put(registrationNumber, slotNumber);
            ArrayList<String> slotNumbers = Constants.AGE_TO_SLOT_NUMBERS.getOrDefault(age, new ArrayList<>());
            slotNumbers.add(String.valueOf(slotNumber));
            Constants.AGE_TO_SLOT_NUMBERS.put(age, slotNumbers);
            Constants.SLOT_NUMBERS_TO_VEHICLE_REGISTRATION.put(slotNumber, registrationNumber);
            Constants.SLOT_DETAILS.put(slotNumber, new SlotDetails(registrationNumber, age));
            return slotNumber;
        } else {
            return -1;
        }
    }

    /**
     * removes the slot related details
     *
     * @param slot
     * @return
     */
    public  SlotDetails emptyTheSlot(int slot) {
        if(Constants.nearestSlot.contains(slot)){
            return null;
        }
        Constants.nearestSlot.add(slot);
        String registrationNumber = Constants.SLOT_NUMBERS_TO_VEHICLE_REGISTRATION.get(slot);
        Constants.VEHICLE_REGISTRATION_TO_SLOT.remove(registrationNumber);
        Constants.SLOT_NUMBERS_TO_VEHICLE_REGISTRATION.remove(slot);
        removeEntry(Constants.AGE_TO_VEHICLE_REGISTRATION, registrationNumber);
        removeEntry(Constants.AGE_TO_VEHICLE_REGISTRATION, registrationNumber);
        removeEntry(Constants.AGE_TO_SLOT_NUMBERS, String.valueOf(slot));
        SlotDetails slotDetails = Constants.SLOT_DETAILS.get(slot);
        Constants.SLOT_DETAILS.remove(slot);
        return slotDetails;
    }

    /**
     * remove entry from map
     * @param map
     * @param value
     */
    private  void removeEntry(HashMap<String, ArrayList<String>> map, String value) {
        for (ArrayList<String> values : map.values()) {
            if (values.contains(value)) {
                values.remove(value);
            }
        }
    }
}
