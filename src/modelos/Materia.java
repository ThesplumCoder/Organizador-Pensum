package modelos;

public class Materia {
    private byte creditos;
    private String codigo;
    private String nombre;
    private Materia[] requisitos;
    private EstadoMateria estado = EstadoMateria.noCursada;

    public Materia(String codigo, String nombre, byte creditos, Materia[] requisitos) {
        this.creditos = creditos;
        this.codigo = codigo;
        this.nombre = nombre;
        this.requisitos = requisitos;
    }

    public Materia(String codigo, String nombre, byte creditos, Materia[] requisitos, EstadoMateria estado) {
        this.creditos = creditos;
        this.codigo = codigo;
        this.nombre = nombre;
        this.requisitos = requisitos;
        this.estado = estado;
    }
}
