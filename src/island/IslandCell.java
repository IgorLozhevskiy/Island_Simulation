package island;

import animals.Animal;
import animals.AnimalType;

import java.util.*;

public class IslandCell {
    private String plantsEmoji = "\uD83C\uDF40";
    int x;
    int y;
    private int quantityPlantsInCell;
    //    Map<AnimalType, Set<Animal>> animalsByTypeInCell;
    private Map<AnimalType, List<Animal>> animalsByTypeInCell;
    private Map<Boolean, List<Animal>> groupAnimalsByType = new HashMap<>();
    private Plants plant;

    public IslandCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.animalsByTypeInCell = new HashMap<>();
        this.plant = new Plants(quantityPlantsInCell);
    }

    public boolean addOneAnimalInCell(Animal animal) {

//        int currentPopulation = animalsByTypeInCell.computeIfAbsent(animalType, (k) -> new ArrayList<>()).size();
        Boolean herbivore = isHerbivore(animal);
        int currentPopulation = groupAnimalsByType.computeIfAbsent(herbivore, (k) -> new ArrayList<>()).size();
        int maxAmountInCell = 10;
        if (currentPopulation > maxAmountInCell) {
            System.out.printf("Animals in Cell %s is overpopulated with %s \n", this, animal);
            return false;
        }
        return groupAnimalsByType.get(herbivore).add(animal);
    }

    public boolean removeAnimalInCell(Animal animal) {
        if (AnimalType.getHerbivoresTypes().contains(animal.getAnimalType())) {
            return groupAnimalsByType.get(true).remove(animal);
        } else {
            return groupAnimalsByType.get(false).remove(animal);
        }
    }

    public Boolean isHerbivore(Animal animal) {
        return AnimalType.getHerbivoresTypes().contains(animal.getAnimalType());
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

    public Map<Boolean, List<Animal>> getGroupAnimalsByType() {
        return groupAnimalsByType;
    }

    public void growthRestorationOfPlantsInCell() {
        int growFactor = 200;
        if (this.getQuantityPlantsInCell() == 1) {
            this.setQuantityPlantsInCell(growFactor * this.getQuantityPlantsInCell());
            System.out.println("Cell x=" + x + ", y=" + y + ". Plants were growth in Cell again: " + getQuantityPlantsInCell());
        }
    }

    @Override
    public String toString() {
        return "Cell x=" + x + ", y=" + y + ". " + "Plants in Cell " + quantityPlantsInCell + plantsEmoji;
    }

}