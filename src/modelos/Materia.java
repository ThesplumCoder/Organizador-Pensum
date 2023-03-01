package modelos;

public class Materia {
    private byte creditos;
    private String codigo;
    private String nombre;
    private Materia[] requisitos;
    private EstadoMateria estado = EstadoMateria.NOCURSADA;

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

    /**
     * Devuelve los datos de la materia en una cadena.
     */
    @Override
    public String toString() {
        StringBuilder datos = new StringBuilder();
        datos.append(this.codigo + ",");
        datos.append(this.nombre + ",");
        datos.append(this.creditos + ",");
        datos.append(this.requisitos + ",");
        datos.append(this.estado + ".");        
        return new String(datos);
    }
}
