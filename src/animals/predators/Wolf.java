package animals.predators;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Wolf extends Predators {
    public Wolf(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.WOLF;
    }
}
