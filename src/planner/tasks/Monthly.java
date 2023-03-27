package planner.tasks;

interface Monthly extends AddDay {
    static Task add(Task task) {
        return AddMonth.add(task, 1);
    }
}
