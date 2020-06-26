import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/householdexpenses","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
}
