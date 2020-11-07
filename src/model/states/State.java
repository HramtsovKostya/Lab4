package model.states;
import model.enums.HeadOfState;

public abstract class State {
    protected String name;
    protected String capital;
    protected int area;
    protected int population;

    protected State(String name, String capital, int area, int population) {
        setName(name);
        setCapital(capital);
        setArea(area);
        setPopulation(population);
    }

    public String getName() { return name; }
    public String getCapital() { return capital; }
    public int getArea() { return area; }
    public int getPopulation() { return population; }

    public int getDensity() { return (int) Math.ceil((double) population / area); }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            String error = "Название государства не может равняться null или пустой строке!";
            throw new IllegalArgumentException(error);
        } this.name = name;
    }

    public void setCapital(String capital) {
        if (capital == null || capital.isEmpty()) {
            String error = "Название столицы не может равняться null или пустой строке!";
            throw new IllegalArgumentException(error);
        } this.capital = capital;
    }

    public void setArea(int area) {
        if (area <= 0) {
            String error = "Площадь государства должна равняться целому положительному числу!";
            throw new IllegalArgumentException(error);
        } this.area = area;
    }

    public void setPopulation(int population) {
        if (population <= 0) {
            String error = "Население государства должно равняться целому положительному числу!";
            throw new IllegalArgumentException(error);
        } this.population = population;
    }

    public abstract HeadOfState getHead();
    public abstract boolean hasParliament();
}