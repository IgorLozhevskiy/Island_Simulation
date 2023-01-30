package Simulation;

import animals.Animal;

import animals.AnimalCharacteristics;
import animals.AnimalType;
import animals.AnimalsFactory;

import animals.herbivores.Herbivores;
import animals.predators.Wolf;
import island.Island;
import island.IslandCell;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InitSimulation {


    private static AnimalCharacteristics animalCharacteristics;
    private static int MAX_DEFAULT_ANIMAL_COUNT = 10;

    private static int SIMULATION_DURATION = 10;

    public static AtomicInteger movesCount = new AtomicInteger(0);

    private static int MAX_PLANTS_IN_CELL = 200;

    private static List<Animal> allAnimals = new ArrayList<>();
    private static Map<AnimalType, Set<Animal>> animalsByType;
    //    private static Map<AnimalType, List<Animal>> animalsByType;
    Island island = new Island(5, 3);

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
        System.out.println("Total Herbivores in Simulation:");
        System.out.println(getHerbivoresInSimulation().toString());
        System.out.println("Total Predators in Simulation:");
        System.out.println(getPredatorsInSimulation().toString());


        int dayCount = 0;
        do {
            System.out.printf("-----------------------------------------------------\n" +
                    "DAY NUMBER %d \n" + "-----------------------------------------------------\n", dayCount);
            startDay();
            dayCount++;
        } while (dayCount < SIMULATION_DURATION);

        System.out.println("Simulation had finished!");
        System.out.println("Total moves done = " + movesCount.toString());


    }

    private void startDay() {
//        ExecutorService executorService = Executors.newCachedThreadPool();
// liveDay();
//        allAnimals.forEach(Animal::move); // 1
//        island.getAllCells().forEach(IslandCell::growthRestorationOfPlantsInCell);

    }

    private static void populateInIsland(Island island) {
        for (int i = 0; i < island.xDimension; i++) {
            for (int j = 0; j < island.yDimension; j++) {
                initPlantsInCell(island.islandGrid[i][j]);
                populateAnimalsAndPlantsInCell(island.islandGrid[i][j], island);
            }
        }
    }

    private static void populateAnimalsAndPlantsInCell(IslandCell islandCell, Island island) {
        AnimalsFactory animalsFactory = AnimalsFactory.getAnimalsFactoryInstance();
        Random cellPopulationPicker = new Random();
        int animalCountInCell = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT); // рандомное кол-во от 0 до 10 сколько в одной клетке будет животных
//        int animalCountInCell = cellPopulationPicker.nextInt(animalCharacteristics.getMaxNumAnimalsInCell()); // рандомное кол-во от 0 до 10
        AnimalType[] animalType = AnimalType.values(); //достали все значения и сложили их в массив объектов энама// 14

        for (int i = 0; i < animalCountInCell; i++) { // от 1 цикла до 10 как решит рандом
            int animalTypeCount = cellPopulationPicker.nextInt(animalType.length); // рандомное число - соответственно либо:1 или 14
            AnimalType parseTypeFromEnum = AnimalType.values()[animalTypeCount]; // преобразовываем рандомное число, которое будет соответствовать конкретному животному энама
            Animal animal = animalsFactory.createAnimal(island, parseTypeFromEnum); // создаём конкретное животное по типу
            islandCell.addOneAnimalInCell(animal);
            animal.setPosition(islandCell);
            allAnimals.add(animal);
            animalsByType.get(animal.getAnimalType()).add(animal);

        }

        System.out.printf("%s populated with %s animals%n", islandCell, animalCountInCell);
        System.out.print("--------------------------------------------------------------\n");
    }


    private static void initPlantsInCell(IslandCell islandCell) {
        int currentPlantsInCell = 0;
        Random plantsRandomizer = new Random();
        islandCell.setQuantityPlantsInCell(plantsRandomizer.nextInt(MAX_PLANTS_IN_CELL));
        currentPlantsInCell = islandCell.getQuantityPlantsInCell();
    }

    private static Set<Animal> getHerbivoresInSimulation() {
        return animalsByType.entrySet().stream()
                .filter(it -> AnimalType.getHerbivoresTypes().contains(it.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }    private static Set<Animal> getPredatorsInSimulation() {
        return animalsByType.entrySet().stream()
                .filter(it -> AnimalType.getPredatorsTypes().contains(it.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }


}

