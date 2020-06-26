import java.sql.*;
import java.util.ArrayList;

public class GettingFromDatabase {
    public static ArrayList<Tenant> GetTenant() {
        ResultSet Rs = null;
        ArrayList<Tenant> tenants = new ArrayList<Tenant>();

        try {
            Connection con = GetConnection.getConnection();

            PreparedStatement tenantStmt = con.prepareStatement("SELECT * FROM Tenant");
            Rs = tenantStmt.executeQuery();

            while (Rs.next()) {
                Tenant tenant = new Tenant();
                tenant.setID(Rs.getInt("ID"));
                tenant.setTenantName(Rs.getString("TenantName"));

                tenants.add(tenant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenants;
    }


}
