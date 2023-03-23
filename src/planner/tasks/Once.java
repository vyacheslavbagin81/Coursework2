package planner.tasks;

import java.util.List;

interface Once {
    static List<Task> add(Task task) {
        return AddDay.add(task, 0, 1);
    }
}
