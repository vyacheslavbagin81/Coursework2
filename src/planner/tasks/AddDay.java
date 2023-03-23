package planner.tasks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

interface AddDay {
    static List<Task> add(Task task, int quantityPerYear, int cycle) {
        int periodYear = 1;
        List<Task> list = new ArrayList<>();
        LocalDate day = task.getDate();
        for (int i = 0; i < periodYear*quantityPerYear; i++) {
            day = day.plusDays(cycle);
            list.add(new Task(day,
                    task.getTitle(),
                    task.getDescription(),
                    task.getType(),
                    task.getAgainTask()));
        }
        return list;
    }
}
