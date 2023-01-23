package Animals;
import Animals.Herbivores.Herbivores;
import Animals.Herbivores.Horse;
import Animals.Predators.Wolf;
import java.util.Map;

public class AnimalsFactory {

    private static AnimalsFactory animalsFactoryInstance;

    private AnimalsFactory() {
    }

    public static AnimalsFactory getAnimalsFactoryInstance() {
        if (animalsFactoryInstance == null) {
            animalsFactoryInstance = new AnimalsFactory();
        }
        return animalsFactoryInstance;
    }

    public Animal createAnimal(AnimalType type) {

        }
        switch (type) {
            case WOLF:
            case HORSE:
            case SNAKE:
            case FOX:
            case BEAR:
            case EAGLE:
            case DEER:
            case RABBIT:
            case MOUSE:
            case GOAT:
            case SHEEP:
            case WILD_BOAR:
            case BUFFALO:
            case DUCK:
        }
    }
}
