package Animals.Herbivores;

import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Deer extends Herbivores {
    public Deer(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType () {
        return AnimalType.DEER;
    }
}
