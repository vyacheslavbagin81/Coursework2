package planner.erorrs;

import planner.tasks.Task;

import java.time.LocalDate;
import java.util.Map;

public class Checking {

    public static void checking(String str) throws IncorrectArgumentException {
        if (str.length()<1) {
            throw new IncorrectArgumentException("Не корректные данные! Попробуйте еще раз!");
        }
    }

    public static LocalDate checkingData(LocalDate localDate) {
        if (localDate.isAfter(LocalDate.now()))
            return localDate;
        return LocalDate.now();
    }

    public static void checkingTask(Map<Integer, Task> taskService, String title) throws TaskNotFoundException {
       if (taskService
               .values().stream()
               .noneMatch(task -> task.getTitle().equals(title))){
           throw new TaskNotFoundException("Задача " + title + " отсутствует.");
       }
    }

    public static void checkingTask(Map<Integer, Task> taskService, int id) throws TaskNotFoundException, NumberFormatException {
       if (taskService
               .values().stream()
               .noneMatch(task -> task.getId()==id)){
           throw new TaskNotFoundException("Задача №" + id + " отсутствует.");
       }
    }

    public static void checkingMenu(int s, int max) throws IncorrectArgumentException, NumberFormatException {
        if (s < 0 || s > max) {
            throw new IncorrectArgumentException("Не корректные данные! Попробуйте еще раз!");
        }
    }

}
