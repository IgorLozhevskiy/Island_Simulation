package animals.herbivores;
import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.Island;

public class Sheep extends Herbivores{

    public Sheep(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.SHEEP;
    }


}
