package planner.tasks;

interface Daily {
    static Task add(Task task) {
        return AddDay.add(task,1);
    }
}
