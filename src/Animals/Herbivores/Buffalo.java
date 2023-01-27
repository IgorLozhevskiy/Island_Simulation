package Animals.Herbivores;
import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Buffalo extends Herbivores{

    public Buffalo(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BUFFALO;
    }


}
