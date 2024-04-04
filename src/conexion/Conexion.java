package conexion;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_sistemas_ventas","root","38117303");
            return cn;
        }catch(SQLException e){
            System.out.println("Error en la conexcion local" + e);
            
        }
        return null;
        
    }
}
