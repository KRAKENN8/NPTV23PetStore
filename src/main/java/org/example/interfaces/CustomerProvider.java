package org.example.interfaces;

import org.example.model.Customer;

public interface CustomerProvider {
    Customer createCustomer(Input inputProvider);  // Метод для создания покупателя с использованием ввода
}
