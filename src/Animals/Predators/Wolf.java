package Animals.Predators;

import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Wolf extends Predators {
    public Wolf(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public void eat() {

    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.WOLF;
    }
}
