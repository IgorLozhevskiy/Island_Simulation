import Animals.AnimalCharacteristics;
import Animals.AnimalType;

import java.util.HashMap;
import java.util.Map;

public class AnimalsConfig { //Как завещал Кришна и Рама и Смехопанорама вместо Сериализации долбить всё в одном классе
    // Are You welcome in India
    private Map<AnimalType, AnimalCharacteristics> specifications = new HashMap<>();

    private int[][] probabilityOfEating = new int[AnimalType.values().length][AnimalType.values().length];

    public void initialize() {
        //Заполняем характеристики животных
        specifications.put(AnimalType.WOLF, new AnimalCharacteristics("Волк", " \uD83D\uDC3A", 50, 30, 3,  8));
        specifications.put(AnimalType.SNAKE, new AnimalCharacteristics("Змея", " \uD83D\uDC0D", 15, 30, 1, 3));
        specifications.put(AnimalType.FOX, new AnimalCharacteristics("Лиса", " \uD83E\uDD8A", 8, 30, 2, 2));
        specifications.put(AnimalType.BEAR, new AnimalCharacteristics("Медведь", " \uD83D\uDC3B", 500, 5, 2, 80));
        specifications.put(AnimalType.EAGLE, new AnimalCharacteristics("Орел", " \uD83E\uDD85", 6, 20, 3, 1));
        specifications.put(AnimalType.HORSE, new AnimalCharacteristics("Лошадь", " \uD83D\uDC0E", 400, 20, 4, 60));
        specifications.put(AnimalType.DEER, new AnimalCharacteristics("Олень", " \uD83E\uDD8C", 300, 20, 4,  50));
        specifications.put(AnimalType.RABBIT, new AnimalCharacteristics("Кролик", " \uD83D\uDC07", 2, 150, 2, 0.5));
        specifications.put(AnimalType.MOUSE, new AnimalCharacteristics("Мышь", " \uD83D\uDC01", 0.05, 500, 1, 0.01));
        specifications.put(AnimalType.GOAT, new AnimalCharacteristics("Коза", " \uD83D\uDC10", 60, 140,  3, 10));
        specifications.put(AnimalType.SHEEP, new AnimalCharacteristics("Овца", " \uD83D\uDC11", 70, 140, 3, 15));
        specifications.put(AnimalType.WILD_BOAR, new AnimalCharacteristics("Кабан", " \uD83D\uDC11", 400, 50, 2, 50));
        specifications.put(AnimalType.BUFFALO, new AnimalCharacteristics("Буйвол", " \uD83D\uDC11", 700, 10, 3, 100));
        specifications.put(AnimalType.DUCK, new AnimalCharacteristics("Утка", " \uD83E\uDD86", 1, 200, 4, 0.15));


        //Заполняем вероятности поедания пищи
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
}