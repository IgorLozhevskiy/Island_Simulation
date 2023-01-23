package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalCharacteristics;
import Island.Island;

public abstract class Herbivores extends Animal {
    public Herbivores(Island island, AnimalCharacteristics animalCharacteristics) {
        super(animalCharacteristics);
    }
}
