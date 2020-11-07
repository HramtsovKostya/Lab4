package menu.submenu;
import controller.InputController;

public final class EditorMenu {
    public static void start() {
        int choice;

        do {
            System.out.println("\n--------------- Изменение данных о государстве ---------------");
            System.out.println("\nВыберите одно из доступных действий:");

            System.out.println("\t1 - Изменить название государства;");
            System.out.println("\t2 - Изменить столицу государства;");
            System.out.println("\t3 - Изменить площадь государства;");
            System.out.println("\t4 - Изменить население государства;");
            System.out.println("\t0 - Вернуться назад.");

            System.out.print("\nВыбор действия >> ");
            choice = InputController.inputInt(0, 4);

            switch (choice) {
                case 1: changeName(); break;
                case 2: changeCapital(); break;
                case 3: changeArea(); break;
                case 4: changePopulation(); break;
            }
        } while (choice != 0);
    }

    private static void changeName() {
        System.out.print("Введите название государства >> ");
        String name = InputController.inputString();

        SearchMenu.getState().setName(name);
        System.out.println("Название государства успешно изменено!");
    }

    private static void changeCapital() {
        System.out.print("Введите название столицы >> ");
        String capital = InputController.inputString();

        SearchMenu.getState().setCapital(capital);
        System.out.println("Столица государства успешно изменена!");
    }

    private static void changeArea() {
        System.out.print("Введите площадь государства >> ");
        int area = InputController.inputInt(100, 1000000);

        SearchMenu.getState().setArea(area);
        System.out.println("Площадь государства успешно изменена!");
    }

    private static void changePopulation() {
        System.out.print("Введите население государства >> ");
        int population = InputController.inputInt(1000, 1000000000);

        SearchMenu.getState().setPopulation(population);
        System.out.println("Население государства успешно изменено!");
    }
}