package planner.tasks;

import java.util.List;

interface Daily {
    static List<Task> add(Task task) {
        return AddDay.add(task, 365, 1);
    }
}
