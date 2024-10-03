/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp8_transversal.entidades;

/**
 *
 * @author Administrator
 */
public class Materia {
    private int idmateria;
    private String nombre;
    private int anioMateria;
    private boolean activo;

    public Materia() {
    }

    public Materia(int idmateria, String nombre, int anioMateria, boolean activo) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    public Materia(String nombre, int anioMateria, boolean activo) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Materia{" + "idmateria=" + idmateria + ", nombre=" + nombre + ", anioMateria=" + anioMateria + ", activo=" + activo + '}';
    }
    
    
}
