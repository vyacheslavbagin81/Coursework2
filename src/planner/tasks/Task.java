package planner.tasks;

import planner.enums.AgainTask;
import planner.enums.Type;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements Serializable {
    private static int idGenerator;
    private String title; //заголовок
    private Type type;  //тип (личная, рабочая)
    private int id;
    private LocalDate date;
    private String description;  //поле для описания
    private AgainTask againTask;  //признак повторяемости

    // конструктор
    Task(LocalDate date, String title,String description, Type type, AgainTask againTask, int id) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.type = type;
        this.againTask = againTask;
        this.id = id;
    }

    // гетеры и сетеры
    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public AgainTask getAgainTask() {
        return againTask;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && title.equals(task.title) && type == task.type && date.equals(task.date) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, date, description);
    }


    // toString
    @Override
    public String toString() {
        return  "№ " + id + "\n" +
                "Задача: " + title + "\n" +
                "Тип задачи: " + type + "\n" +
                "Дата выполнения: " + date +
                " переодичность: " + againTask + "\n" +
                "Описание задачи: " + description +  "\n";
    }

}
