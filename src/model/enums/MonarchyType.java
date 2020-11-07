package model.enums;

public enum MonarchyType {
    ABSOLUTE, CONSTITUTIONAL, DUALISTIC;

    public static MonarchyType convert(int number) {
        for (MonarchyType value : values())
            if (value.ordinal() == number - 1) return value;
        return null;
    }

    @Override
    public String toString() {
        String result = "";

        switch (this) {
            case ABSOLUTE: result = "Абсолютная"; break;
            case CONSTITUTIONAL: result = "Конституционная"; break;
            case DUALISTIC: result = "Дуалистическая"; break;
        } return result;
    }
}