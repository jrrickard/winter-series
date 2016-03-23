package io.github.jrrickard.winterseries.services.stateful;


import com.vmware.xenon.common.FactoryService;
import com.vmware.xenon.common.Service;
import io.github.jrrickard.winterseries.model.RaceRegistration;

public class RaceRegistrationFactoryService extends FactoryService {

    public static final String SELF_LINK = "/registrations";

    public RaceRegistrationFactoryService() {
        super(RaceRegistration.class);
    }

    @Override
    public Service createServiceInstance() throws Throwable {
        return new RaceRegistrationService();
    }
}
