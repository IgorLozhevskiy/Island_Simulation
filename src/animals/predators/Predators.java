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
    private boolean starving;

    public Predators(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
        this.starving = false;
    }

    @Override
    public void eat() {
        System.out.printf("The predator %s %s starts hunting for food!\n", getAnimalCharacteristics().getName(),
                getAnimalCharacteristics().getEmoji());
        double amountOfFoodNeeded = getAnimalCharacteristics().getAmountOfFood();
        IslandCell position = getPosition();
        List<Animal> herbivoresInCell = position.getGroupAnimalsByType().getOrDefault(true,
                Collections.emptyList());
        if (herbivoresInCell.isEmpty()) {
            System.out.println("There wasn't a single herbivore left in the Cell");
            starving = true;
            return;
        }
        Animal prey = herbivoresInCell.get(new Random().nextInt(herbivoresInCell.size()));
        double amountOfFoodInPrey = prey.getAnimalCharacteristics().getMaxWeight();
        int probabilityOfEating = AnimalsConfig.getInstance().getProbabilityOfEating(this, prey);
        int randomProbabilityOfEating = new Random().nextInt(100);
        if (randomProbabilityOfEating <= probabilityOfEating) {
            if (amountOfFoodNeeded <= amountOfFoodInPrey) {
                position.removeAnimalInCell(prey);
            } else {
                System.out.println("The weight of the Herbivore is so small, that the Predator doesn't enough food");
                starving = true;
            }
        } else {
            System.out.println("Herbivore successfully ran away, the predator remained hungry");
            starving = true;
        }
    }

    @Override
    public void starvation() {
        IslandCell position = getPosition();
        if (starving) {
            position.removeAnimalInCell(this);
            System.out.printf("The predator %s %s died of starvation! \n", getAnimalCharacteristics().getName(),
                    getAnimalCharacteristics().getEmoji());
        }
    }

    @Override
    public void controlOfCondition() {
        IslandCell position = getPosition();
        List<Animal> predatorsInCell = position.getGroupAnimalsByType().getOrDefault(false,
                Collections.emptyList());
        System.out.printf("Total Predators in Cell = %d \n", predatorsInCell.size());
    }
}