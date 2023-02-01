package animals;

import animals.herbivores.*;
import animals.herbivores.WildBoar;
import animals.predators.*;

import island.Island;
import config.AnimalsConfig;

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
                    case SNAKE -> new Snake(island, AnimalsConfig.getInstance().getMap().get(AnimalType.SNAKE));
                    case FOX -> new Fox(island, AnimalsConfig.getInstance().getMap().get(AnimalType.FOX));
                    case BEAR -> new Bear(island, AnimalsConfig.getInstance().getMap().get(AnimalType.BEAR));
                    case EAGLE -> new Eagle(island, AnimalsConfig.getInstance().getMap().get(AnimalType.EAGLE));
                    case DEER -> new Deer(island, AnimalsConfig.getInstance().getMap().get(AnimalType.DEER));
                    case RABBIT -> new Rabbit(island, AnimalsConfig.getInstance().getMap().get(AnimalType.RABBIT));
                    case MOUSE -> new Mouse(island, AnimalsConfig.getInstance().getMap().get(AnimalType.MOUSE));
                    case GOAT -> new Goat(island, AnimalsConfig.getInstance().getMap().get(AnimalType.GOAT));
                    case SHEEP -> new Sheep(island, AnimalsConfig.getInstance().getMap().get(AnimalType.SHEEP));
                    case WILD_BOAR ->
                            new WildBoar(island, AnimalsConfig.getInstance().getMap().get(AnimalType.WILD_BOAR));
                    case BUFFALO -> new Buffalo(island, AnimalsConfig.getInstance().getMap().get(AnimalType.BUFFALO));
                    case DUCK -> new Duck(island, AnimalsConfig.getInstance().getMap().get(AnimalType.DUCK));
                    default -> throw new IllegalArgumentException("Not recognized animal type. " + animalType);
                };
        return animal;
    }
}
