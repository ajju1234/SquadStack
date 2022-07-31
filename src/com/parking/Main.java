package com.parking;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ParkingHelper parkingHelper=new ParkingHelper();
        File file = new File("/Users/ajit/Desktop/src/com/parking/input.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            try {
                String[] command = line.split(" ");
                if (command[0].contains("Create_parking")) {
                    int size = Integer.parseInt(command[1]);
                    parkingHelper.createParkingLot(size);
                    System.out.println("Created parking of 6 slots");
                } else if (command[0].contains("Slot_numbers_for_driver_of_age")) {
                    if (Constants.AGE_TO_SLOT_NUMBERS.containsKey(command[1])) {
                        ArrayList<String>slotNumbers=Constants.AGE_TO_SLOT_NUMBERS.get(command[1]);
                        for(int i=0;i<slotNumbers.size();i++){
                            System.out.print(slotNumbers.get(i));
                            if(i!=slotNumbers.size()-1){
                                System.out.print(',');
                            }
                        }
                        System.out.println();
                    } else {
                        System.out.println("Invalid input. Please provide valid input");
                    }
                } else if (command[0].contains("Park")) {
                    int slotNumber = parkingHelper.parkVehicle(command[1], command[3]);
                    System.out.println("Car with vehicle registration number " + command[1] + " has been parked at slot number " + slotNumber);
                } else if (command[0].contains("Slot_number_for_car_with_number")) {
                    if (Constants.VEHICLE_REGISTRATION_TO_SLOT.containsKey(command[1])) {
                        System.out.println(Constants.VEHICLE_REGISTRATION_TO_SLOT.get(command[1]));
                    } else {
                        System.out.println("vehicle " + command[1] + " is not parked with us");
                    }
                } else if (command[0].contains("Leave")) {
                    SlotDetails slotDetails = parkingHelper.emptyTheSlot(Integer.parseInt(command[1]));
                    if (slotDetails == null) {
                        System.out.println("slot was never occupied or has already been vacated");
                    } else {
                        System.out.println("Slot number " + command[1] + " vacated, the car with vehicle registration number " + slotDetails.getRegistrationNumber() +
                                " left the space, the driver of the car was of age " + slotDetails.getAge());
                    }
                } else if (command[0].contains("Vehicle_registration_number_for_driver_of_age")) {
                    if (Constants.AGE_TO_SLOT_NUMBERS.containsKey(command[1])) {
                        System.out.print("Car with vehicle registration number " + command[1] + " has been parked at slot number ");
                        ArrayList<String>slotNumbers=Constants.AGE_TO_SLOT_NUMBERS.get(command[1]);
                        for(int i=0;i<slotNumbers.size();i++){
                            System.out.print(slotNumbers.get(i));
                            if(i!=slotNumbers.size()-1){
                                System.out.print(',');
                            }
                        }
                        System.out.println();
                    }else{
                        System.out.println("Invalid input");
                    }
                }

            } catch (Exception e) {
                System.out.println("exception occurred while processing input " + e.getMessage());
            }
        }


    }
}
