import java.sql.*;

public class SavingIntoDatabase {

    public static void SaveTenant(HouseHoldExpenses houseHoldExpenses) throws SQLException {
        //ResultSet rs = null;
        int status = 0;
        Connection con = null;
        try {
            con = GetConnection.getConnection();
            con.setAutoCommit(false);

            //get TenantID from name
            int tenantId = 0;
            PreparedStatement tenantStmt = con.prepareStatement("SELECT ID FROM Tenant WHERE TenantName LIKE '%" + houseHoldExpenses.getName() + "%'");
            ResultSet rs = tenantStmt.executeQuery();
            while (rs.next())
                tenantId = rs.getInt("ID");

            //for saving rent
            PreparedStatement stmtRent = con.prepareStatement("INSERT INTO Rent (Rent, Waste,IssuedDate, TenantID) VALUES (?,?,?,?)");
            stmtRent.setInt(1, houseHoldExpenses.getRent());
            stmtRent.setInt(2, houseHoldExpenses.getWaste());
            stmtRent.setString(3, houseHoldExpenses.getIssuedDate());
            stmtRent.setInt(4, tenantId);
            status = stmtRent.executeUpdate();

            //for saving electricity
            PreparedStatement stmtElectricity = con.prepareStatement("INSERT INTO Electricity(PreviousElectricityUnit, NewElectricityUnit,IssuedDate, TenantID) VALUES (?,?,?,?)");
            stmtElectricity.setInt(1, houseHoldExpenses.getPreviousElectricityUnit());
            stmtElectricity.setInt(2, houseHoldExpenses.getNewElecricityUnit());
            stmtElectricity.setString(3, houseHoldExpenses.getIssuedDate());
            stmtElectricity.setInt(4, tenantId);
            status = stmtElectricity.executeUpdate();

            //for saving water
            PreparedStatement stmtWater = con.prepareStatement("INSERT INTO Water(PreviousWaterUnit, NewWaterUnit,IssuedDate, TenantID) VALUES (?,?,?,?)");
            stmtWater.setInt(1, houseHoldExpenses.getPreviousWaterUnit());
            stmtWater.setInt(2, houseHoldExpenses.getNewWaterUnit());
            stmtWater.setString(3, houseHoldExpenses.getIssuedDate());
            stmtWater.setInt(4, tenantId);
            status = stmtWater.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
        }
    }
}

