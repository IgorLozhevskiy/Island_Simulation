package Simulation;

import Animals.Animal;

import Animals.AnimalType;
import Animals.AnimalsFactory;

import Island.Island;
import Island.IslandCell;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AppRunner {
    private static int MAX_DEFAULT_ANIMAL_COUNT = 10;

    private static int SIMULATION_DURATION = 10;

    public static AtomicInteger movesCount = new AtomicInteger(0);

    private static int MAX_PLANTS_IN_CELL = 200;

    private static List<Animal> allAnimals = new ArrayList<>();
    private static Map<AnimalType, Set<Animal>> animalsByType;
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
        System.out.println("Total ANIMALS \"mapAllAnimals\" in Island = " + animalsByType.size());
        System.out.println("Total PLANTS in Island = " + island.toString());

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

    private static void startDay() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        allAnimals.forEach(Animal::move); // 1
        Set<Animal> allAnimals = animalsByType.values().stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
       allAnimals.forEach(Animal::liveDay);
        //printStats
//        herbivoresNutrition(); //2 травоядные поели траву
        //3 хищники поели травоядных
        //4 рост травы, фактор х1.5 growthRestorationOfPlants()
        // 5 чем закончится симуляция? Симуляция заканчивается логированием, в котором будет написано на каком ходу все хищники съели всех травоядных
        // счётчик дней рандомным числом до 15 дней? И посмотреть в какой срок останутся на острове только хищники
    }

    private static void populateInIsland(Island island) {// популяция животных и растений на всём острове
        for (int i = 0; i < island.xDimension; i++) {
            for (int j = 0; j < island.yDimension; j++) {
                initPlantsInCell(island.islandGrid[i][j]);
                populateAnimalsAndPlantsInCell(island.islandGrid[i][j], island);
            }
        }
    }

    private static void populateAnimalsAndPlantsInCell(IslandCell islandCell, Island island) {
        AnimalsFactory animalsFactory = AnimalsFactory.getAnimalsFactoryInstance();
        Set<Animal> setAnimalList;

        Random cellPopulationPicker = new Random();
        int animalCountInCell = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);
        AnimalType[] animalType = AnimalType.values(); //достали все значения и сложили их в массив объектов энама

        for (int i = 0; i < animalCountInCell; i++) { //
            int animalTypeCount = cellPopulationPicker.nextInt(animalType.length); // рандом до длины нашего массива, т.е. 2х
            AnimalType parseTypeFromEnum = AnimalType.values()[animalTypeCount]; // парсинг рандомной инты снова в объект энама
            Animal animal = animalsFactory.createAnimal(island, parseTypeFromEnum);
            animal.setPosition(islandCell);
            islandCell.addToAnimalsInCell(animal);
            allAnimals.add(animal);
            animalsByType.get(animal.getAnimalType()).add(animal);
//            AnimalType animalTypeForMap = animal.getAnimalType();
//            mapAllAnimals.put(animalTypeForMap, animal); // ??:(
//
//          for (animal: animal.getPosition()) {
//              setAnimalList.computeIfAbsent(animal, (k) -> new HashSet<>()).size();
//          }
//            Set<Animal> allAnimals = map.values().stream()
//                    .flatMap(Set::stream)
//                    .collect(toSet());
////            allAnimals.add(animal);
//            mapAllAnimals.put(parseTypeFromEnum, (Set<Animal>) animal);

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

    private static void growthRestorationOfPlantsInCell(IslandCell islandCell) {
        int growFactor = 1;
        if (islandCell.getQuantityPlantsInCell() == 1) {
            islandCell.setQuantityPlantsInCell(growFactor * islandCell.getQuantityPlantsInCell());
            System.out.println("");
        }
    }
//private static void getNutritionForHerbivores () {
//    Map<AnimalType, Set<Animal>> mapAllAnimals;
//    Set<Animal> mapAllAnimals = map.values().stream()
//            .flatMap(Set::stream)
//            .collect(toSet());
//}

}

