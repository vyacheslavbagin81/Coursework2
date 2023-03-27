package planner.erorrs;

import planner.file.FileInput;
import planner.tasks.CheckingTheFrequency;
import planner.tasks.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AppearsIn {
    static Map<Integer, Task> appearsIn(){
        Map<Integer, Task> taskMap = FileInput.fileInputTask();
        List<Task> listTasks = taskMap.values().stream().
                filter(task -> task.getDate().isAfter(LocalDate.now())).
                toList();
        listTasks.forEach(task -> CheckingTheFrequency.checkType(task.getAgainTask(), task));
        for (Task t : listTasks) {
            taskMap.put(t.getId(), t);
        }
        return taskMap;
    }
}
