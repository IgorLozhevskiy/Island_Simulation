package animals.predators;

import animals.Animal;
import animals.AnimalCharacteristics;
import animals.AnimalType;
import animals.herbivores.Herbivores;
import config.AnimalsConfig;
import island.Island;
import island.IslandCell;

import java.util.List;
import java.util.Random;

public abstract class Predators extends Animal {
    public Predators(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
    }

    @Override
    public void eat() {
        double amountOfFoodNeeded = getAnimalCharacteristics().getAmountOfFood();
        IslandCell position = getPosition();
        List<Animal> herbivoresInCell = position.getGroupAnimalsByType().get(true);
        Animal prey = herbivoresInCell.get(new Random().nextInt(herbivoresInCell.size()));
        int probabilityOfEating = AnimalsConfig.getInstance().getProbabilityOfEating(this, prey);
        if (new Random().nextInt(100) <= probabilityOfEating) {
            // prey is eaten by predator
            position.removeAnimalInCell(this);
        } else {
            //prey successfully ran away
            System.out.println("Herbivore successfully ran away");
        }
    }
}

