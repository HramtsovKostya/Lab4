package menu.submenu;

import controller.InputController;
import model.states.State;
import java.util.NoSuchElementException;
import menu.MainMenu;

public final class SearchMenu {
    private static State state;

    public static void start() {
        int choice;

        do {
            System.out.println("\n--------------- Поиск существующего государства ---------------");
            System.out.println("\nВыберите одно из доступных действий:");

            System.out.println("\t1 - Найти первое государство в списке;");
            System.out.println("\t2 - Найти последнее государство в списке;");
            System.out.println("\t3 - Найти государство по номеру в списке;");
            System.out.println("\t4 - Найти государство по названию;");
            System.out.println("\t0 - Вернуться назад.");

            System.out.print("\nВыбор действия >> ");
            choice = InputController.inputInt(0, 4);

            switch (choice) {
                case 1: findFirstState(); break;
                case 2: findLastState(); break;
                case 3: findStateToNumber(); break;
                case 4: findStateToName(); break;
            }

            if (choice != 0 && state != null) startSubmenu();
        } while (choice != 0);
    }

    private static void startSubmenu() {
        int choice;

        do {
            System.out.println("\nВыберите одно из доступных действий:");
            System.out.println("\t1 - Получить доп. информацию о государстве;");
            System.out.println("\t2 - Изменить данные о текущем государстве;");
            System.out.println("\t0 - Вернуться назад.");

            System.out.print("\nВыбор действия >> ");
            choice = InputController.inputInt(0, 2);

            switch (choice) {
                case 1: InformerMenu.start(); break;
                case 2: EditorMenu.start(); break;
            }
        } while (choice != 0);
    }

    private static void findFirstState() {
        if (size() > 0) {
            state = MainMenu.getUnion().get(0);
            System.out.println("Искомое государство:\n" + state);
        } else System.out.println("Список государств пуст!");
    }

    private static void findLastState() {
        if (size() > 0) {
            state = MainMenu.getUnion().get(size() - 1);
            System.out.println("Искомое государство:\n" + state);
        } else System.out.println("Список государств пуст!");
    }

    private static void findStateToNumber() {
        if (size() > 0) {
            System.out.print("Введите номер искомого государства >> ");
            int number = InputController.inputInt(1, size());

            state = MainMenu.getUnion().get(number - 1);
            System.out.println("Искомое государство:\n" + state);

        } else System.out.println("Список государств пуст!");
    }

    private static void findStateToName() {
        if (size() > 0) {
            System.out.print("Введите название искомого государства >> ");
            String name = InputController.inputString();

            try {
                state = MainMenu.getUnion().find(name);
                System.out.println("Искомое государство:\n" + state);

            } catch (NoSuchElementException exception) {
                System.out.println("Государство с таким названием не найдено!");
            }

        } else System.out.println("Список государств пуст!");
    }

    private static int size() { return MainMenu.getUnion().size(); }
    public static State getState() { return state; }
}