
package gp8_transversal.persistencia;

import gp8_transversal.entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MateriaData {
    private Connection con = null;
    
    public MateriaData(){
        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        String query = "INSERT (nombre, cuatrimestre, estado) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString (1, materia.getNombre());
            ps.setInt (2, materia.getCuatrimestre());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
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
                materia.setIdMateria(id);
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
    
    public void modificarMateria (Materia materia){
        String query = "UPDATE materia SET nombre = ?, cuatrimestre=?" + "WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getCuatrimestre());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();
            
            if (exito ==1){
                System.out.println("La materia se modificó con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
             System.out.println("Error al acceder a la tabla materia");
        }
    }
    
    public void bajaLogicaMateria (int id){
        String query = "UPDATE materia SET estado = 0" + "WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            
            if (exito==1){
                System.out.println("La materia se dio de baja con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla materia");
        }
    }
        
    public void altaLogicaMateria (int id){
        String query = "UPDATE materia SET estado = 1" + "WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito==1){
                System.out.println("La materia se dio de alta con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla materia");
        }
    }
    
    public List <Materia> mostrarMaterias(){
        String query = "SELECT idMateria, nombre, cuatrimestre FROM materia WHERE estado =1";
        ArrayList <Materia> materias = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setCuatrimestre(rs.getInt("cuatrimestre"));
                materia.setEstado(true);
                
                materias.add(materia);      
            }
            ps.close(); 
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla materia");
        }
        return materias;
    }
    
    public void borrarMateria (int id){
        String query = "DELETE FROM materia WHERE idMateria=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            
            if(exito == 1){
                System.out.println("La materia se eliminó correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo acceder a la base de datos");
        }
        
    }
    
}
