/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp8_transversal.vistas;

import gp8_transversal.entidades.Alumno;
import gp8_transversal.persistencia.AlumnoData;
import gp8_transversal.persistencia.Conexion;
import java.sql.Connection;
import java.time.LocalDate;

/**
 *
 * @author xiana
 */
public class GP8_Transversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        
        
        Alumno xime = new Alumno (33757395, "Cuello", "Ximena", LocalDate.of(1988, 9, 28), true);
        AlumnoData al = new AlumnoData();
        al.guardarAlumno(xime);
    }
    
}
