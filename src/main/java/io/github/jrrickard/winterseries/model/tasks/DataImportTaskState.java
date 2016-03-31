package io.github.jrrickard.winterseries.model.tasks;

import com.vmware.xenon.common.ServiceDocument;
import com.vmware.xenon.common.ServiceDocumentDescription;
import com.vmware.xenon.common.TaskState;


public class DataImportTaskState extends ServiceDocument {

    public enum SubStage {
        PARSE_FILE,
        QUERY_PARTICIPANTS,
        STORE_PARTICIPANTS,
        QUERY_REGISTRATIONS,
        STORE_REGISTRATIONS
    }

    /**
     * This field shouldn't be manipulated by clients, but can be examined to see the progress
     * of the task
     */
    @UsageOption(option = ServiceDocumentDescription.PropertyUsageOption.AUTO_MERGE_IF_NOT_NULL)
    public TaskState.TaskStage taskStage;

    /**
     * If taskInfo.stage == FAILED, this message will say why
     */
    @UsageOption(option = ServiceDocumentDescription.PropertyUsageOption.AUTO_MERGE_IF_NOT_NULL)
    public String failureMessage;

    /**
     * The current substage. See {@link SubStage}
     */
    @UsageOption(option = ServiceDocumentDescription.PropertyUsageOption.AUTO_MERGE_IF_NOT_NULL)
    public SubStage subStage;


    String csvContent;


}
