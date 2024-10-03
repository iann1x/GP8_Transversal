
package gp8_transversal.entidades;


public class Materia {
    private int idmateria;
    private String nombre;
    private int anioMateria;
    private boolean estado;

    public Materia() {
    }

    public Materia(int idmateria, String nombre, int anioMateria, boolean estado) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.estado = estado;
    }

    public Materia(String nombre, int anioMateria, boolean estado) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
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

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "idmateria=" + idmateria + ", nombre=" + nombre + ", anioMateria=" + anioMateria + ", estado=" + estado + '}';
    }
    
    
}
