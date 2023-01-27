package Animals.Herbivores;
import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Sheep extends Herbivores{

    public Sheep(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.SHEEP;
    }


}
