package controller;

import model.states.*;
import java.util.ArrayList;
import java.util.List;

public class Union {
    private final List<State> states;

    public Union() { states = new ArrayList<>(); }
    public int size() { return states.size(); }

    public State get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива!");
        } return states.get(index);
    }

    public Union getMonarchies() { return getStates(Monarchy.class); }
    public Union getRepublics() { return getStates(Republic.class); }
    public Union getKingdoms() { return getStates(Kingdom.class); }

    private Union getStates(Class<? extends State> stateClass) {
        Union union = new Union();
        states.stream().filter(state -> state.getClass() == stateClass).forEach(union::add);
        return union;
    }

    public State find(String name) {
        return states.stream().filter(state -> state.getName().equals(name)).findFirst().get();
    }

    public void add(State state) { states.add(state); }
    public void remove(State state) { states.remove(state); }
    public void remove(int index) { if (index >= 0 && index < size()) states.remove(index); }
    public void clear() { states.clear(); }

    @Override
    public String toString() {
        StringBuilder union = new StringBuilder();
        for (State state : states) union.append(state);
        return union.toString();
    }
}