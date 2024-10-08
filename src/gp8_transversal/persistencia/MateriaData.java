
package gp8_transversal.persistencia;

import gp8_transversal.entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MateriaData {
    private Connection con = null;
    
    public MateriaData(){
        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        String query = "INSERT ( nombre, cuatrimestre, estado) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString (1, materia.getNombre());
            ps.setInt (2, materia.getCuatrimestre());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                materia.setIdmateria(rs.getInt(1));
                System.out.println("La materia se guardó correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cargar la materia a la base de datos");
        }   
    }
    
    public Materia buscarMateria(int id){
        String query = "SELECT nombre, cuatrimestre, estado FROM materia WHERE idMateria=?";
        Materia materia = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                materia = new Materia();
                materia.setIdmateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setCuatrimestre(rs.getInt("cuatrimestre"));
                materia.setEstado(true);      
            } else {
                System.out.println("No existe una materia con ese Id");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cargar la materia a la base de datos");
        }
      return materia;  
    }
    

    
    
}
