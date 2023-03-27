package planner.tasks;

interface Once {
    static Task add(Task task) {
        return AddDay.add(task,1);
    }
}
