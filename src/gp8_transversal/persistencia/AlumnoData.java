
package gp8_transversal.persistencia;

import gp8_transversal.entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                System.out.println("El alumno se guardó correctamente"); 
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se cargar el alumno a la base de datos");
        }
    }
}
    

