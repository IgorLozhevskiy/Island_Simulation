package Animals;

import Animals.Predators.Predators;
import Animals.Predators.Wolf;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public enum AnimalType {
    // Herbivores
    HORSE,
//DEER,
//RABBIT,

//        MOUSE,
//    GOAT,
//    SHEEP,
//    WILD_BOAR,
//    BUFFALO,
//    DUCK;

    //     Predators
//    FOX,
    WOLF;
    //    SNAKE,
//
//    BEAR,
//    EAGLE,


    public static List<AnimalType> getHerbivorusTypes() {
        return List.of(HORSE);
    }

    public static List<AnimalType> getPredatorsTypes() {
        return List.of(WOLF);
    }

}
