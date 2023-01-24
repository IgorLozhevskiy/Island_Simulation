package Animals.Herbivores;
import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Horse extends Herbivores{

    public Horse(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.HORSE;
    }


}
