package planner.enums;

public enum Type {
    WORK("рабочая"),
    PERSONAL("личная");

    final String values;
    Type(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return values;
    }
}
