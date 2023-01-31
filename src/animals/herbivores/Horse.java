package animals.herbivores;
import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Horse extends Herbivores {

    public Horse(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.HORSE;
    }


}
