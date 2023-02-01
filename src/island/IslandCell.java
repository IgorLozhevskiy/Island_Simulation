package island;

import animals.Animal;
import animals.AnimalType;
import config.AnimalsConfig;

import java.util.*;

public class IslandCell {
    int x;
    int y;
    private int quantityPlantsInCell;
    private Map<AnimalType, List<Animal>> animalsByTypeInCell;
    private Map<Boolean, List<Animal>> groupAnimalsByType;
    private Plants plant;

    public IslandCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.animalsByTypeInCell = new HashMap<>();
        this.groupAnimalsByType = new HashMap<>();
        this.plant = new Plants(quantityPlantsInCell);
    }

    public boolean addOneAnimalInCell(Animal animal) {
        Boolean herbivore = isHerbivore(animal);
        int currentPopulation = groupAnimalsByType.computeIfAbsent(herbivore, (k) -> new ArrayList<>()).size();
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
        Random randomGrowthFactor = new Random();
        if (this.getQuantityPlantsInCell() == 1) {
            this.setQuantityPlantsInCell(randomGrowthFactor.nextInt(AnimalsConfig.GROW_FACTOR) *
                    this.getQuantityPlantsInCell());
            System.out.println("Cell x=" + x + ", y=" + y + ". Plants were growth in Cell again: " +
                    getQuantityPlantsInCell());
        }
    }

    @Override
    public String toString() {
        return "Cell x=" + x + ", y=" + y + ". " + "Plants in Cell " + quantityPlantsInCell + AnimalsConfig.plantsEmoji;
    }

}