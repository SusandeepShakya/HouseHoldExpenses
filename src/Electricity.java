public class Electricity {

    private int ID,PreviousElectricityUnit, NewElecricityUnit;

    public Electricity(int PreviousElectricityUnit, int NewElecricityUnit){
        this.PreviousElectricityUnit = PreviousElectricityUnit;
        this.NewElecricityUnit = NewElecricityUnit;

    }
    public int getID() {
        return ID;
    }
    public int getPreviousElectricityUnit() {
        return PreviousElectricityUnit;
    }

    public void setPreviousElectricityUnit(int previousElectricityUnit) {
        PreviousElectricityUnit = previousElectricityUnit;
    }

    public int getNewElecricityUnit() {
        return NewElecricityUnit;
    }

    public void setNewElecricityUnit(int newElecricityUnit) {
        NewElecricityUnit = newElecricityUnit;
    }
}
