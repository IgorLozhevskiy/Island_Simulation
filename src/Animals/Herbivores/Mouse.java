package Animals.Predators;

import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Animals.Herbivores.Herbivores;
import Island.Island;

public class Mouse extends Herbivores {
    public Mouse(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.MOUSE;
    }
}
