package animals.herbivores;

import animals.Animal;
import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.IslandCell;
import island.Island;

import java.util.List;
import java.util.Map;

public abstract class Herbivores extends Animal {
    public Herbivores(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }


    @Override
    public void eat() {
        IslandCell position = this.getPosition();
        int currentPlantsInCell = position.getQuantityPlantsInCell();
//        Map<AnimalType, Set<Animal>> currentAnimalsInCell = position.getAnimalsByTypeInCell();
        Map<AnimalType, List<Animal>> currentAnimalsInCell = position.getAnimalsByTypeInCell();
//
//        for (Map.Entry<AnimalType, Set<Animal>> pair : currentAnimalsInCell.entrySet()) {
//            Set<Animal> animalSet = pair.getValue();
//            for (Animal animal : animalSet) {
//                if (animal instanceof Herbivores) {
        currentPlantsInCell -= getAnimalCharacteristics().getAmountOfFood();
//                }
        position.setQuantityPlantsInCell(currentPlantsInCell);
    }
}

