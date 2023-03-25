package planner.tasks;

import planner.enums.AgainTask;

import java.util.List;

interface CheckingTheFrequency {
    static List<Task> checkType(AgainTask againTask, Task task) {

        switch (againTask) {
            case DAILY -> {
                return Daily.add(task);
            }
            case WEEKLY -> {
                return Weekly.add(task);
            }
            case MONTHLY -> {
                return Monthly.add(task);
            }
            case ANNUALLY -> {
                return Annually.add(task);
            }
        }
        return (Once.add(task));
    }
}
