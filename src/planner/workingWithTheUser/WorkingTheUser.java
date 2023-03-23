package planner.workingWithTheUser;

import planner.enums.AgainTask;
import planner.enums.Type;
import planner.erorrs.Checking;
import planner.erorrs.IncorrectArgumentException;
import planner.tasks.TaskService;

import java.time.LocalDate;

public class WorkingTheUser {

    public static LocalDate addLocalDate() {
        System.out.println("Введите дату для запланированной задачи в формате ДД.ММ.ГГГГ и нажмите ввод");
        return Checking.checkingData(RequestOfTheDate.requestOfTheDate());
    }

    public static String addTitle() {
        System.out.println("Введите название для запланированной задачи и нажмите ввод");
        return RequestTitle.requestTitle();
    }

    public static String addDescription() {
        System.out.println("Введите краткое описание запланированной задачи и нажмите ввод");
        return Request.request();
    }
    public static Type addType (){
        Type type = Type.PERSONAL;
        try {
            type = choiceType();
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
            Menu.menu();
        }
        return type;
    }

    public static AgainTask addAgainTask() {
        AgainTask againTask = AgainTask.ONCE;
        try {
            againTask = choiceAgainTask();
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
            Menu.menu();
        }
        return againTask;
    }

    private static Type choiceType() throws IncorrectArgumentException {
        System.out.println("Выберите тип задачи");
        System.out.println("1 - рабочая");
        System.out.println("2 - личная");
        String str = Request.request();
        switch (str) {
            case "1" -> {
                return Type.WORK;
            }
            case "2" -> {
                return Type.PERSONAL;
            }
            default -> throw new IncorrectArgumentException("Не корректные данные! Попробуйте еще раз!");
        }
    }
    private static AgainTask choiceAgainTask() throws IncorrectArgumentException {
        System.out.println("Выберите повторяемость задачи");
        System.out.println("1 - единожды");
        System.out.println("2 - ежедневно");
        System.out.println("3 - еженедельно");
        System.out.println("4 - ежемесячно");
        System.out.println("5 - ежегодно");
        String str = Request.request();
        switch (str) {
            case "1" -> {
                return AgainTask.ONCE;
            }
            case "2" -> {
                return AgainTask.DAILY;
            }
            case "3" -> {
                return AgainTask.WEEKLY;
            }
            case "4" -> {
                return AgainTask.MONTHLY;
            }
            case "5" -> {
                return AgainTask.ANNUALLY;
            }
            default -> throw new IncorrectArgumentException("Не корректные данные! Попробуйте еще раз!");
        }
    }
    public static void choiceRemovTask() throws IncorrectArgumentException {
        System.out.println("Выберите признак для удаления задачи");
        System.out.println("1 - по наименованию");
        System.out.println("2 - по номеру");
        String str = Request.request();
        switch (str) {
            case "1" -> TaskService.remove("1");
            case "2" -> TaskService.remove(2);
            default -> throw new IncorrectArgumentException("Не корректные данные! Попробуйте еще раз!");
        }
    }
}
