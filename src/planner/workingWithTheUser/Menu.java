package planner.workingWithTheUser;

import planner.erorrs.Checking;
import planner.erorrs.IncorrectArgumentException;
import planner.file.FileOutput;
import planner.tasks.TaskService;

public class Menu {
    public static void menu() {
        int s = 0;
        System.out.println("Выберете действие:");
        System.out.println("1 - добавить задачу");
        System.out.println("2 - удалить задачу");
        System.out.println("3 - вывести задачи на определенную дату");
        System.out.println("4 - распечатать все задачи");
        System.out.println("5 - распечатать все удаленные задачи");
        System.out.println("6 - редактировать задачи");
        System.out.println("0 - завершить работу");
        try {
            s = Integer.parseInt(Request.request());
        } catch (NumberFormatException e) {
            System.out.println("Не корректный ввод");
            menu();
        }
        try {
            Checking.checkingMenu(s, 6);
            switch (s) {
                case 1 -> {
                    TaskService.addTask();
                    System.out.println();
                    menu();
                }
                case 2 -> {
                    WorkingTheUser.choiceRemovTask();
                    FileOutput.fileOutputTaskDel(TaskService.getTaskMapDelete());
                    System.out.println();
                    menu();
                }
                case 3 -> {
                    TaskService.getAllByDate();
                    System.out.println();
                    menu();
                }
                case 4 -> {
                    TaskService.printTask(TaskService.getTaskMap());
                    System.out.println();
                    menu();
                }
                case 5 -> {
                    TaskService.printTask(TaskService.getTaskMapDelete());
                    System.out.println();
                    menu();
                }
                case 6 -> {
                    menuEdit();
                    System.out.println();
                    menu();
                }
                case 0 -> {
                    FileOutput.fileOutputTask(TaskService.getTaskMap());

                    System.exit(0);}
            }
        } catch (NumberFormatException | IncorrectArgumentException e) {
            System.out.println(e.getMessage());
            menu();
        }
    }

    private static void menuEdit() {
        int s = 0;
        System.out.println("Выберете действие:");
        System.out.println("1 - редактировать заголовок");
        System.out.println("2 - редактировать описание");
        System.out.println("0 - вернуться в главное меню");
        try {
            s = Integer.parseInt(Request.request());
        } catch (NumberFormatException e) {
            System.out.println("Не корректный ввод");
            menu();
        }
        try {
            Checking.checkingMenu(s, 2);
            switch (s) {
                case 1 -> {
                    TaskService.editTitle();
                    System.out.println();
                    menu();
                }
                case 2 -> {
                    TaskService.editDescription();
                    System.out.println();
                    menu();
                }
                case 0 -> menu();
            }
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
            menu();
        } catch (NumberFormatException n) {
            System.out.println("Не корректные данные!");
            menu();
        }
    }
}
