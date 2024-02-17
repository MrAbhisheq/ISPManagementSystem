import java.sql.*;


public class Database {
    
    Connection conn;
    public static java.sql.Connection ConnectDb(){
        try{
           java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ak_isp", "root", "root");
           return conn;
        }
        catch(Exception e){
        }
        return null;
    }
    public static void main(String args[])
    {}
}
