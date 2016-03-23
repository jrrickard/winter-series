package io.github.jrrickard.winterseries.model;

import com.vmware.xenon.common.ServiceDocument;

public class Swag extends ServiceDocument {

    private String participant;
    private String size;

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
