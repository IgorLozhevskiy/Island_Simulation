package animals.herbivores;
import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Buffalo extends Herbivores {

    public Buffalo(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BUFFALO;
    }


}
