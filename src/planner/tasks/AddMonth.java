package planner.tasks;

import java.time.LocalDate;

interface AddMonth {
    static Task add(Task task, int cycle) {
        LocalDate day = task.getDate();
        day = day.plusMonths(cycle);
        task = (new Task(day,
                task.getTitle(),
                task.getDescription(),
                task.getType(),
                task.getAgainTask(),
                (TaskService.getKay() + 1)));
        return task;
    }
}
