package Island;

import Animals.Animal;
import Animals.AnimalType;

import java.util.*;

public class IslandCell {
    private String plantsEmoji = "\uD83C\uDF40";
    int x;
    int y;
    private int quantityPlantsInCell;
    //    Map<AnimalType, Set<Animal>> animalsByTypeInCell;
    Map<AnimalType, List<Animal>> animalsByTypeInCell;
    private Plants plant;

    public IslandCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.animalsByTypeInCell = new HashMap<>();
        this.plant = new Plants(quantityPlantsInCell);
    }

    public boolean addOneAnimalInCell(Animal animal) {
        AnimalType animalType = animal.getAnimalType();
//        int currentPopulation = animalsByTypeInCell.computeIfAbsent(animalType, (k) -> new HashSet<>()).size();
        int currentPopulation = animalsByTypeInCell.computeIfAbsent(animalType, (k) -> new ArrayList<>()).size();
//        int maxAmountInCell = 10;
//        if (currentPopulation > maxAmountInCell) {
//            System.out.printf("Animals in Cell %s is overpopulated with %s \n", this, animalType);
//            return false;
//        }
        return animalsByTypeInCell.get(animalType).add(animal);
    }

    public boolean removeAnimal(Animal animal) {
        return animalsByTypeInCell.get(animal.getAnimalType()).remove(animal);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    public Map<AnimalType, Set<Animal>> getAnimalsByTypeInCell() {
//        return animalsByTypeInCell;
//    }
        public Map<AnimalType, List<Animal>> getAnimalsByTypeInCell() {
        return animalsByTypeInCell;
    }

    public int getQuantityPlantsInCell() {
        return quantityPlantsInCell;
    }

    public void setQuantityPlantsInCell(int quantityPlantsInCell) {
        this.quantityPlantsInCell = quantityPlantsInCell;
    }


    @Override
    public String toString() {
        return "Cell x=" + x + ", y=" + y + ". " + "Plants in Cell " + quantityPlantsInCell + plantsEmoji + ", ";
    }

}