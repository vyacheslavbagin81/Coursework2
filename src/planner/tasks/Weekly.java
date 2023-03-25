package planner.tasks;

import java.util.List;

interface Weekly extends AddDay {
    static List<Task> add(Task task) {
        return AddDay.add(task, 52, 7);
    }
}
