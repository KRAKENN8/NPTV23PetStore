package org.example.interfaces;

import org.example.model.PetStuff;

public interface PetStuffProvider {
    PetStuff createPetStuff(Input inputProvider);  // Используем Input вместо InputProvider
}
