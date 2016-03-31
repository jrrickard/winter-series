package io.github.jrrickard.winterseries.services.task;


import com.vmware.xenon.common.FactoryService;
import com.vmware.xenon.common.Operation;
import com.vmware.xenon.common.StatefulService;
import com.vmware.xenon.common.TaskState;
import io.github.jrrickard.winterseries.model.tasks.DataImportTaskState;

public class DataImportService extends StatefulService {

    public static final String FACTORY_LINK = "/winter-series/import";

    public DataImportService() {
        super(DataImportTaskState.class);
        toggleOption(ServiceOption.PERSISTENCE, true);
        toggleOption(ServiceOption.REPLICATION, true);
        toggleOption(ServiceOption.INSTRUMENTATION, true);
        toggleOption(ServiceOption.OWNER_SELECTION, true);
    }

    public static FactoryService createFactory() {
        return FactoryService.create(DataImportService.class, DataImportTaskState.class,
                ServiceOption.IDEMPOTENT_POST, ServiceOption.INSTRUMENTATION);
    }

    @Override
    public void handleStart(final Operation taskOperation) {
        taskOperation.complete();
    }

    @Override
    public void handleCreate(final Operation taskOperation) {
        //TODO : Implement This

    }

    @Override
    public void handlePatch(final Operation patch) {
        //TODO : Implement This
    }

    private void handleSubstage(final DataImportTaskState task) {
        switch (task.subStage) {
            case PARSE_FILE:
                //TODO : Parse the CSV Content
                break;
            case QUERY_PARTICIPANTS:
                //TODO : Query for Participant by Name and Age
                break;
            case STORE_PARTICIPANTS:
                //TODO : Update Existing Participants, Store new ones
                break;
            case QUERY_REGISTRATIONS:
                //TODO : Query existing registrations
                break;
            case STORE_REGISTRATIONS:
                //TODO : Update Registrations
                break;
            default:
                logWarning("Unexpected sub stage: %s", task.subStage);
                break;
        }
    }

    /**
     * Send ourselves a PATCH that will indicate failure
     */
    private void sendSelfFailurePatch(final DataImportTaskState task, final String failureMessage) {
        task.failureMessage = failureMessage;
        sendSelfPatch(task, TaskState.TaskStage.FAILED, null);
    }

    /**
     * Send ourselves a PATCH that will advance to another step in the task workflow to the
     * specified stage and substage.
     */
    private void sendSelfPatch(final DataImportTaskState task, final TaskState.TaskStage stage, final DataImportTaskState.SubStage subStage) {
        task.taskStage = stage;
        task.subStage = subStage;
        sendSelfPatch(task);
    }

    /**
     * Send ourselves a PATCH. The caller is responsible for creating the PATCH body
     */
    private void sendSelfPatch(final DataImportTaskState task) {
        Operation patch = Operation.createPatch(getUri()).setBody(task).setCompletion((op, ex) -> {
            if (ex != null) {
                logWarning("Failed to send patch, task has failed: %s", ex.getMessage());
            }
        });
        sendRequest(patch);
    }

}
