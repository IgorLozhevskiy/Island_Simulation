package animals.predators;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Snake extends Predators {
    public Snake(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.SNAKE;
    }
}
