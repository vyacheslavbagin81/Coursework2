package planner.tasks;

import java.util.List;

interface Monthly extends AddDay {
    static List<Task> add(Task task) {
        return AddMonth.add(task, 12, 1);
    }
}
