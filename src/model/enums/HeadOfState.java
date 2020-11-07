package model.enums;

public enum HeadOfState {
    MONARCH, PRESIDENT, KING;

    @Override
    public String toString() {
        String result = "";

        switch (this) {
            case MONARCH: result = "Монарх"; break;
            case PRESIDENT: result = "Президент"; break;
            case KING: result = "Король"; break;
        } return result;
    }
}