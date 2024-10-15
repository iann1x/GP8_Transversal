/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp8_transversal.vistas;

import gp8_transversal.entidades.Alumno;
import gp8_transversal.entidades.Inscripcion;
import gp8_transversal.entidades.Materia;
import gp8_transversal.persistencia.AlumnoData;
import gp8_transversal.persistencia.Conexion;
import gp8_transversal.persistencia.InscripcionData;
import gp8_transversal.persistencia.MateriaData;
import java.sql.Connection;



import java.time.LocalDate;
import java.time.Month;

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
        Menu menuvista = new Menu();
        menuvista.setVisible(true);
       //AlumnoData al = new AlumnoData();
        
        
   // Alumno xime = new Alumno (2,33757321, "Juan", "Chiti", LocalDate.of(1988, 9, 28), true);
//      Alumno kevin = new Alumno (37256123, "Garcia", "Kevin", LocalDate.of(1993, 7, 31), true);
//        Alumno facu = new Alumno (25756891, "Garcia", "Facundo", LocalDate.of(1997,4,5), true);
//        Alumno ian = new Alumno (38147951, "Chiti", "Ian", LocalDate.of(2000, 10, 7), true);
        
        //al.guardarAlumno(xime);
        //al.guardarAlumno(kevin);
//        al.guardarAlumno(facu);
//        al.guardarAlumno(ian);
        //al.altaLogica(2);
        
        
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
                
//        for (Alumno alumno:al.mostrarAlumnos()){
//            System.out.println(alumno.toString());
//            
//        }
     
   //MateriaData mat = new MateriaData();
    
    //PROBAMOS QUE FUNCIONA EL METODO Y CARGAMOS CUATRO MATERIAS
    /*
    Materia matematica = new Materia("Matematica", 1, true);
    Materia labo = new Materia ("Laboratorio", 2, true);
    Materia web = new Materia ("Programacion web", 2, true);
    Materia base = new Materia ("Base de datos", 2, true);
    
    mat.guardarMateria(matematica);
    mat.guardarMateria(labo);
    mat.guardarMateria(web);
    mat.guardarMateria(base);
    */
    
    //PROBAMOS MODIFICAR UNA MATERIA
//   Materia base = new Materia (3, "Base de datos I", 3);
//   mat.modificarMateria(base);

    
    //PROBAMOS QUE FUNCIONA EL ALTA Y BAJA LOGICA  
 //    mat.bajaLogicaMateria(2);
 //    mat.altaLogicaMateria(2);
 
 
    //PROBAMOS QUE FUNCIONA LA BUSQUEDA POR ID
//    Materia encontrada = mat.buscarMateria(2);
//       
//        System.out.println("Id: "+encontrada.getIdMateria());
//        System.out.println("Nombre: "+encontrada.getNombre());
//        System.out.println("Cuatrimestre: "+encontrada.getCuatrimestre());
//        System.out.println("Estado: "+encontrada.isEstado());
      
      //PROBAMOS QUE FUNCIONA MOSTRAR TODAS LAS MATERIAS
//    for (Materia materia:mat.mostrarMaterias()){
//            System.out.println(materia.toString());
//    }

  //     mat.borrarMateria(1);

    //InscripcionData id= new InscripcionData();
    //inscripciondata pruebas
    
    /*for(Inscripcion inscripcion:id.obtenerInscripciones()){
    
        System.out.println("id " +inscripcion.getIdInscripcion());
        System.out.println("Apellido "+inscripcion.getAlumno().getApellido());
        System.out.println("Materia "+inscripcion.getMateria().getNombre());
    }
    */
    }
    
    
}
