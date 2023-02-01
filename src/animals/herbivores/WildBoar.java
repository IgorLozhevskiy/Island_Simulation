package animals.herbivores;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class WildBoar extends Herbivores {
    public WildBoar(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }
    @Override
    public AnimalType getAnimalType() {
        return AnimalType.WILD_BOAR;
    }
}
