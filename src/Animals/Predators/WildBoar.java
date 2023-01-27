package Animals.Herbivores;
import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Animals.Predators.Predators;
import Island.Island;

public class WildBoar extends Predators {

    public WildBoar(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public AnimalType getAnimalType() {
        return AnimalType.WILD_BOAR;
    }


}
