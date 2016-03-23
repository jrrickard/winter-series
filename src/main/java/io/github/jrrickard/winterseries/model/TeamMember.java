package io.github.jrrickard.winterseries.model;


import com.vmware.xenon.common.ServiceDocument;

public class TeamMember extends ServiceDocument {

    private String team;
    private String participant;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }
}
