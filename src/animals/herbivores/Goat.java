package animals.herbivores;
import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Goat extends Herbivores {

    public Goat(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.GOAT;
    }


}
