package modelos;

import java.util.LinkedList;

import excepciones.MateriaIncompleta;

public class Materia {
    private byte creditos;
    private String codigo;
    private String nombre;
    private LinkedList<Materia> requisitos;
    private EstadoMateria estado;

    public Materia(String codigo, String nombre, byte creditos, LinkedList<Materia> requisitos) throws MateriaIncompleta {
        if(codigo.isEmpty() || nombre.isEmpty()) {
            throw new MateriaIncompleta();
        } else {
            this.creditos = creditos;
            this.codigo = codigo;
            this.nombre = nombre;
            this.requisitos = requisitos;
        }
    }

    public Materia(String codigo, String nombre, byte creditos, LinkedList<Materia> requisitos, EstadoMateria estado) throws MateriaIncompleta {
        if(codigo.isEmpty() || nombre.isEmpty()) {
            throw new MateriaIncompleta();
        } else {
            this.creditos = creditos;
            this.codigo = codigo;
            this.nombre = nombre;
            this.requisitos = requisitos;
            this.estado = estado;
        }
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
        if(!(this.requisitos.isEmpty())) {
            for(Materia m : this.requisitos) {
                datos.append(m + ",");
            }
        } else {
            datos.append("NR, ");
        }
        datos.append(this.estado + ".");        
        return new String(datos);
    }
}
