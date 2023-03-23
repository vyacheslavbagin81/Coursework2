package planner.enums;

public enum AgainTask {
    ONCE("однократно"),
    DAILY("ежедневно"),
    WEEKLY("еженедельно"),
    MONTHLY("ежемесячно"),
    ANNUALLY("ежегодно");
    final String values;
    AgainTask(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return values;
    }
}
