package menu.submenu;

import controller.InputController;
import java.util.NoSuchElementException;
import menu.MainMenu;

public final class RemoverMenu {
    public static void start() {
        int choice;

        do {
            System.out.println("\n-------------- Удаление существующего государства --------------");
            System.out.println("\nВыберите одно из доступных действий:");

            System.out.println("\t1 - Удалить государство по номеру в списке;");
            System.out.println("\t2 - Удалить государство по названию;");
            System.out.println("\t3 - Удалить все государства из списка;");
            System.out.println("\t0 - Вернуться назад.");

            System.out.print("\nВвод значения >> ");
            choice = InputController.inputInt(0, 3);

            switch (choice) {
                case 1: removeStateToNumber(); break;
                case 2: removeStateToName(); break;
                case 3: removeAllStates(); break;
            }
        } while (choice != 0);
    }

    private static void removeStateToNumber() {
        if (size() > 0) {
            System.out.print("Введите номер удаляемого государства >> ");
            int number = InputController.inputInt(1, size());

            MainMenu.getUnion().remove(number - 1);
            System.out.println("Государство успешно удалено!");

        } else System.out.println("Список государств пуст!");
    }

    private static void removeStateToName() {
        if (size() > 0) {
            System.out.print("Введите название удаляемого государства >> ");
            String name = InputController.inputString();

            try {
                MainMenu.getUnion().remove(MainMenu.getUnion().find(name));
                System.out.println("Государство успешно удалено!");

            } catch (NoSuchElementException exception) {
                System.out.println("Государство с таким названием не найдено!");
            }

        } else System.out.println("Список государств пуст!");
    }

    private static void removeAllStates() {
        if (size() > 0) {
            MainMenu.getUnion().clear();
            System.out.println("Список государств успешно очищен!");
        } else System.out.println("Список государств пуст!");
    }

    private static int size() { return MainMenu.getUnion().size(); }
}