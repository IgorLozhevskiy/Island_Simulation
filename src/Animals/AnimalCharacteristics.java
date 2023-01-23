package Animals;

public class AnimalCharacteristics {
    private final String emoji;
    private final String name;
    private final double maxWeight;
    private final int maxNumInCell;
    private final int maxSpeed;
    private final double amountOfFood;

    public AnimalCharacteristics(String name, String emoji, double maxWeight, int maxNumInCell, int maxSpeed, double amountOfFood) {
        this.name = name;
        this.emoji = emoji;
        this.maxWeight = maxWeight;
        this.maxNumInCell = maxNumInCell;
        this.maxSpeed = maxSpeed;
        this.amountOfFood = amountOfFood;
    }

}
