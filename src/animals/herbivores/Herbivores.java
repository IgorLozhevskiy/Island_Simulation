package animals.herbivores;

import animals.Animal;
import animals.AnimalCharacteristics;
import island.IslandCell;
import island.Island;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Herbivores extends Animal {
    private boolean starving;

    public Herbivores(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
        this.starving = false;
    }

    @Override
    public void eat() {
        System.out.printf("Herbivore %s %s is looking for grass to eat!\n", getAnimalCharacteristics().getName(),
                getAnimalCharacteristics().getEmoji());
        IslandCell position = this.getPosition();
        int currentPlantsInCell = position.getQuantityPlantsInCell();
        double amountOfFoodNeeded = getAnimalCharacteristics().getAmountOfFood();
        if (currentPlantsInCell >= amountOfFoodNeeded) {
            currentPlantsInCell = (int) (currentPlantsInCell - amountOfFoodNeeded);
            position.setQuantityPlantsInCell(currentPlantsInCell);
            System.out.printf("The Herbivore has eaten %s %s \n", getAnimalCharacteristics().getName(),
                    getAnimalCharacteristics().getEmoji());
            System.out.println("After this the Plants in Cell remained " + currentPlantsInCell);
        } else {
            System.out.printf("In this Cell not enough the Plants and The Herbivore %s %s starting to starvation\n",
                    getAnimalCharacteristics().getName(), getAnimalCharacteristics().getEmoji());
            starving = true;
            currentPlantsInCell = new Random().nextInt(2);
            position.setQuantityPlantsInCell(currentPlantsInCell);
        }
    }

    @Override
    public void starvation() {
        IslandCell position = getPosition();
        if (starving) {
                position.removeAnimalInCell(this);
                System.out.printf("The herbivore %s %s died of starvation!\n",
                        getAnimalCharacteristics().getName(), getAnimalCharacteristics().getEmoji());
            }
    }

    @Override
    public void controlOfCondition() {
        IslandCell position = getPosition();
        List<Animal> herbivoresInCell = position.getGroupAnimalsByType().getOrDefault(true,
                Collections.emptyList());
        System.out.printf("Total Herbivores in Cell = %d \n", herbivoresInCell.size());
    }
}