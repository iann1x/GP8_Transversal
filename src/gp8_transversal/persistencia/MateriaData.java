
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
import javax.swing.JOptionPane;


public class MateriaData {
    private Connection con = null;
    
    public MateriaData(){
        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        String query = "INSERT INTO materia(nombre, cuatrimestre, estado) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString (1, materia.getNombre());
            ps.setInt (2, materia.getCuatrimestre());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog (null,"La materia se guardó correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog (null,"No se pudo cargar la materia a la base de datos");
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
                JOptionPane.showMessageDialog (null,"No existe una materia con ese Id");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog (null,"No se pudo cargar la materia a la base de datos");
        }
      return materia;  
    }
    
    public void modificarMateria (Materia materia){
        String query = "UPDATE materia SET nombre= ?, cuatrimestre= ? WHERE idMateria= ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getCuatrimestre());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();
            
            if (exito ==1){
                JOptionPane.showMessageDialog (null,"La materia se modificó con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog (null,"Error al acceder a la tabla materia");
        }
    }
    
    public void bajaLogicaMateria (int id){
        //ESTE BLOQUE PERMITE VERIFICAR QUE LA MATERIA NO ESTÉ ASOCIADA A ALUMNOS
        String consulta = "SELECT COUNT(*) AS tieneAlumnos FROM inscripcion WHERE idMateria=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int alumnos = rs.getInt("tieneAlumnos");
                if (alumnos>0){
                    JOptionPane.showMessageDialog(null, "Hay alumnos inscritos en esta materia. Borre las inscripciones antes de darla de baja.");
                    return;
                }
            }
        
             //A PARTIR DE ACÁ, SI tieneAlumnos =0, DA DE BAJA LA MATERIA
            String query = "UPDATE materia SET estado=0 WHERE idMateria=?";
        
            PreparedStatement ps2 = con.prepareStatement(query);
            ps2.setInt(1, id);
            int exito = ps2.executeUpdate();
            
            if (exito==1){
                JOptionPane.showMessageDialog (null,"La materia se dio de baja con éxito.");
            }
            ps.close();
            ps2.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog (null,"Error al acceder a la tabla materia");
        }
    }
        
    public void altaLogicaMateria (int id){
        String query = "UPDATE materia SET estado=1 WHERE idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito==1){
                JOptionPane.showMessageDialog (null,"La materia se dio de alta con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog (null,"Error al acceder a la tabla materia");
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
            JOptionPane.showMessageDialog (null,"Error al acceder a la tabla materia");
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
                //JOptionPane.showMessageDialog (null,"La materia se eliminó correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog (null,"No se pudo acceder a la base de datos");
        }
        
    }
    
}
