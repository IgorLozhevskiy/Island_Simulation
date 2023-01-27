package Animals.Herbivores;
import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Goat extends Herbivores{

    public Goat(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.GOAT;
    }


}
