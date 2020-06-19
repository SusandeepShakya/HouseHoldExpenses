public class HouseHoldExpenses {
    private String Name;
    private int Rent, PreviousElectricityUnit, NewElecricityUnit, PreviousWaterUnit, NewWaterUnit, Eres, Wres, Waste;

    public HouseHoldExpenses(String Name, int Rent, int PreviousElectricityUnit, int NewElectricityUnit, int PreviousWaterUnit, int NewWaterUnit, int Eres, int Wres, int Waste) {

        this.Name = Name;
        this.Rent = Rent;
        this.PreviousElectricityUnit = PreviousElectricityUnit;
        this.NewElecricityUnit = NewElectricityUnit;
        this.PreviousWaterUnit = PreviousWaterUnit;
        this.NewWaterUnit = NewWaterUnit;
        this.Eres = Eres;
        this.Wres = Wres;
        this.Waste = Waste;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRent() {
        return Rent;
    }

    public void setRent(int rent) {
        Rent = rent;
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

    public int getEres() {
        return Eres;
    }

    public void setEres(int eres) {
        Eres = eres;
    }

    public int getWres() {
        return Wres;
    }

    public void setWres(int wres) {
        Wres = wres;
    }

    public int getWaste() {
        return Waste;
    }

    public void setWaste(int waste) {
        Waste = waste;
    }


}


