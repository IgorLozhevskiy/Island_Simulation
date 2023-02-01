package simulation;

import animals.Animal;
import animals.AnimalType;
import animals.AnimalsFactory;
import config.AnimalsConfig;
import island.Island;
import island.IslandCell;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Simulation {
    public static AtomicInteger movesCount = new AtomicInteger(0);
    private static List<Animal> allAnimals = new ArrayList<>();
    private static Map<AnimalType, Set<Animal>> animalsByType;

    Island island = new Island(AnimalsConfig.xDimension, AnimalsConfig.yDimension);
    public static int totalAnimal = 0;

    static {
        animalsByType = new HashMap<>();
        for (AnimalType value : AnimalType.values()) {
            animalsByType.put(value, new HashSet<>());
        }
    }

    public void runSimulation() {
        populateInIsland(island);
        System.out.println("Total ANIMALS in Island = " + totalAnimal);
        System.out.println("Total animals by type in Island = " + animalsByType.size());
        System.out.println("Total PLANTS in Island = " + island.toString());
        System.out.println(getHerbivoresInSimulation().toString());
        System.out.println(getPredatorsInSimulation().toString());

        int dayCount = 1;
        do {
            System.out.printf("-----------------------------------------------------\n" +
                    "DAY NUMBER %d \n" + "-----------------------------------------------------\n", dayCount);
            startDay();
            System.out.println("Total PLANTS in Island = " + island.toString());
            dayCount++;
        } while (dayCount < AnimalsConfig.SIMULATION_DURATION);

        System.out.println("Simulation had finished!");
        System.out.println("Total moves done = " + movesCount.toString());
        System.out.println("Total animals survived in finished of simulation = " + allAnimals.size());
    }

    private void startDay() {
        allAnimals.forEach(Animal::liveDay);
        island.getAllCells().forEach(islandCell -> islandCell.growthRestorationOfPlantsInCell());
    }

    private static void populateInIsland(Island island) {
        for (int i = 0; i < island.xDimension; i++) {
            for (int j = 0; j < island.yDimension; j++) {
                initPlantsInCell(island.islandGrid[i][j]);
                populateAnimalsInCell(island.islandGrid[i][j], island);
                totalAnimal += allAnimals.size();
            }
        }
    }


    private static void populateAnimalsInCell(IslandCell islandCell, Island island) {
        AnimalsFactory animalsFactory = AnimalsFactory.getAnimalsFactoryInstance();
        Random cellPopulationPicker = new Random();
        AnimalType[] animalType = AnimalType.values();

        for (AnimalType type : animalType) {
            int animalCountInCellByType = cellPopulationPicker.nextInt(AnimalsConfig.getInstance().
                    getMap().get(type).getMaxNumAnimalsInCell());
            for (int i = 0; i < animalCountInCellByType; i++) {
                Animal animal = animalsFactory.createAnimal(island, type);
                islandCell.addOneAnimalInCell(animal);
                animal.setPosition(islandCell);
                allAnimals.add(animal);
                animalsByType.get(animal.getAnimalType()).add(animal);
            }
        }
        System.out.printf("%s populated with %s animals%n", islandCell, allAnimals.size());
        System.out.print("--------------------------------------------------------------\n");
    }


    private static void initPlantsInCell(IslandCell islandCell) {
        Random plantsRandomizer = new Random();
        islandCell.setQuantityPlantsInCell(plantsRandomizer.nextInt(AnimalsConfig.MAX_PLANTS_IN_CELL));
    }


    private static Set<Animal> getHerbivoresInSimulation() {
        return animalsByType.entrySet().stream()
                .filter(it -> AnimalType.getHerbivoresTypes().contains(it.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    private static Set<Animal> getPredatorsInSimulation() {
        return animalsByType.entrySet().stream()
                .filter(it -> AnimalType.getPredatorsTypes().contains(it.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }
}