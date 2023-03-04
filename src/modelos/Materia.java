package modelos;

import java.util.LinkedList;

import excepciones.MateriaIncompleta;

public class Materia {
    static int caracteresMaximos = 1;
    private byte creditos;
    private String codigo;
    private String nombre;
    private LinkedList<Materia> requisitos;
    private EstadoMateria estado;

    public Materia(String codigo, String nombre, byte creditos, LinkedList<Materia> requisitos) throws MateriaIncompleta {
        if(codigo == null || nombre == null) {
            throw new MateriaIncompleta();
        } else {
            this.creditos = creditos;
            this.codigo = codigo;
            this.nombre = nombre;
            this.requisitos = requisitos;
            if(this.nombre.length() > Materia.caracteresMaximos) {
                Materia.caracteresMaximos = this.nombre.length();
            }
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
            if(this.nombre.length() > Materia.caracteresMaximos) {
                Materia.caracteresMaximos = this.nombre.length();
            }
        }
    }

    public byte darCreditos() {
        return this.creditos;
    }

    public String darCodigo() {
        return this.codigo;
    }

    public String darNombre() {
        return this.nombre;
    }

    public LinkedList<Materia> darRequisitos() {
        return this.requisitos;
    }

    public EstadoMateria darEstado() {
        return this.estado;
    }

    private String normalizarDatos(String dato) {
        int diferencia = Materia.caracteresMaximos - dato.length();
        if(diferencia != 0) {
            StringBuilder aux = new StringBuilder();
            for(int i = 1; i <= diferencia; i++) {
                aux.append(" ");
            }
            return dato.concat(new String(aux));
        }
        return dato;
    }

    /**
     * Devuelve los datos de la materia en una cadena.
     */
    @Override
    public String toString() {
        /*
         * Esta variable almacena el nombre de las materias que son requisitos de la materia.
         */
        StringBuilder aux = new StringBuilder();
        if(this.requisitos != null) {
            for (Materia materia : this.requisitos) {
                aux.append(materia.darNombre() + ", ");
            }
        } else {
            aux.append("NR");
        }

        String[] encabezados = {
            "Código",
            "Nombre",
            "Créditos",
            "Requisitos",
            "Estado"
        };
        String[] datos = {
            this.codigo,
            this.nombre,
            String.valueOf(this.creditos),
            new String(aux),
            this.estado.toString()
        };

        StringBuilder res = new StringBuilder();
        for (String encabezado : encabezados) {
            encabezado = normalizarDatos(encabezado);
            res.append(encabezado);
        }
        res.append("\n");
        for (String dato : datos) {
            dato = normalizarDatos(dato);
            res.append(dato);
        }
        
        return new String(res);
    }
}
