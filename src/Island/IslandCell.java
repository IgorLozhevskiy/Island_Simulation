package Island;

import Animals.Animal;
import Animals.AnimalType;

import java.util.*;

public class IslandCell {
    private String plantsEmoji = "\uD83C\uDF40";
    int x;
    int y;
    private int quantityPlantsInCell;
    Map<AnimalType, Set<Animal>> animalList;
    private Plants plant;

    public IslandCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.animalList = new HashMap<>();
        this.plant = new Plants(quantityPlantsInCell);
    }

//    public void addAnimal(Animal animal) { // добавляем животное
//
//        animalList.put(AnimalType, animal);
//    }
public boolean addToAnimalsInCell(Animal animal) {
    AnimalType animalType = animal.getAnimalType();
    int currentPopulation = animalList.computeIfAbsent(animalType, (k) -> new HashSet<>()).size();
    int maxAmountInCell = 10;
    if (currentPopulation > maxAmountInCell) {
        System.out.printf("Animals in Cell %s is overpopulated with %s", this, animalType);
        return false;
    }
    return animalList.get(animalType).add(animal);
}


    public void removeAnimal(Animal animal) { // удаляем животное

        animalList.remove(animal);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getQuantityPlantsInCell() {
        return quantityPlantsInCell;
    }

    public void setQuantityPlantsInCell(int quantityPlantsInCell) {
        this.quantityPlantsInCell = quantityPlantsInCell;
    }


    @Override
    public String toString() {
        return "Cell x=" + x + ", y=" + y + ". " + "Island.Plants in Cell " + quantityPlantsInCell + plantsEmoji + ", ";
    }

}