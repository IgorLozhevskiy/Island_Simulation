package animals.predators;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Fox extends Predators {
    public Fox(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.FOX;
    }
}
