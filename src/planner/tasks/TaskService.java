package planner.tasks;

import planner.erorrs.Checking;
import planner.erorrs.TaskNotFoundException;
import planner.file.FileInput;
import planner.workingWithTheUser.Menu;
import planner.workingWithTheUser.Request;
import planner.workingWithTheUser.RequestOfTheDate;
import planner.workingWithTheUser.WorkingTheUser;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService implements Serializable {
    private static Map<Integer, Task> taskMap = FileInput.fileInputTask();
    private static Map<Integer, Task> taskMapDelete = FileInput.fileInputTaskDel();
    private static int kay = taskMap.size() + taskMapDelete.size();

    public static Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public static Map<Integer, Task> getTaskMapDelete() {
        return taskMapDelete;
    }

    public static int getKay() {
        return kay;
    }

    public static void addTask() {
        Task task = new Task(WorkingTheUser.addLocalDate(),
                WorkingTheUser.addTitle(),
                WorkingTheUser.addDescription(),
                WorkingTheUser.addType(),
                WorkingTheUser.addAgainTask(),
                kay++);
        taskMap.put(task.getId(), task);
        List<Task> list = CheckingTheFrequency.checkType(task.getAgainTask(), task);
        for (Task t : list) {
            taskMap.put(t.getId(), t);
        }
    }

    public static void remove(String title) {
        System.out.println("Введите наименование задачи которую необходимо удалить");
        String str = Request.request();
        try {
            Checking.checkingTask(taskMap, str);
            List<Task> list = taskMap.values().stream()
                    .filter(s -> s.getTitle().equals(str))
                    .toList();
            for (Task task : list) {
                taskMapDelete.put(task.getId(), task);
                taskMap.remove(task.getId());
            }
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
            Menu.menu();
        }
    }

    public static void remove(int id) {
        System.out.println("Введите номер задачи которую необходимо удалить");
        id = -1;
        try {
            id = Integer.parseInt(Request.request());
        } catch (NumberFormatException e) {
            System.out.println("Не корректный ввод");
            Menu.menu();
        }
        try {
            Checking.checkingTask(taskMap, id);
            taskMapDelete.put(id, taskMap.get(id));
            taskMap.remove(id);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
            Menu.menu();
        }
    }

    public static void getAllByDate() {
        System.out.println(print2Separ());
        System.out.println("Введите дату в формате ДД.ММ.ГГГГ для которой необходимо вывести все задачи");
        LocalDate localDate = RequestOfTheDate.requestOfTheDate();
        System.out.println("Задачи на " + localDate + " число:");
        taskMap
                .values()
                .stream()
                .filter(s -> s.getDate().equals(localDate))
                .forEach(System.out::println);
        System.out.println(print2Separ());
    }

    public static void editTitle() {
        System.out.println("Укажите номер задачи чтобы поменять заголовок");
        int id = -1;
        try {
            id = Integer.parseInt(Request.request());
        } catch (NumberFormatException e) {
            System.out.println("Не корректный ввод");
            Menu.menu();
        }
        try {
            Checking.checkingTask(taskMap, id);
            System.out.println("Введите новое название");
            String str = Request.request();
            taskMap.get(id).setTitle(str);
        } catch (NumberFormatException | TaskNotFoundException e) {
            System.out.println(e.getMessage());
            Menu.menu();
        }
    }

    public static void editDescription() {
        System.out.println("Укажите номер задачи чтобы поменять описание");
        int id = -1;
        try {
            id = Integer.parseInt(Request.request());
        } catch (NumberFormatException e) {
            System.out.println("Не корректный ввод");
            System.exit(0);
        }
        try {
            Checking.checkingTask(taskMap, id);
            System.out.println("Введите новое описание");
            String str = Request.request();
            taskMap.get(id).setDescription(str);
        } catch (NumberFormatException | TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void printTask(Map<Integer, Task> map) {
        System.out.println(print2Separ());
        map.values().stream().
                sorted(new ComparatorDate()).
                forEach(task -> System.out.println(task + "\n" + printSepar()));
        System.out.println(print2Separ());
    }

    private static String printSepar() {
        return "****************************************************************************";
    }

    private static String print2Separ() {
        return "****************************************************************************\n"
                + "****************************************************************************";
    }


}
