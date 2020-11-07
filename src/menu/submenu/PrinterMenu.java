package menu.submenu;

import controller.*;
import menu.MainMenu;

public final class PrinterMenu {
    public static void start() {
        int choice;

        do {
            System.out.println("\n------------------- Вывод списка государств -------------------");
            System.out.println("\nВыберите одно из доступных действий:");

            System.out.println("\t1 - Вывести список всех государств;");
            System.out.println("\t2 - Вывести список монархий;");
            System.out.println("\t3 - Вывести список республик;");
            System.out.println("\t4 - Вывести список королевств;");
            System.out.println("\t0 - Вернуться назад.");

            System.out.print("\nВвод значения >> ");
            choice = InputController.inputInt(0, 4);

            switch (choice) {
                case 1: printStates(); break;
                case 2: printMonarchies(); break;
                case 3: printRepublics(); break;
                case 4: printKingdoms(); break;
            }
        } while (choice != 0);
    }

    private static void printStates() {
        if (size() > 0) {
            System.out.println("Список всех государств:");
            System.out.println(MainMenu.getUnion());

        } else System.out.println("Список государств пуст!");
    }

    private static void printMonarchies() {
        if (size() > 0) {
            Union monarchies = MainMenu.getUnion().getMonarchies();

            if (monarchies.size() > 0) System.out.println("Список монархий:\n" + monarchies);
            else System.out.println("Монархии не найдены!");

        } else System.out.println("Список государств пуст!");
    }

    private static void printRepublics() {
        if (size() > 0) {
            Union republics = MainMenu.getUnion().getRepublics();

            if (republics.size() > 0) System.out.println("Список республик:\n" + republics);
            else System.out.println("Республики не найдены!");

        } else System.out.println("Список государств пуст!");
    }

    private static void printKingdoms() {
        if (size() > 0) {
            Union kingdoms = MainMenu.getUnion().getKingdoms();

            if (kingdoms.size() > 0) System.out.println("Список королевств:\n" + kingdoms);
            else System.out.println("Королевства не найдены!");

        } else System.out.println("Список государств пуст!");
    }

    private static int size() { return MainMenu.getUnion().size(); }
}