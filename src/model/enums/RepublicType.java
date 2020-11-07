package model.enums;

public enum RepublicType {
    PRESIDENTIAL, PARLIAMENTARY, MIXED;

    public static RepublicType convert(int number) {
        for (RepublicType value : values())
            if (value.ordinal() == number - 1) return value;
        return null;
    }

    @Override
    public String toString() {
        String result = "";

        switch (this) {
            case PRESIDENTIAL: result = "Президентская"; break;
            case PARLIAMENTARY: result = "Парламентская"; break;
            case MIXED: result = "Смешанная"; break;
        } return result;
    }
}