package controlador;

import modelo.Categoria;
import conexion.Conexion;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;


public class Ctrl_Categoria {
    //metodo para registar categoria
    public boolean guardar(Categoria objeto){
        boolean respuesta=false;
        Connection cn= conexion.Conexion.conectar();
        try {
            PreparedStatement consulta= cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar categoria" + e);
        }
        return respuesta;    
    }
    
    //metodo para registar categoria
    public boolean existeCategoria(String categoria){
        boolean respuesta=false;
        String sql = "select descripcion from tb_categoria where descripcion='"+categoria+"';";
        Statement st;
        
        try {
           Connection cn=  Conexion.conectar();
           st=cn.createStatement();
           ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                respuesta=true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar duplicado de categoria" + e);
        }
        return respuesta;    
    }
    
    
}
