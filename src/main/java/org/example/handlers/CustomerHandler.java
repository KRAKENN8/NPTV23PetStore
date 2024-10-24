package org.example.handlers;

import org.example.model.App;
import org.example.interfaces.CustomerProvider;
import org.example.interfaces.Input;
import org.example.model.Customer;

public class CustomerHandler {
    private final Input inputProvider;
    private final CustomerProvider customerProvider;

    public CustomerHandler(Input inputProvider, CustomerProvider customerProvider) {
        this.inputProvider = inputProvider;
        this.customerProvider = customerProvider;
    }

    public void addCustomer() {
        Customer customer = customerProvider.createCustomer(inputProvider);
        boolean added = false;

        for (int i = 0; i < App.customers.length; i++) {
            if (App.customers[i] == null) {
                App.customers[i] = customer;
                added = true;
                System.out.println("Покупатель успешно добавлен.");
                break;
            }
        }

        if (!added) {
            System.out.println("Массив покупателей заполнен, добавление невозможно.");
        }
    }

    public void listCustomers() {
        boolean hasCustomers = false;
        for (Customer customer : App.customers) {
            if (customer != null) {
                System.out.println("Имя покупателя: " + customer.getName());
                System.out.println("Фамилия покупателя: " + customer.getSurname());
                System.out.println("Номер телефона покупателя: " + customer.getPhone());
                System.out.println("------------------------");
                hasCustomers = true;
            }
        }

        if (!hasCustomers) {
            System.out.println("В системе нет зарегистрированных покупателей.");
        }
    }
}
