package animals.predators;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Bear extends Predators {
    public Bear(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BEAR;
    }
}
