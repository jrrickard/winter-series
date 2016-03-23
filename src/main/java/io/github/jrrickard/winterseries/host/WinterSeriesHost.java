package io.github.jrrickard.winterseries.host;

import java.util.logging.Level;

import com.vmware.xenon.common.Operation;
import com.vmware.xenon.common.ServiceHost;
import com.vmware.xenon.common.UriUtils;
import com.vmware.xenon.services.common.RootNamespaceService;
import com.vmware.xenon.ui.UiService;
import io.github.jrrickard.winterseries.services.stateful.ParticipantFactoryService;
import io.github.jrrickard.winterseries.services.stateful.RaceRegistrationFactoryService;
import io.github.jrrickard.winterseries.services.stateful.TeamFactoryService;

public class WinterSeriesHost extends ServiceHost {

    public static void main(String[] args) throws Throwable {
        WinterSeriesHost h = new WinterSeriesHost();
        h.initialize(args);
        h.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            h.log(Level.WARNING, "Host stopping ...");
            h.stop();
            h.log(Level.WARNING, "Host is stopped");
        }));
    }

    @Override
    public ServiceHost start() throws Throwable {
        super.start();

        startDefaultCoreServicesSynchronously();

        super.startService(
                Operation.createPost(UriUtils.buildUri(this, RootNamespaceService.class)),
                new RootNamespaceService()
        );

        super.startService(
                Operation.createPost(UriUtils.buildUri(this, ParticipantFactoryService.class)),
                new ParticipantFactoryService());


        super.startService(
                Operation.createPost(UriUtils.buildUri(this, TeamFactoryService.class)),
                new TeamFactoryService());

        super.startService(
                Operation.createPost(UriUtils.buildUri(this, RaceRegistrationFactoryService.class)),
                new RaceRegistrationFactoryService());

        super.startService(
                Operation.createPost(UriUtils.buildUri(this, ParticipantFactoryService.class)),
                new ParticipantFactoryService());

        /*
         * This is required to turn on the UiService, otherwise it is not enabled
         */
        super.startService(
                Operation.createPost(UriUtils.buildUri(this, UiService.class)),
                new UiService());

        return this;
    }
}
