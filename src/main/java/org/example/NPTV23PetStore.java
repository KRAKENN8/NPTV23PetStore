package org.example;

import org.example.handlers.CustomerHandler;
import org.example.handlers.PetStuffHandler;
import org.example.interfaces.Input;
import org.example.interfaces.impl.ConsoleInput;
import org.example.interfaces.impl.PetStuffHelper;
import org.example.interfaces.impl.CustomerHelper;
import org.example.model.App;


public class NPTV23PetStore {
    public static void main(String[] args) {
        Input inputProvider = new ConsoleInput();
        PetStuffHelper petStuffHelper = new PetStuffHelper();
        CustomerHelper customerHelper = new CustomerHelper();

        PetStuffHandler petStuffHandler = new PetStuffHandler(inputProvider, petStuffHelper);
        CustomerHandler customerHandler = new CustomerHandler(inputProvider, customerHelper);


        App app = new App(petStuffHandler, customerHandler, inputProvider);
        app.run();
    }
}
