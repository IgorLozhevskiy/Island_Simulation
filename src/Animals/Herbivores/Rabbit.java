package Animals.Herbivores;

import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Rabbit extends Herbivores {
    public Rabbit(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.RABBIT;
    }
}
