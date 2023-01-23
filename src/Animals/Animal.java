package Animals;

import Island.Direction;
import Island.Island;
import Island.IslandCell;
import Simulation.AppRunner;

import java.util.Random;
import java.util.UUID;

public abstract class Animal {
    private static final int MOVE_DISTANCE = 3;

    private UUID id;

    private final Island island;
    IslandCell position;

    public Animal(Island island) {
        this.id = UUID.randomUUID();
        this.island = island;
    }
    public abstract AnimalType getAnimalType();
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
        AppRunner.movesCount.incrementAndGet();
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


    public void eat() {
//        1. достучаться до коллекции абстрактной клетки, в которой есть список растений (объекта растения)
//        2. проверить есть ли в списке хотя бы один объект растения
//        3. если есть хотя бы один такой объект, то вызвать метод removePlant() и удалить из списка 1 объект растения
//        это будет считаться, что животное поело и отразить в логе, что объект растения удалён из списка
//        boolean empty = true;
//        for (Plant plant : position.plantsList) {
//            if (plant != null) {
//                empty = false;
//                break;
//            }
//        }
//        Island.IslandCell newIslandCell = island.islandGrid[newX][newY];
//        this.position = newIslandCell;
//        this.position.removePlant(plant);
    }

    public void die() {
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
        this.position.removeAnimal(this);
        this.position = newIslandCell;
        this.position.addToAnimalsInCell(this);
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

}