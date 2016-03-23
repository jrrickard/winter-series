package io.github.jrrickard.winterseries.services.stateful;

import com.vmware.xenon.common.StatefulService;
import io.github.jrrickard.winterseries.model.Team;


public class TeamService extends StatefulService {

    public TeamService() {
        super(Team.class);
        super.toggleOption(ServiceOption.PERSISTENCE, true);
        super.toggleOption(ServiceOption.REPLICATION, true);
        super.toggleOption(ServiceOption.OWNER_SELECTION, true);
    }
}
