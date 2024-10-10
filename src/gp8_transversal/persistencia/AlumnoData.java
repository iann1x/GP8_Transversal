
package gp8_transversal.persistencia;

import gp8_transversal.entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class AlumnoData {
    private Connection con = null;
    
    public AlumnoData(){
        con = Conexion.getConexion();
    }
    
    public void guardarAlumno (Alumno alumno){
        String query = "INSERT INTO alumno(dni, apellido, nombre, fechaNac, estado) VALUES (?, ?, ?, ?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate (4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                //JOptionPane.showMessageDialog (null, "El alumno se guardó correctamente."); 
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog (null,"No se pudo cargar el alumno a la base de datos");
        }
    }
    
    public List<Alumno> mostrarAlumnos (){
       String query = "SELECT idAlumno, dni, apellido, nombre, fechaNac FROM alumno WHERE estado=1";
       ArrayList <Alumno> alumnos = new ArrayList<>( );
       
       try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(true);
                
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
           //System.out.println("Error al acceder a la tabla alumno");
        }
        return alumnos;
    }

    public void modificarAlumno(Alumno alumno){
        String sql="UPDATE alumno SET dni= ?, apellido = ?, nombre=?, fechaNac=?" + "WHERE idAlumno = ?";
 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito = ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "El alumno fue modificado con exito");
                //System.out.println("El alumno fue modificado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
            //System.out.println("Error al acceder a la tabla alumno");
        }
    }
 
    public void bajaLogica (int id){
        String sql="UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
         
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "El alumno se dio de baja con exito.");
                //System.out.println("El alumno se dio de baja con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
            //System.out.println("Error al acceder a la tabla alumno");
        }
    }
    public void altaLogica (int id){
        String sql="UPDATE alumno SET estado = 1 WHERE idAlumno = ?";
         
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog (null,"El Alumno fue dado de alta con exito!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public Alumno buscarAlumnoPorId (int id){
        String query = "SELECT dni, apellido, nombre, fechaNac FROM alumno WHERE idAlumno=? AND estado=1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(true);
            }else{
                JOptionPane.showMessageDialog (null,"No existe un alumno con ese Id");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog (null,"No se pudo acceder a la base de datos");
        }
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni (int dni){
        String query = "SELECT idAlumno, dni, apellido, nombre, fechaNac FROM alumno WHERE dni=? AND estado=1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(true);
            }else{
                System.out.println("No existe un alumno con ese DNI");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo acceder a la base de datos");
        }
        return alumno;
    }
    
    public void borrarAlumno (int id){
        String query = "DELETE FROM alumno WHERE idAlumno=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1){
                System.out.println("El alumno se eliminó correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo acceder a la base de datos");
        }
        
        
    }   
}
    

