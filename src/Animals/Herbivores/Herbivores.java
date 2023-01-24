package Animals.Herbivores;

import Animals.Animal;
import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Config.AnimalsConfig;
import Island.IslandCell;
import Island.Island;

import java.util.Map;
import java.util.Set;

public abstract class Herbivores extends Animal {
    private AnimalCharacteristics animalCharacteristics;

    public Herbivores(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public void eat() {
        this.animalCharacteristics = animalCharacteristics;
        IslandCell position = this.getPosition();
        int currentPlantsInCell = position.getQuantityPlantsInCell();
        Map<AnimalType, Set<Animal>> currentAnimalsInCell = position.getAnimalList();

        for (Map.Entry<AnimalType, Set<Animal>> pair : currentAnimalsInCell.entrySet()) {
            Set<Animal> animalSet = pair.getValue();
            for (Animal animal : animalSet) {
                if (animal instanceof Herbivores) {
                    currentPlantsInCell -= animalCharacteristics.getAmountOfFood();
                }
             position.setQuantityPlantsInCell(currentPlantsInCell);
            }
        }
    }
}
