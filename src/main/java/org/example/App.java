package org.example.model;

import org.example.handlers.CustomerHandler;
import org.example.handlers.PetStuffHandler;
import org.example.interfaces.Input;

public class App {
    public static PetStuff[] petStuff = new PetStuff[100];
    public static Customer[] customers = new Customer[100];

    private final PetStuffHandler petStuffHandler;
    private final CustomerHandler customerHandler;
    private final Input inputProvider;

    public App(PetStuffHandler petStuffHandler, CustomerHandler customerHandler, Input inputProvider) {
        this.petStuffHandler = petStuffHandler;
        this.customerHandler = customerHandler;
        this.inputProvider = inputProvider;
    }

    public void run() {
        System.out.println("------ Магазин товаров для домашних животных NPTV23 ------");
        System.out.println("---------------------------------------------------------");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить товар для домашних животных");
            System.out.println("2. Список товаров");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.print("Введите номер задачи: ");

            int task = Integer.parseInt(inputProvider.getInput());

            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("----- Добавление товара -----");
                    petStuffHandler.addPetStuff();
                    break;
                case 2:
                    System.out.println("----- Список товаров -----");
                    petStuffHandler.listPetStuff(); // Вывод всех товаров
                    break;
                case 3:
                    System.out.println("----- Добавление покупателя -----");
                    customerHandler.addCustomer();
                    break;
                case 4:
                    System.out.println("----- Список покупателей -----");
                    customerHandler.listCustomers();
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");
                    break;
            }
        } while (repeat);

        System.out.println("До свидания :)");
    }
}
