
package gp8_transversal.entidades;


public class Materia {
    private int idmateria;
    private String nombre;
    private int cuatrimestre;
    private boolean estado;

    public Materia() {
    }

    public Materia(int idmateria, String nombre, int cuatrimestre, boolean estado) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.cuatrimestre = cuatrimestre;
        this.estado = estado;
    }

    public Materia(String nombre, int anioMateria, boolean estado) {
        this.nombre = nombre;
        this.cuatrimestre = cuatrimestre;
        this.estado = estado;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MATERIA IdMateria: " + idmateria + " "+
                "Nombre: " + nombre + " "+
                "Cuatrimestre: "+ cuatrimestre +  " "+
                "Estado: " + estado + " ";
    }
    
    
}
