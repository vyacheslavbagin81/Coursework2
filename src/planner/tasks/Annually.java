package planner.tasks;

import java.util.List;

interface Annually extends AddDay {
    static List<Task> add(Task task) {
        return AddMonth.add(task, 1, 12);
    }
}
