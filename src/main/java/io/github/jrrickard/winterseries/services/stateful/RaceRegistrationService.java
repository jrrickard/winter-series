package io.github.jrrickard.winterseries.services.stateful;

import com.vmware.xenon.common.StatefulService;
import io.github.jrrickard.winterseries.model.RaceRegistration;


public class RaceRegistrationService extends StatefulService {
    public RaceRegistrationService() {
        super(RaceRegistration.class);
    }
}
