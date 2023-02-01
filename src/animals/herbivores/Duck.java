package animals.herbivores;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Duck extends Herbivores {

    public Duck(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.DUCK;
    }


}
