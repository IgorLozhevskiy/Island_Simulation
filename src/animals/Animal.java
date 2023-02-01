package animals;

import island.Direction;
import island.Island;
import island.IslandCell;

import java.util.Random;
import java.util.UUID;

import static simulation.Simulation.movesCount;

public abstract class Animal implements Eatable, Dieable, ControlOfCondition {
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

    public void liveDay() {
        move();
        eat();
        starvation();
        controlOfCondition();
    }

    public void move() {
        Random moveDecider = new Random();
        for (int i = 0; i < animalCharacteristics.getMaxSpeed(); i++) {
            boolean moveDecision = moveDecider.nextBoolean();
            if (moveDecision) {
                moveToOtherCell();
            }
        }
        System.out.println("Animal finished his moving turn! Current position - " + position);
    }

    private void moveToOtherCell() {
        Random directionPicker = new Random();
        Direction[] directions = Direction.values();
        Direction direction;
        do {
            direction = directions[directionPicker.nextInt(directions.length)];
        } while (!directionValid(direction));
        changePosition(direction);
        movesCount.incrementAndGet();
    }

    private boolean directionValid(Direction direction) {
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
    }

    public UUID getId() {
        return id;
    }

    public IslandCell getPosition() {
        return position;
    }

    public void setPosition(IslandCell position) {
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
        return this.animalCharacteristics.getEmoji();
    }
}