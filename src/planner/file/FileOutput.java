package planner.file;

import planner.tasks.Task;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class FileOutput {
    public static void fileOutputTask(Map<Integer, Task> taskService) {
        try {
            FileOutputStream fos = new FileOutputStream("JavaObjects.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(taskService);
            oos.close();
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void fileOutputTaskDel(Map<Integer, Task> taskService) {
        try {
            FileOutputStream fos = new FileOutputStream("JavaObjectsDel.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(taskService);
            oos.close();
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
