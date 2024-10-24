package org.example.interfaces.impl;

import org.example.interfaces.CustomerProvider;
import org.example.interfaces.Input;
import org.example.model.Customer;

public class CustomerHelper implements CustomerProvider {

    @Override
    public Customer createCustomer(Input inputProvider) {
        Customer customer = new Customer();
        System.out.print("Введите имя покупателя: ");
        customer.setName(inputProvider.getInput());
        System.out.print("Введите фамилию покупателя: ");
        customer.setSurname(inputProvider.getInput());
        System.out.print("Введите номер телефона покупателя: ");
        customer.setPhone(inputProvider.getInput());

        return customer;
    }
}
