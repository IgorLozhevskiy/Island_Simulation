package Animals.Predators;

import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Eagle extends Predators {
    public Eagle(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.EAGLE;
    }
}
