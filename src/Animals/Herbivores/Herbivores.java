package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalCharacteristics;
import Island.Island;
import org.w3c.dom.ls.LSOutput;

public abstract class Herbivores extends Animal {
    public Herbivores(Island island, AnimalCharacteristics animalCharacteristics) {
        super(animalCharacteristics);
    }

}
