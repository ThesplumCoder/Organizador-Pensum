package modelos;

import java.util.ArrayList;
import java.util.LinkedList;
import excepciones.SemestreVacio;

public class Semestre {
    private byte numero;
    private String periodo;
    private LinkedList<Materia> materias;

    public Semestre(LinkedList<Materia> materias) throws SemestreVacio{
        if(materias == null) {
            throw new SemestreVacio();
        }
        this.numero = 0;
        this.periodo = null;
        this.materias = materias;
    }

    public Semestre(byte numero, String periodo, LinkedList<Materia> materias) throws SemestreVacio{
        if(materias.isEmpty()) {
            throw new SemestreVacio();
        }
        this.numero = numero;
        this.periodo = periodo;
        this.materias = materias;
    }

    /**
     * Retorna el numero del semestre.
     * @return numero
     */
    public byte darNumero () {
        return this.numero;
    }

    /**
     * Retorna el periodo en el que se desarrolla el semestre.
     * @return periodo
     */
    public String darPeriodo () {
        return this.periodo;
    }

    /**
     * Retorna las materias que tiene asignadas.
     * @return materias
     */
    public ArrayList<Materia> darMaterias () {
        return new ArrayList<Materia>(this.materias);
    }

    public String toString() {
        StringBuilder datos = new StringBuilder();
        datos.append(this.numero + ", ");
        datos.append(this.periodo + "\n");
        for (Materia materia : this.materias) {
            datos.append(materia + "\n");
        }
        return new String(datos);
    }
}