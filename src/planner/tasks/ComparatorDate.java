package planner.tasks;

import java.util.Comparator;

public class ComparatorDate implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getDate().isAfter(o2.getDate())) {
            return 1;
        } else if (o1.getDate().isBefore(o2.getDate())) {
            return -1;
        }
        return 0;
    }

}
