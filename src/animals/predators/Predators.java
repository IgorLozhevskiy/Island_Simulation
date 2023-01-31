package animals.predators;

import animals.Animal;
import animals.AnimalCharacteristics;

import animals.Eatable;
import config.AnimalsConfig;
import island.Island;
import island.IslandCell;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Predators extends Animal {
    Island island;
    private boolean starving; // голодающий

    public Predators(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
        this.starving = false;
    }

    @Override
    public void eat() {
        System.out.printf("The predator %s, %s starts hunting for food!\n", getAnimalType(), getId());
        double amountOfFoodNeeded = getAnimalCharacteristics().getAmountOfFood();
        IslandCell position = getPosition();
        List<Animal> herbivoresInCell = position.getGroupAnimalsByType().getOrDefault(true, Collections.emptyList());
//        System.out.println(herbivoresInCell.isEmpty());
        if (herbivoresInCell.isEmpty()) {
            System.out.println("There wasn't a single herbivore left in the Cell"); // В клетке не осталось ни одного травоядного животного
            starving = true; // тут указываем, что животное не поело и должно умереть от голода
//            starvation(); // по логике вызываем метод, чтобы животное умерло?
            return;
        }
        Animal prey = herbivoresInCell.get(new Random().nextInt(herbivoresInCell.size()));
        double amountOfFoodInPrey = prey.getAnimalCharacteristics().getMaxWeight();
        int probabilityOfEating = AnimalsConfig.getInstance().getProbabilityOfEating(this, prey);
        int randomProbabilityOfEating = new Random().nextInt(100);
        if (randomProbabilityOfEating <= probabilityOfEating) {
            if (amountOfFoodNeeded <= amountOfFoodInPrey) {
                // prey is eaten by predator
                System.out.println("До того как съели состояние коллекции:" + herbivoresInCell.toString());
                position.removeAnimalInCell(prey);
                System.out.println("После того как съели состояние коллекции:" + herbivoresInCell.toString());
            } else {
                System.out.println("The weight of the herbivore is too small for the predator to get enough"); //вес
                // травядного слишком мал, чтобы хищник насытился
                starving = true; // делаем флаг, что животное голодает
            }
        } else {
            //травоядное убежало, хищник остался голодным
            System.out.println("Herbivore successfully ran away, the predator remained hungry");
            starving = true; // делаем флаг, что животное голодает
        }
    }

    @Override
    public void starvation() {
        IslandCell position = getPosition();
        if (starving) {
            position.removeAnimalInCell(this);
            System.out.printf("The predator %s died of starvation! \n", getAnimalCharacteristics().getName());
        }
    }

//    @Override
//    public void breed() {
//        IslandCell position = getPosition();
//        List<Animal> predatorsInCell = position.getGroupAnimalsByType().getOrDefault(false, Collections.emptyList());
//        System.out.println("В коллекци лежат следующие хищники:" + predatorsInCell.toString());
//        if (predatorsInCell.isEmpty()) {
//            System.out.println("There wasn't a single predator left in the Cell");
//            return;
//        }
//        AnimalType animalType = this.getAnimalType();
//        if (animalType.equals(predatorsInCell.contains(animalType))) {
//            int numberOfChildren = 1;
//            for (int i = 0; i < numberOfChildren; i++) {
//                Animal animal = AnimalsFactory.getAnimalsFactoryInstance().createAnimal(island, animalType);
//                position.addOneAnimalInCell(animal);
//                System.out.printf("В клетку добавилось животное по итогу размножения %s, %s", getAnimalType(), getId());
//            }
//
//        }
//    }
}