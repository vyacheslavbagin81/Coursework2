package planner.tasks;

interface Weekly extends AddDay {
    static Task add(Task task) {
        return AddDay.add(task, 7);
    }
}
