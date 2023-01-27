package Animals.Predators;

import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Snake extends Predators {
    public Snake(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.SNAKE;
    }
}
