import java.sql.Date;
import java.time.LocalDateTime;

public class HouseHoldExpenses {
    public String Name;
    public int Rent, PreviousElectricityUnit, NewElectricityUnit, PreviousWaterUnit, NewWaterUnit, Eres, Wres, Waste;
    public String IssuedDate;

    public HouseHoldExpenses() {

        this.Name = Name;
        this.Rent = Rent;
        this.PreviousElectricityUnit = PreviousElectricityUnit;
        this.NewElectricityUnit = NewElectricityUnit;
        this.PreviousWaterUnit = PreviousWaterUnit;
        this.NewWaterUnit = NewWaterUnit;
        this.Eres = Eres;
        this.Wres = Wres;
        this.Waste = Waste;
    }

    public String getIssuedDate() {
        return IssuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        IssuedDate = issuedDate;
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
        return NewElectricityUnit;
    }

    public void setNewElecricityUnit(int newElecricityUnit) {
        NewElectricityUnit = newElecricityUnit;
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


