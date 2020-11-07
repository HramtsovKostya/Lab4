package model.states;

import model.enums.HeadOfState;
import model.enums.RepublicType;

public class Republic extends State {
    protected RepublicType type;

    public Republic(String name, String capital, int area, int population, RepublicType type) {
        super(name, capital, area, population);

        if (type == null) {
            throw new IllegalArgumentException("Тип республики не может быть равным null!");
        } this.type = type;
    }

    @Override
    public HeadOfState getHead() { return HeadOfState.PRESIDENT; }

    @Override
    public boolean hasParliament() { return type != RepublicType.PRESIDENTIAL; }

    @Override
    public String toString() {
        return "\nРеспублика:" +
            "\n\tНазвание = '" + name + "'," +
            "\n\tСтолица = '" + capital + "'," +
            "\n\tТип республики = " + type + "," +
            "\n\tПлощадь = " + area + " кв. км," +
            "\n\tНаселение = " + population + " чел.\n";
    }
}