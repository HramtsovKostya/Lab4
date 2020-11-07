package model.states;

import model.enums.HeadOfState;
import model.enums.MonarchyType;

public class Kingdom extends Monarchy {
    public Kingdom(String name, String capital, int area, int population, MonarchyType type) {
        super(name, capital, area, population, type);
    }

    @Override
    public HeadOfState getHead() { return HeadOfState.KING; }

    @Override
    public String toString() { return super.toString().replace("Монархия", "Королевство"); }
}