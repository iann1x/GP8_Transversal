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
        
        AlumnoData al = new AlumnoData();
        
        
//      Alumno xime = new Alumno (1,33757395, "Josecho", "Federico", LocalDate.of(1988, 9, 28), true);
        
        //al.guardarAlumno(xime);
        //al.modificarAlumno(xime);
        //al.bajaLogica(2);
        
        //Acá probamos que devuelva mensaje de error cuando no existe el Id buscado
        //Alumno encontrado2 = al.buscarAlumnoPorId(35); 
        
        //Acá vemos que funciona bien el metodo        
        /*
        Alumno encontrado = al.buscarAlumnoPorId(1);
        System.out.println("Id: "+encontrado.getIdAlumno());
        System.out.println("DNI: "+encontrado.getDni());
        System.out.println("Apellido: "+encontrado.getApellido());
        System.out.println("Nombre: "+encontrado.getNombre());
        System.out.println("Fecha de nacimiento: "+encontrado.getFechaNac());
        System.out.println("Estado: "+encontrado.isEstado());
        */

        //Acá probamos que devuelva mensaje de error cuando no existe el dni
        //Alumno encontradoDni2 = al.buscarAlumnoPorDni(33888244);

        
        //Acá vemos que funciona bien el metodo
        /*
        Alumno encontradoDni = al.buscarAlumnoPorDni(33757395);
        System.out.println("Id: "+encontradoDni.getIdAlumno());
        System.out.println("DNI: "+encontradoDni.getDni());
        System.out.println("Apellido: "+encontradoDni.getApellido());
        System.out.println("Nombre: "+encontradoDni.getNombre());
        System.out.println("Fecha de nacimiento: "+encontradoDni.getFechaNac());
        System.out.println("Estado: "+encontradoDni.isEstado());
        */
                
        for (Alumno alumno:al.mostrarAlumnos()){
            System.out.println(alumno.toString());
            
        }
       
        
    }
    
}
