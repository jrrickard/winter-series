package io.github.jrrickard.winterseries.services.stateful;

import com.vmware.xenon.common.FactoryService;
import com.vmware.xenon.common.Service;
import io.github.jrrickard.winterseries.model.Team;


public class TeamFactoryService extends FactoryService {

    public static final String SELF_LINK = "/teams";

    public TeamFactoryService() {
        super(Team.class);
    }

    @Override
    public Service createServiceInstance() throws Throwable {
        return new TeamService();
    }
}
