package com.parking;

public class SlotDetails {
    private String registrationNumber;
    private String age;

    public SlotDetails(String registrationNumber, String age) {
        this.registrationNumber = registrationNumber;
        this.age = age;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getAge() {
        return age;
    }

}
