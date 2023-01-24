package Simulation;

import Animals.Animal;
import Animals.AnimalCharacteristics;
import Animals.AnimalType;
import Animals.AnimalsFactory;
import Animals.Herbivores.Herbivores;
import Island.Island;
import Island.IslandCell;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AppRunner {
    private static int MAX_DEFAULT_ANIMAL_COUNT = 10;

    private static int SIMULATION_DURATION = 10;

    public static AtomicInteger movesCount = new AtomicInteger(0);

    private static int MAX_PLANTS_IN_CELL = 200;

        private static List<Animal> allAnimals = new ArrayList<>();
//    private static Map<AnimalType, Set<Animal>> allAnimals = new HashMap<>();
    Island island = new Island(5, 3);

    public void runSimulation() {
        populateInIsland(island);
        System.out.println("Total ANIMALS in Island.Island = " + allAnimals.size());
        System.out.println("Total PLANTS in Island.Island = " + island.toString());

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
        allAnimals.forEach(Animal::move); // 1
        herbivoresNutrition(); //2 травоядные поели траву
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

        Random cellPopulationPicker = new Random();
        int animalCountInCell = cellPopulationPicker.nextInt(MAX_DEFAULT_ANIMAL_COUNT);

        AnimalType animalType[] = AnimalType.values();
        int animalTypeCount = cellPopulationPicker.nextInt(animalType.length);
        AnimalType parseTypeFromEnum = AnimalType.values()[animalTypeCount];
        for (int i = 0; i < animalCountInCell; i++) { //
            Animal animal = animalsFactory.createAnimal(island, parseTypeFromEnum);
            animal.setPosition(islandCell);
            islandCell.addToAnimalsInCell(animal);
            allAnimals.add(animal);
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

    private static void herbivoresNutrition() {
// getAllHerbivoresInSimulation for each Herbivores
    }

    private void getAllHerbivoresInSimulation(IslandCell islandCell) {
        // get all herbivores in simulation
        // return ArrayList all Herbivores
    }

}
