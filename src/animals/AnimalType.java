package animals;

import java.util.List;

public enum AnimalType {
    HORSE,
    DEER,
    RABBIT,
    MOUSE,
    GOAT,
    SHEEP,
    WILD_BOAR,
    BUFFALO,
    DUCK,

    FOX,
    WOLF,
    SNAKE,
    BEAR,
    EAGLE;


    public static List<AnimalType> getHerbivoresTypes() {
        return List.of(HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, WILD_BOAR, BUFFALO, DUCK);
    }

    public static List<AnimalType> getPredatorsTypes() {
        return List.of(WOLF, SNAKE, BEAR, EAGLE);
    }
}
