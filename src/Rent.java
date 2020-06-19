public class Rent {


    private int ID;
    private int Rent;
    private int Waste;
    private int IssuedDate;

    public Rent(int Rent, int Waste, int IssuedDate) {
        this.Rent = Rent;
        this.Waste = Waste;
        this.IssuedDate = IssuedDate;
    }

    public int getID() {
        return ID;
    }

    public int getRent() {
        return Rent;
    }

    public void setRent(int rent) {
        Rent = rent;
    }

    public int getWaste() {
        return Waste;
    }

    public void setWaste(int waste) {
        Waste = waste;
    }

    public int getIssuedDate() {
        return IssuedDate;
    }

    public void setIssuedDate(int issuedDate) {
        IssuedDate = issuedDate;
    }

}
