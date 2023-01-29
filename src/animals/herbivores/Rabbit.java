package animals.herbivores;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Rabbit extends Herbivores {
    public Rabbit(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.RABBIT;
    }
}
