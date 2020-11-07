package model.states;

import model.enums.HeadOfState;
import model.enums.MonarchyType;

public class Monarchy extends State {
    protected MonarchyType type;

    public Monarchy(String name, String capital, int area, int population, MonarchyType type) {
        super(name, capital, area, population);

        if (type == null) {
            throw new IllegalArgumentException("Тип монархии не может быть равным null!");
        } this.type = type;
    }

    @Override
    public HeadOfState getHead() { return HeadOfState.MONARCH; }

    @Override
    public boolean hasParliament() { return type != MonarchyType.ABSOLUTE; }

    @Override
    public String toString() {
        return "\nМонархия:" +
            "\n\tНазвание = '" + name + "'," +
            "\n\tСтолица = '" + capital + "'," +
            "\n\tТип монархии = " + type + "," +
            "\n\tПлощадь = " + area + " кв. км," +
            "\n\tНаселение = " + population + " чел.\n";
    }
}