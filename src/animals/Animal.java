package animals;

import island.Direction;
import island.Island;
import island.IslandCell;
import Simulation.InitSimulation;

import java.util.Random;
import java.util.UUID;

public abstract class Animal implements Eatable { // Runnable
    private static final int MOVE_DISTANCE = 3;

    private UUID id;

    private final Island island;

    private AnimalCharacteristics animalCharacteristics;
    public IslandCell position;

    public Animal(Island island, AnimalCharacteristics animalCharacteristics) {
        this.id = UUID.randomUUID();
        this.island = island;
        this.animalCharacteristics = animalCharacteristics;
    }
    public abstract AnimalType getAnimalType();

    public AnimalCharacteristics getAnimalCharacteristics() {
        return animalCharacteristics;
    }

    //    @Override
//    public void run() {
//        liveDay();
//    }

    public void liveDay() {
       move();
        eat();
//    controllState();

    }
    public void move() {
        System.out.println("Animals.Animal started moving. Current position - " + position);
        Random moveDecider = new Random();
        for (int i = 0; i < MOVE_DISTANCE; i++) {
            boolean moveDecision = moveDecider.nextBoolean();
            if (moveDecision) {
                System.out.println("Animals.Animal will move...");
                moveToOtherCell();
            } else {
                System.out.println("Animals.Animal decided to stay for here now...");
            }
        }
        System.out.println("Animals.Animal finished his moving turn!");
        System.out.println("Current position - " + position);
    }

    private void moveToOtherCell() {
        Random directionPicker = new Random();
        Direction[] directions = Direction.values();
        Direction direction;
        do {
            direction = directions[directionPicker.nextInt(directions.length)];
        } while (!directionValid(direction));
        changePosition(direction);
        InitSimulation.movesCount.incrementAndGet();
    }

    private boolean directionValid(Direction direction) {
        System.out.println("Picking direction...");
        switch (direction) {
            case UP: // по y
                return position.getY() - 1 > 0;
            case DOWN: // по y
                return position.getY() + 1 < island.yDimension;
            case LEFT: // по x
                return position.getX() - 1 > 0;
            case RIGHT:
                return position.getX() + 1 < island.xDimension;
            default:
                throw new IllegalArgumentException("Invalid coordinates");
        }
    }


    private void changePosition(Direction direction) {
        System.out.println("Animals.Animal changes position...");
        int newX = -1;
        int newY = -1;
        switch (direction) {
            case UP:
                newX = position.getX();
                newY = position.getY() - 1;
                break;
            case DOWN:
                newX = position.getX();
                newY = position.getY() + 1;
                break;
            case LEFT:
                newX = position.getX() - 1;
                newY = position.getY();
                break;
            case RIGHT:
                newX = position.getX() + 1;
                newY = position.getY();
                break;
        }
        IslandCell newIslandCell = island.islandGrid[newX][newY];
        this.position.removeAnimalInCell(this);
        this.position = newIslandCell;
        this.position.addOneAnimalInCell(this);
        System.out.println("Position changed...");
    }

    public IslandCell getPosition() { // геттер x and y + List animals
        return position;
    }

    public void setPosition(IslandCell position) { // сеттер
        this.position = position;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return id.equals(animal.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return this.animalCharacteristics.getName().toString();
    }
}