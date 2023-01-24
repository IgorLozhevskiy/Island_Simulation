package Animals;
import Animals.Herbivores.Herbivores;
import Animals.Herbivores.Horse;
import Animals.Predators.Wolf;
import Island.Island;
import Config.AnimalsConfig;

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

    public Animal createAnimal(Island island, AnimalType animalType) {
        Animal animal =
                switch (animalType) {
                    case WOLF -> new Wolf(island, AnimalsConfig.getInstance().getMap().get(AnimalType.WOLF));
                    case HORSE -> new Horse(island, AnimalsConfig.getInstance().getMap().get(AnimalType.HORSE));
//                    case SNAKE:
//                    case FOX:
//                    case BEAR:
//                    case EAGLE:
//                    case DEER:
//                    case RABBIT:
//                    case MOUSE:
//                    case GOAT:
//                    case SHEEP:
//                    case WILD_BOAR:
//                    case BUFFALO:
//                    case DUCK:
                };
        return animal;
    }
}
