package animals;

public class AnimalCharacteristics {

    private final String emoji;
    private final String name;
    private final double maxWeight;
    private final int maxNumAnimalsInCell;
    private final int maxSpeed;
    private final double amountOfFood;

    public AnimalCharacteristics(String name, String emoji, double maxWeight, int maxNumAnimalsInCell,
                                 int maxSpeed, double amountOfFood) {
        this.name = name;
        this.emoji = emoji;
        this.maxWeight = maxWeight;
        this.maxNumAnimalsInCell = maxNumAnimalsInCell;
        this.maxSpeed = maxSpeed;
        this.amountOfFood = amountOfFood;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getName() {
        return name;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxNumAnimalsInCell() {
        return maxNumAnimalsInCell;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getAmountOfFood() {
        return amountOfFood;
    }
}
