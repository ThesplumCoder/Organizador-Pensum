package modelos;

import java.util.ArrayList;
import java.util.LinkedList;
import excepciones.MateriaIncompleta;
import servicios.Utilidades;

public class Materia {
    /*
     * Empieza por defecto en este numero porque la palabra "Requisitos" que se usa en toString()
     * tiene esa cantidad de caracteres.
     */
    private static int caracteresMaximos = 10;
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

    public static int darCaracteresMaximos() {
        return Materia.caracteresMaximos;
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

    /**
     * Devuelve los datos de la materia en una cadena.
     */
    @Override
    public String toString() {
        /*
         * Esta variable almacena el nombre de las materias que son requisitos de la materia.
         */
        LinkedList<String> aux = new LinkedList<>();
        if(this.requisitos != null) {
            for (Materia materia : this.requisitos) {
                aux.add(materia.darNombre());
            }
        } else {
            aux.add("NR");
        }
        String[] encabezados = {
            "Código",
            "Nombre",
            "Créditos",
            "Requisitos",
            "Estado"
        };

        ArrayList<String> datos = new ArrayList<>();
        datos.add(this.codigo);
        datos.add(this.nombre);
        datos.add(String.valueOf(this.creditos));
        datos.add(aux.peek());
        datos.add(this.estado.toString());
        if(aux.size() > 1) {
            for (String nReq : aux) {
                datos.add("");
                datos.add("");
                datos.add("");
                datos.add(nReq);
                datos.add("");
            }
        }

        StringBuilder res = new StringBuilder();
        for (String encabezado : encabezados) {
            encabezado = Utilidades.normalizarDatos(encabezado);
            res.append(encabezado);
        }
        res.append("\n");
        for (int i = 1; i <= datos.size(); i++) {
            res.append(Utilidades.normalizarDatos(datos.get(i-1)));
            if ((i % 5) == 0) {
                res.append("\n");
            }
        }
        
        return new String(res);
    }
}