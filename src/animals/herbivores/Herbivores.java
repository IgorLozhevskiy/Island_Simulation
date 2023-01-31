package animals.herbivores;

import animals.Animal;
import animals.AnimalCharacteristics;
import animals.AnimalType;
import island.IslandCell;
import island.Island;
import java.util.Random;

public abstract class Herbivores extends Animal {
    private boolean starving; // голодающий
    public Herbivores(Island island, AnimalCharacteristics animalCharacteristics) {
        super(island, animalCharacteristics);
        this.starving = false;
    }


    @Override
    public void eat() {
        System.out.printf("Herbivore %s, %s is looking for grass to eat!\n", getAnimalType(), getId()); // Травоядное ищет траву, чтобы поесть
        IslandCell position = this.getPosition(); // получаем текущую позицию ячейки
        int currentPlantsInCell = position.getQuantityPlantsInCell();
        System.out.println("Изначальное кол-во травы в клетке " + currentPlantsInCell);
        double amountOfFoodNeeded = getAnimalCharacteristics().getAmountOfFood(); // добавила СЕЙЧАС
        if (currentPlantsInCell >= amountOfFoodNeeded) {
//        Map<AnimalType, Set<Animal>> currentAnimalsInCell = position.getAnimalsByTypeInCell();
//            Map<AnimalType, List<Animal>> currentAnimalsInCell = position.getAnimalsByTypeInCell(); // пока не понимаю,
//            это Костя писал или нет?
            currentPlantsInCell = (int) (currentPlantsInCell - amountOfFoodNeeded);
            position.setQuantityPlantsInCell(currentPlantsInCell);
            System.out.printf("Животное %s, %s поело травы и теперь сытое\n", getAnimalType(), getId());
            System.out.println("Теперь в клетке кол-во травы " + currentPlantsInCell);
        } else {
            System.out.printf("В клетке не хватает травы, чтобы насытиться. Животное %s, %s начинает голодать\n",
                    getAnimalType(), getId());
            starving = true;
            currentPlantsInCell = new Random().nextInt(2); // тут рандомом выпадет 0 или 1. Если 0, то клетка непригодна
            // для роста растений, если 1, то трава возродится в методе роста травы
            position.setQuantityPlantsInCell(currentPlantsInCell);
        }
    }

    @Override
    public void starvation() {
        IslandCell position = getPosition();
        if (starving) {
            position.removeAnimalInCell(this);
            System.out.printf("The herbivore %s died of starvation!\n", getAnimalCharacteristics().getName());
        }
    }

//    @Override
//    public void breed() {
//
//    }
}