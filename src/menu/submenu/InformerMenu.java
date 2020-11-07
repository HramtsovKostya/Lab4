package menu.submenu;

import controller.InputController;
import model.enums.HeadOfState;

public final class InformerMenu {
    public static void start() {
        int choice;

        do {
            System.out.println("\n--------------- Доп. информация о государстве ---------------");
            System.out.println("\nВыберите одно из доступных действий:");

            System.out.println("\t1 - Узнать название государства;");
            System.out.println("\t2 - Узнать столицу государства;");
            System.out.println("\t3 - Узнать площадь государства;");
            System.out.println("\t4 - Узнать население государства;");
            System.out.println("\t5 - Узнать плотность населения;");
            System.out.println("\t6 - Узнать главу государства;");
            System.out.println("\t7 - Узнать о наличии парламента;");
            System.out.println("\t0 - Вернуться назад.");

            System.out.print("\nВыбор действия >> ");
            choice = InputController.inputInt(0, 7);

            switch (choice) {
                case 1: getInfoOfName(); break;
                case 2: getInfoOfCapital(); break;
                case 3: getInfoOfArea(); break;
                case 4: getInfoOfPopulation(); break;
                case 5: getInfoOfDensity(); break;
                case 6: getInfoOfHead(); break;
                case 7: getInfoOfParliament(); break;
            }
        } while (choice != 0);
    }

    private static void getInfoOfName() {
        String name = SearchMenu.getState().getName();
        System.out.println("Назввание государства: " + name);
    }

    private static void getInfoOfCapital() {
        String capital = SearchMenu.getState().getCapital();
        System.out.println("Столица государства: " + capital);
    }

    private static void getInfoOfArea() {
        int area = SearchMenu.getState().getArea();
        System.out.println("Площадь государства: " + area + " кв. км");
    }

    private static void getInfoOfPopulation() {
        int population = SearchMenu.getState().getPopulation();
        System.out.println("Население государства: " + population + " чел.");
    }

    private static void getInfoOfDensity() {
        int density = SearchMenu.getState().getDensity();
        System.out.println("Плотность населения: " + density + " чел./кв. км.");
    }

    private static void getInfoOfHead() {
        HeadOfState head = SearchMenu.getState().getHead();
        System.out.println("Глава государства: " + head);
    }

    private static void getInfoOfParliament() {
        boolean hasParliament = SearchMenu.getState().hasParliament();
        System.out.println("В государстве " + (hasParliament ? "есть парламент" : "нет парламента"));
    }
}