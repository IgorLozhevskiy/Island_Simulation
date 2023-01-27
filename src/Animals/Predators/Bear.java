package Animals.Predators;

import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Bear extends Predators {
    public Bear(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BEAR;
    }
}
