package Simulation;

import animals.Animal;
import animals.AnimalType;
import animals.AnimalsFactory;
import island.Island;
import island.IslandCell;
import config.AnimalsConfig;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Simulation {

    public static AtomicInteger movesCount = new AtomicInteger(0);
    public static List<Animal> allAnimals = new ArrayList<>();
    private static Map<AnimalType, Set<Animal>> animalsByType;
    Island island = new Island(AnimalsConfig.xDimension, AnimalsConfig.yDimension);

    static {
        animalsByType = new HashMap<>();
        for (AnimalType value : AnimalType.values()) {
            animalsByType.put(value, new HashSet<>());
        }
    }

    public void runSimulation() {
        populateInIsland(island);
        System.out.println("Total ANIMALS in Island = " + allAnimals.size());
        System.out.println("Total ANIMALS \"animalsByType\" in Island = " + animalsByType.size());
        System.out.println("Total PLANTS in Island = " + island.toString());
        System.out.println("Total Herbivores in START Simulation:");
        System.out.println(getHerbivoresInSimulation().toString());
        System.out.println("Total Predators in START Simulation:");
        System.out.println(getPredatorsInSimulation().toString());

        int dayCount = 1;

        do {
            System.out.printf("-----------------------------------------------------\n" +
                    "DAY NUMBER %d \n" + "-----------------------------------------------------\n", dayCount);
            startDay();
            dayCount++;
        } while (dayCount < AnimalsConfig.SIMULATION_DURATION);
        System.out.println("Simulation had finished!");
        System.out.println("Total moves done = " + movesCount.toString());
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
            }
        }
    }

//    private static void populateAnimalsInCell(IslandCell islandCell, Island island) {
//        AnimalsFactory animalsFactory = AnimalsFactory.getAnimalsFactoryInstance();
//        Random cellPopulationPicker = new Random();
//        int animalCountInCell = cellPopulationPicker.nextInt(AnimalsConfig.MAX_DEFAULT_ANIMAL_COUNT_IN_CELL);
//        AnimalType[] animalType = AnimalType.values();
//
//        /*
//        1. Для каждого животного из коллекции получить его максимально возможное количество в клетке при создании
//        2. Условие: если тип животного ...., то берём рандом и геттер на его количество в клетке
//        3. всё это в форлупе скорее всего
//        */
//
//        for (int i = 0; i < animalCountInCell; i++) {
//            int animalTypeCount = cellPopulationPicker.nextInt(animalType.length);
//            AnimalType parseTypeFromEnum = AnimalType.values()[animalTypeCount];
//            Animal animal = animalsFactory.createAnimal(island, parseTypeFromEnum);
//            islandCell.addOneAnimalInCell(animal);
//            animal.setPosition(islandCell);
//            allAnimals.add(animal);
//            animalsByType.get(animal.getAnimalType()).add(animal);
//        }
//        System.out.printf("%s populated with %s animals%n", islandCell, animalCountInCell);
//        System.out.print("--------------------------------------------------------------\n");
//    }

        private static void populateAnimalsInCell(IslandCell islandCell, Island island) {
            AnimalsFactory animalsFactory = AnimalsFactory.getAnimalsFactoryInstance();
            AnimalType[] animalType = AnimalType.values();
            Random cellPopulationPicker = new Random();
            for (AnimalType type : animalType) {
                int animalCountInCell = cellPopulationPicker.nextInt(AnimalsConfig.getInstance().getMap().get(type).getMaxNumAnimalsInCell());
//        int animalCountInCell = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);
                for (int i = 0; i < animalCountInCell; i++) {
                    int animalTypeCount = cellPopulationPicker.nextInt(animalType.length);
                    AnimalType parseTypeFromEnum = AnimalType.values()[animalTypeCount];
                    Animal animal = animalsFactory.createAnimal(island, parseTypeFromEnum);
                    islandCell.addOneAnimalInCell(animal);
                    animal.setPosition(islandCell);
                    allAnimals.add(animal);
                    animalsByType.get(animal.getAnimalType()).add(animal);
                }
                System.out.printf("%s populated with %s animals%n", islandCell, animalCountInCell);
                System.out.print("--------------------------------------------------------------\n");
            }
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

