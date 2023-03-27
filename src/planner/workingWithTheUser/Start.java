package planner.workingWithTheUser;

import planner.erorrs.AppearsIn;
import planner.tasks.TaskService;

public interface Start {
    static void start() {
        TaskService.setTaskMap(AppearsIn.appearsIn());
    }
}
