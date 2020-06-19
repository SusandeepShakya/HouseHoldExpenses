import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetConnection {
    public static Connection getCon(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/householdexpenses","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    /*public static int save(HouseHoldExpenses HE){
        int status = 0;
        try{
            Connection con = getCon();
            PreparedStatement Stmt = con.prepareStatement("INSERT into electricity (PreviousEletricityUnit,NewElectricity) values(?,?)");
            Stmt.setInt(1, HE.getPreviousElectricityUnit());
            Stmt.setInt(2,HE.getNewElecricityUnit());
            status = Stmt.executeUpdate();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return status;

    }*/
}
