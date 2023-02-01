package config;

import animals.Animal;
import animals.AnimalCharacteristics;
import animals.AnimalType;

import java.util.HashMap;
import java.util.Map;

public class AnimalsConfig {
    public static String plantsEmoji = "\uD83C\uDF40";

    public static int SIMULATION_DURATION = 10;
    public static int MAX_PLANTS_IN_CELL = 200;

    public static final int GROW_FACTOR = 50;

    public static final int xDimension = 15;

    public static final int yDimension = 5;

    private Map<AnimalType, AnimalCharacteristics> specifications = new HashMap<>();
    private int[][] probabilityOfEating = new int[AnimalType.values().length][AnimalType.values().length];
    private static final AnimalsConfig ANIMALS_CONFIG_INSTANCE = new AnimalsConfig();

    private AnimalsConfig() {
        initializeAnimalCharacteristics();
    }


    public void initializeAnimalCharacteristics() {

        specifications.put(AnimalType.WOLF, new AnimalCharacteristics("Wolf", "\uD83D\uDC3A", 50,
                10, 3, 8));
        specifications.put(AnimalType.SNAKE, new AnimalCharacteristics("Snake", "\uD83D\uDC0D", 15,
                10, 1, 3));
        specifications.put(AnimalType.FOX, new AnimalCharacteristics("Fox", "\uD83E\uDD8A", 8,
                10, 2, 2));
        specifications.put(AnimalType.BEAR, new AnimalCharacteristics("Bear", "\uD83D\uDC3B", 500,
                5, 2, 80));
        specifications.put(AnimalType.EAGLE, new AnimalCharacteristics("Eagle", "\uD83E\uDD85", 6,
                10, 3, 1));
        specifications.put(AnimalType.HORSE, new AnimalCharacteristics("Horse", "\uD83D\uDC0E", 400,
                5, 4, 60));
        specifications.put(AnimalType.DEER, new AnimalCharacteristics("Deer", "\uD83E\uDD8C", 300,
                5, 4, 50));
        specifications.put(AnimalType.RABBIT, new AnimalCharacteristics("Rabbit", "\uD83D\uDC07", 2,
                10, 2, 0.5));
        specifications.put(AnimalType.MOUSE, new AnimalCharacteristics("Mouse", "\uD83D\uDC01",
                0.05, 10, 1, 0.01));
        specifications.put(AnimalType.GOAT, new AnimalCharacteristics("Goat", "\uD83D\uDC10",
                60, 5, 3, 10));
        specifications.put(AnimalType.SHEEP, new AnimalCharacteristics("Sheep", "\uD83D\uDC11",
                70, 5, 3, 15));
        specifications.put(AnimalType.WILD_BOAR, new AnimalCharacteristics("WildBoar", "\uD83D\uDC17",
                400, 5, 2, 50));
        specifications.put(AnimalType.BUFFALO, new AnimalCharacteristics("Buffalo", "\uD83D\uDC03",
                700, 5, 3, 100));
        specifications.put(AnimalType.DUCK, new AnimalCharacteristics("Duck", "\uD83E\uDD86",
                1, 10, 4, 0.15));

        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.HORSE.ordinal()] = 10;
        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.DEER.ordinal()] = 15;
        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.RABBIT.ordinal()] = 60;
        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.MOUSE.ordinal()] = 80;
        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.GOAT.ordinal()] = 60;
        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.SHEEP.ordinal()] = 70;
        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.WILD_BOAR.ordinal()] = 15;
        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.BUFFALO.ordinal()] = 10;
        probabilityOfEating[AnimalType.WOLF.ordinal()][AnimalType.DUCK.ordinal()] = 40;

        probabilityOfEating[AnimalType.SNAKE.ordinal()][AnimalType.FOX.ordinal()] = 15;
        probabilityOfEating[AnimalType.SNAKE.ordinal()][AnimalType.RABBIT.ordinal()] = 20;
        probabilityOfEating[AnimalType.SNAKE.ordinal()][AnimalType.MOUSE.ordinal()] = 40;
        probabilityOfEating[AnimalType.SNAKE.ordinal()][AnimalType.DUCK.ordinal()] = 10;

        probabilityOfEating[AnimalType.FOX.ordinal()][AnimalType.RABBIT.ordinal()] = 70;
        probabilityOfEating[AnimalType.FOX.ordinal()][AnimalType.MOUSE.ordinal()] = 90;
        probabilityOfEating[AnimalType.FOX.ordinal()][AnimalType.DUCK.ordinal()] = 60;

        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.SNAKE.ordinal()] = 80;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.HORSE.ordinal()] = 40;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.DEER.ordinal()] = 80;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.RABBIT.ordinal()] = 80;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.MOUSE.ordinal()] = 90;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.GOAT.ordinal()] = 70;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.SHEEP.ordinal()] = 70;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.WILD_BOAR.ordinal()] = 50;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.BUFFALO.ordinal()] = 20;
        probabilityOfEating[AnimalType.BEAR.ordinal()][AnimalType.DUCK.ordinal()] = 10;

        probabilityOfEating[AnimalType.EAGLE.ordinal()][AnimalType.FOX.ordinal()] = 10;
        probabilityOfEating[AnimalType.EAGLE.ordinal()][AnimalType.RABBIT.ordinal()] = 90;
        probabilityOfEating[AnimalType.EAGLE.ordinal()][AnimalType.MOUSE.ordinal()] = 90;
        probabilityOfEating[AnimalType.EAGLE.ordinal()][AnimalType.DUCK.ordinal()] = 80;
    }

    public static AnimalsConfig getInstance() {
        return ANIMALS_CONFIG_INSTANCE;
    }

    public Map<AnimalType, AnimalCharacteristics> getMap() {
        return ANIMALS_CONFIG_INSTANCE.specifications;
    }

    public int[][] getProbabilities() {
        return probabilityOfEating;
    }


    public int getProbabilityOfEating(Animal hunter, Animal prey) {
        return probabilityOfEating[hunter.getAnimalType().ordinal()][prey.getAnimalType().ordinal()];
    }
}