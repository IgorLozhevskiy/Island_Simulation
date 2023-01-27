package Animals.Herbivores;
import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Island.Island;

public class Duck extends Herbivores{

    public Duck(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.DUCK;
    }


}
