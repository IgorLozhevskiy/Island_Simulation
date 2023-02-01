package animals.herbivores;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Mouse extends Herbivores {
    public Mouse(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.MOUSE;
    }
}
