package travel.management.system;
import java.sql.*;


public class Conn {
    Connection c;
    Statement s;
    Conn(){
        // step 1: register the driver
        //
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","Harika@9392566223");
            s=c.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new Conn();
    }
}
