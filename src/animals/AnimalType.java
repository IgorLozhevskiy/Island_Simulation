package animals;

import java.util.List;

public enum AnimalType {


    // Herbivores
    HORSE,//("Лошадь"),
    DEER,//("Олень"),
    RABBIT,//("Кролик"),
    MOUSE,//("Мышь"),
    GOAT,//("Коза"),
    SHEEP,//("Овца"),
    WILD_BOAR,//("Кабан"),
    BUFFALO,//("Бык"),
    DUCK,//("Утка"),
    //Predators
    FOX,//("Лиса"),
    WOLF,//("Волк"),
    SNAKE,//("Змея"),
    BEAR,//("Медведь"),
    EAGLE;//("Орёл");

//    private String value;

//    AnimalType(String value) {
//        this.value = value;
//    }

    public static List<AnimalType> getHerbivoresTypes() {
        return List.of(HORSE, DEER, RABBIT, MOUSE, GOAT, SHEEP, WILD_BOAR, BUFFALO, DUCK);
    }

    public static List<AnimalType> getPredatorsTypes() {
        return List.of(WOLF, SNAKE, BEAR, EAGLE);
    }


//    public String getValue() {
//        return value;
//    }


}
