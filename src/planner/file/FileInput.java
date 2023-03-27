package planner.file;

import planner.tasks.Task;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class FileInput {
    public static Map<Integer, Task> fileInputTask() {
        Map<Integer, Task> taskService = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream("JavaObjects.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            taskService = (Map<Integer, Task>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ne to");
        }
        return taskService;
    }
    public static Map<Integer, Task> fileInputTaskDel() {
        Map<Integer, Task> taskService = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream("JavaObjectsDel.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            taskService = (Map<Integer, Task>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ne to");
        }
        return taskService;
    }
}
