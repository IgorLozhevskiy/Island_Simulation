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


//    @Override
//    public void eat() {
//        IslandCell position = this.getPosition();
//        int currentPlantsInCell = position.getQuantityPlantsInCell();
////        Map<AnimalType, Set<Animal>> currentAnimalsInCell = position.getAnimalsByTypeInCell();
//        Map<AnimalType, List<Animal>> currentAnimalsInCell = position.getAnimalsByTypeInCell();
////
////        for (Map.Entry<AnimalType, Set<Animal>> pair : currentAnimalsInCell.entrySet()) {
////            Set<Animal> animalSet = pair.getValue();
////            for (Animal animal : animalSet) {
////                if (animal instanceof Herbivores) {
//        currentPlantsInCell -= getAnimalCharacteristics().getAmountOfFood();
////                }
//        position.setQuantityPlantsInCell(currentPlantsInCell);
//    }

    @Override
    public void eat() {
        IslandCell position = this.getPosition(); // получаем текущую позицию ячейки
        int currentPlantsInCell = position.getQuantityPlantsInCell();
        System.out.println("Изначальное кол-во травы в клетке " + currentPlantsInCell);
        double amountOfFoodNeeded = getAnimalCharacteristics().getAmountOfFood(); // добавила СЕЙЧАС
        if (currentPlantsInCell >= amountOfFoodNeeded) {
//        Map<AnimalType, Set<Animal>> currentAnimalsInCell = position.getAnimalsByTypeInCell();
            Map<AnimalType, List<Animal>> currentAnimalsInCell = position.getAnimalsByTypeInCell();
            currentPlantsInCell = (int) (currentPlantsInCell - amountOfFoodNeeded);
            position.setQuantityPlantsInCell(currentPlantsInCell);
            System.out.printf("Животное %s, %s поело травы и теперь сытое\n", getAnimalType(), getId());
            System.out.println("Теперь в клетке кол-во травы " + currentPlantsInCell);
        } else {
            currentPlantsInCell = 1; // т.е. животное съело абсолютно все и по идее, в этой клетке рост растений больше невозможен
            position.setQuantityPlantsInCell(currentPlantsInCell);
            System.out.printf("Животное %s, %s начинает голодать\n", getAnimalType(), getId());
        }
    }
}

