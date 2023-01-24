package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalCharacteristics;
import Animals.Eatable;
import Island.Island;

public abstract class Herbivores extends Animal implements Eatable {
    public Herbivores(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


}
