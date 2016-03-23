package io.github.jrrickard.winterseries.model;


import com.vmware.xenon.common.ServiceDocument;

public class RaceRegistration extends ServiceDocument {

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    private String race;
    private String participant;


}
