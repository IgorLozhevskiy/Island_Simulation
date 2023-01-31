package animals.predators;

import animals.Animal;
import animals.AnimalCharacteristics;

import config.AnimalsConfig;
import island.Island;
import island.IslandCell;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Predators extends Animal {
    public Predators(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public void eat() {
        System.out.printf("Animal %s, %s started eat!", getAnimalType(), getId());
        double amountOfFoodNeeded = getAnimalCharacteristics().getAmountOfFood();
        IslandCell position = getPosition();
        List<Animal> herbivoresInCell = position.getGroupAnimalsByType().getOrDefault(true, Collections.emptyList());
        if (herbivoresInCell.isEmpty()) {
            System.out.println("There wasn't a single herbivore left in the Cell");
            return;
        }
        Animal prey = herbivoresInCell.get(new Random().nextInt(herbivoresInCell.size()));
        int probabilityOfEating = AnimalsConfig.getInstance().getProbabilityOfEating(this, prey);
        if (new Random().nextInt(100) <= probabilityOfEating) {
            // prey is eaten by predator
            System.out.println("До того как съели состояние коллекции:" + herbivoresInCell.toString());
            position.removeAnimalInCell(prey);
            System.out.println("После того как съели состояние коллекции:" + herbivoresInCell.toString());
        } else {
            //prey successfully ran away
            System.out.println("Herbivore successfully ran away");
        }
    }

    @Override
    public void starvation() {
        System.out.println("TODO");
    }
}



