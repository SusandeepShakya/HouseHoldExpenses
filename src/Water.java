public class Water {
    private int ID;
    private int PreviousWaterUnit;
    private int NewWaterUnit;

    public Water(int PreviousWaterUnit, int NewWaterUnit) {
        this.PreviousWaterUnit = PreviousWaterUnit;
        this.NewWaterUnit = NewWaterUnit;
    }

    public int getID() {
        return ID;
    }

    public int getPreviousWaterUnit() {
        return PreviousWaterUnit;
    }

    public void setPreviousWaterUnit(int previousWaterUnit) {
        PreviousWaterUnit = previousWaterUnit;
    }

    public int getNewWaterUnit() {
        return NewWaterUnit;
    }

    public void setNewWaterUnit(int newWaterUnit) {
        NewWaterUnit = newWaterUnit;
    }
}
