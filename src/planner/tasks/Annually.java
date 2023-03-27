package planner.tasks;

interface Annually extends AddDay {
    static Task add(Task task) {
        return AddMonth.add(task,12);
    }
}
