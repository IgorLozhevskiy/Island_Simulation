package animals.herbivores;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Deer extends Herbivores {
    public Deer(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType () {
        return AnimalType.DEER;
    }
}
