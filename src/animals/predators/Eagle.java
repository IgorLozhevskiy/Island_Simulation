package animals.predators;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Eagle extends Predators {
    public Eagle(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.EAGLE;
    }
}
