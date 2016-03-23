package io.github.jrrickard.winterseries.services.stateful;

import com.vmware.xenon.common.FactoryService;
import com.vmware.xenon.common.Service;
import io.github.jrrickard.winterseries.model.Participant;


public class ParticipantFactoryService extends FactoryService {

    public static final String SELF_LINK = "/participants";

    public ParticipantFactoryService() {
        super(Participant.class);
    }

    @Override
    public Service createServiceInstance() throws Throwable {
        return new ParticipantService();
    }
}
