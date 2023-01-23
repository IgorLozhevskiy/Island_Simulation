package Island;

public class Island {
    public int xDimension;
    public int yDimension;
    public IslandCell[][] islandGrid;

    public Island(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.islandGrid = new IslandCell[xDimension][yDimension];
        for (int x = 0; x < xDimension; x++) {
            for (int y = 0; y < yDimension; y++) {
                islandGrid[x][y] = new IslandCell(x, y);
            }
        }
    }
 private int getPlantsLevel() {
        int totalPlantsInIsland = 0;
        for (IslandCell[] islandCells : islandGrid) {
            for (IslandCell islandCell : islandCells) {
                totalPlantsInIsland += islandCell.getQuantityPlantsInCell();
            }
        }
        return totalPlantsInIsland;
    }

    @Override
    public String toString() {
        return String.format("Total plants in Island.Island: %s \n", getPlantsLevel());
    }
}
