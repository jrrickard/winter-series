package io.github.jrrickard.winterseries.model;

import com.vmware.xenon.common.ServiceDocument;

public class Team extends ServiceDocument {

    private String teamName;
    private TeamCategory category;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public TeamCategory getCategory() {
        return category;
    }

    public void setCategory(TeamCategory category) {
        this.category = category;
    }
}
