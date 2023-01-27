package Animals.Predators;

import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Fox extends Predators {
    public Fox(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.FOX;
    }
}
