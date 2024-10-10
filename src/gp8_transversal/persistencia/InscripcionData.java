/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp8_transversal.persistencia;
import gp8_transversal.entidades.Alumno;
import gp8_transversal.entidades.Inscripcion;
import gp8_transversal.entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Facundo ç
 */
public class InscripcionData {
    private Connection con=null;
    private MateriaData md=new MateriaData();
    private AlumnoData ad=new AlumnoData();
    
    public InscripcionData(){
        
        this.con=Conexion.getConexion();
        
    }
    
    public void guardarInscripcion(Inscripcion insc) {
        String sql= "INSERT INTO inscripcion(idAlumno, idMateria, nota) VALUES (?,?,?)";

        try {                   
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,insc.getAlumno().getIdAlumno());
            ps.setInt(2,insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                
                insc.setIdInscripcion(rs.getInt(1));
                //JOptionPane.showMessageDialog(null,"Inscripcion Registrada");
                System.out.println("Inscripcion Registrada");
                
            }
         ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla inscripcion");
           
        }
        
    }
    
    public void actualizarNota(int idAlumno,int idMateria, double nota){
    
        String sql= "UPDATE inscripcion SET nota = WHERE idAlumno = ? and idMateria = ?";
    
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
             int x=ps.executeUpdate();
            if(x>0){
                System.out.println("Nota actualizada con exito!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla inscripcion");
        }
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
    
        String sql= "DELETE FROM inscripcion WHERE idAlumno = ? and idMateria = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2,idMateria);
            
            int x=ps.executeUpdate();
            if(x>0){
                System.out.println("Inscripcion borrada exitosamente!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Inscripcion> obtenerInscripciones(){
    
        ArrayList<Inscripcion> cursadas= new ArrayList<>();
        
        String sql= "SELECT * FROM inscripcion";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            
                Inscripcion ins=new Inscripcion();
                ins.setIdInscripcion(rs.getInt("IdInscripto"));
                Alumno alu=ad.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia mat=md.buscarMateria(rs.getInt("idMateria"));
                ins.setAlumno(alu);
                ins.setMateria(mat);
                ins.setNota(rs.getDouble("nota"));
                cursadas.add(ins);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return cursadas;
        
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
    
        ArrayList<Inscripcion> cursadas= new ArrayList<>();
        
        String sql= "SELECT * FROM inscripcion WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            
                Inscripcion ins=new Inscripcion();
                ins.setIdInscripcion(rs.getInt("IdInscripto"));
                Alumno alu=ad.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia mat=md.buscarMateria(rs.getInt("idMateria"));
                ins.setAlumno(alu);
                ins.setMateria(mat);
                ins.setNota(rs.getDouble("nota"));
                cursadas.add(ins);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return cursadas;
        
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno){
    
        ArrayList<Materia> mat=new ArrayList<>();
        
        String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion,"+
                " materia WHERE inscripcion.idMateria = materia.idMateria"+
                "AND inscripcion.idAlumno = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setCuatrimestre(rs.getInt("anio"));
                mat.add(materia);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return mat;
        
        
    }

    public List<Materia> obtenerMateriasNOCursadas(int idAlumno){
    
        ArrayList<Materia> mat=new ArrayList<>();
        
        String sql= "SELECT * FROM materia WHERE estado = 1 AND idMateria not in "
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setCuatrimestre(rs.getInt("anio"));
                mat.add(materia);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return mat;
    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria){
    
        ArrayList<Alumno> alumnMat=new ArrayList<>();
        
        String sql= "SELECT a.idAlumno, dni, nombre, apellido, fechaNac,estado "
                + "FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            
                Alumno alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnMat.add(alumno);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a alguna de las tablas");
        }
        return alumnMat;
        
        
    }
}
