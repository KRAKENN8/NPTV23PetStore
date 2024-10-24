package org.example.interfaces.impl;

import org.example.interfaces.PetStuffProvider;
import org.example.interfaces.Input;
import org.example.model.PetStuff;

public class PetStuffHelper implements PetStuffProvider {

    @Override
    public PetStuff createPetStuff(Input inputProvider) {
        PetStuff petStuff = new PetStuff();

        System.out.print("Введите название товара: ");
        petStuff.setName(inputProvider.getInput());

        System.out.print("Введите описание товара: ");
        petStuff.setDescription(inputProvider.getInput());

        double price = 0;
        while (true) {
            try {
                System.out.print("Введите цену товара: ");
                price = Double.parseDouble(inputProvider.getInput());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное числовое значение для цены.");
            }
        }
        petStuff.setPrice(price);

        System.out.print("Есть ли скидка на товар? (да/нет): ");
        String discountInput = inputProvider.getInput();
        if (discountInput.equalsIgnoreCase("да")) {
            petStuff.setHasDiscount(true);
            double discountedPrice = 0;
            while (true) {
                try {
                    System.out.print("Введите цену со скидкой: ");
                    discountedPrice = Double.parseDouble(inputProvider.getInput());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста, введите корректное числовое значение для цены со скидкой.");
                }
            }
            petStuff.setDiscountedPrice(discountedPrice);
        } else {
            petStuff.setHasDiscount(false);
        }

        return petStuff;
    }
}
