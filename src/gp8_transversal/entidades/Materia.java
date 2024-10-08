
package gp8_transversal.entidades;


public class Materia {
    private int idMateria;
    private String nombre;
    private int cuatrimestre;
    private boolean estado;

    public Materia() {
    }

    public Materia(int idMteria, String nombre, int cuatrimestre, boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.cuatrimestre = cuatrimestre;
        this.estado = estado;
    }

    public Materia(String nombre, int cuatrimestre, boolean estado) {
        this.nombre = nombre;
        this.cuatrimestre = cuatrimestre;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
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

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
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
        return "MATERIA IdMateria: " + idMateria + " "+
                "Nombre: " + nombre + " "+
                "Cuatrimestre: "+ cuatrimestre +  " "+
                "Estado: " + estado + " ";
    }
    
    
}
