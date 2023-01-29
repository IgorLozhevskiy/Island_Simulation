package animals.predators;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import animals.herbivores.Herbivores;
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
