package menu.submenu;

import controller.InputController;
import model.enums.*;
import model.states.*;
import menu.MainMenu;

public final class CreatorMenu {
    private static String name;
    private static String capital;
    private static int area;
    private static int population;

    public static void start() {
        int choice;

        do {
            System.out.println("\n------------------ Создание нового государства ------------------");
            System.out.println("\nВыберите одно из доступных действий:");

            System.out.println("\t1 - Создать новую монархию;");
            System.out.println("\t2 - Создать новую республику;");
            System.out.println("\t3 - Создать новое королевство;");
            System.out.println("\t0 - Вернуться назад.");

            System.out.print("\nВвод значения >> ");
            choice = InputController.inputInt(0, 3);

            if (choice != 0) createState();

            switch (choice) {
                case 1: createMonarchy(); break;
                case 2: createRepublic(); break;
                case 3: createKingdom(); break;
            } if (choice != 0) System.out.println("Государство успешно создано!");

        } while (choice != 0);
    }

    private static void createState() {
        System.out.print("Введите название государства >> ");
        name = InputController.inputString();

        System.out.print("Введите название столицы >> ");
        capital = InputController.inputString();

        System.out.print("Введите площадь государства >> ");
        area = InputController.inputInt(1, (int) (2 * Math.pow(10, 7)));

        System.out.print("Введите население государства >> ");
        population = InputController.inputInt(1000, (int) (2 * Math.pow(10, 9)));
    }

    private static void createMonarchy() {
        MonarchyType type = getMonarchyType();
        Monarchy monarchy = new Monarchy(name, capital, area, population, type);
        MainMenu.getUnion().add(monarchy);
    }

    private static void createRepublic() {
        RepublicType type = getRepublicType();
        Republic republic = new Republic(name, capital, area, population, type);
        MainMenu.getUnion().add(republic);
    }

    private static void createKingdom() {
        MonarchyType type = getMonarchyType();
        Kingdom kingdom = new Kingdom(name, capital, area, population, type);
        MainMenu.getUnion().add(kingdom);
    }

    private static MonarchyType getMonarchyType() {
        System.out.println("\nВыберите тип монархии:");
        System.out.println("1 - Абсолютная;");
        System.out.println("2 - Конституционная;");
        System.out.println("3 - Дуалистическая.");

        System.out.print("\nВвод значения >> ");
        return MonarchyType.convert(InputController.inputInt(1, 3));
    }

    private static RepublicType getRepublicType() {
        System.out.println("\nВыберите тип республики:");
        System.out.println("1 - Президентская;");
        System.out.println("2 - Парламентская;");
        System.out.println("3 - Смешанная.");

        System.out.print("\nВвод значения >> ");
        return RepublicType.convert(InputController.inputInt(1, 3));
    }
}