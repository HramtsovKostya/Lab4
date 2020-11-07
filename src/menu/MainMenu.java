package menu;

import controller.*;
import menu.submenu.*;

public final class MainMenu {
    private static final Union union = new Union();

    public static void start() {
        int choice;
        System.out.println("Добро пожаловать в программу!");

        do {
            System.out.println("\n-------------------- Главное меню программы --------------------");
            System.out.println("\nВыберите одно из доступных действий:");

            System.out.println("\t1 - Создать новое государство;");
            System.out.println("\t2 - Удалить существующее государство;");
            System.out.println("\t3 - Найти указанное государство;");
            System.out.println("\t4 - Вывести список государств;");
            System.out.println("\t0 - Завершить выполнение программы.");

            System.out.print("\nВвод значения >> ");
            choice = InputController.inputInt(0, 4);

            switch (choice) {
                case 1: CreatorMenu.start(); break;
                case 2: RemoverMenu.start(); break;
                case 3: SearchMenu.start(); break;
                case 4: PrinterMenu.start(); break;
            }
        } while (choice != 0);

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Завершение работы программы...");
    }

    public static Union getUnion() { return union; }
}