package io.github.jrrickard.winterseries.model;

import com.vmware.xenon.common.ServiceDocument;

public class Participant extends ServiceDocument {

    private String lastName;
    private String firstName;

    private int raceAge;
    private Gender gender;

    private String city;
    private String state;

    private boolean senior;
    private boolean clydeOrAthena;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getRaceAge() {
        return raceAge;
    }

    public void setRaceAge(int raceAge) {
        this.raceAge = raceAge;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public boolean isClydeOrAthena() {
        return clydeOrAthena;
    }

    public void setClydeOrAthena(boolean clydeOrAthena) {
        this.clydeOrAthena = clydeOrAthena;
    }


}
