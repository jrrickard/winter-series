package io.github.jrrickard.winterseries.services.stateful;

import com.vmware.xenon.common.Operation;
import com.vmware.xenon.common.StatefulService;
import io.github.jrrickard.winterseries.model.Participant;

public class ParticipantService extends StatefulService {

    public ParticipantService() {
        super(Participant.class);
        super.toggleOption(ServiceOption.PERSISTENCE, true);
        super.toggleOption(ServiceOption.REPLICATION, true);
        super.toggleOption(ServiceOption.OWNER_SELECTION, true);
    }

    @Override
    public void handlePut(Operation put) {
        throw new UnsupportedOperationException("PUT operations not supported");
    }
}
