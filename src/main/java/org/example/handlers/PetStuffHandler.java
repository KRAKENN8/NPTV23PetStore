package org.example.handlers;

import org.example.model.App;
import org.example.interfaces.PetStuffProvider;
import org.example.interfaces.Input;
import org.example.model.PetStuff;

public class PetStuffHandler {
    private final Input inputProvider;
    private final PetStuffProvider petStuffProvider;

    public PetStuffHandler(Input inputProvider, PetStuffProvider petStuffProvider) {
        this.inputProvider = inputProvider;
        this.petStuffProvider = petStuffProvider;
    }

    public void addPetStuff() {
        PetStuff petStuff = petStuffProvider.createPetStuff(inputProvider);
        boolean added = false;

        for (int i = 0; i < App.petStuff.length; i++) {
            if (App.petStuff[i] == null) {
                App.petStuff[i] = petStuff;
                added = true;
                System.out.println("Товар успешно добавлен.");
                break;
            }
        }
    }

    public void listPetStuff() {
        boolean hasStuff = false;
        for (PetStuff stuff : App.petStuff) {
            if (stuff != null) {
                System.out.println("Название товара: " + stuff.getName());
                System.out.println("Описание: " + stuff.getDescription());
                System.out.println("Цена: " + stuff.getPrice() + "€");
                if (stuff.isHasDiscount()) {
                    System.out.println("Цена со скидкой: " + stuff.getDiscountedPrice());
                }
                System.out.println("------------------------");
                hasStuff = true;
            }
        }
    }

    public void findPetStuffByName() {
        System.out.print("Введите название товара для поиска: ");
        String name = inputProvider.getInput();
        boolean found = false;

        for (PetStuff stuff : App.petStuff) {
            if (stuff != null && stuff.getName().equalsIgnoreCase(name)) {
                System.out.println("Товар найден!");
                System.out.println("Название: " + stuff.getName());
                System.out.println("Описание: " + stuff.getDescription());
                System.out.println("Цена: " + stuff.getPrice());
                if (stuff.isHasDiscount()) {
                    System.out.println("Цена со скидкой: " + stuff.getDiscountedPrice());
                }
                System.out.println("------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Товар с таким названием не найден.");
        }
    }
}
