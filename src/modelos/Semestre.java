package modelos;

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

    public String toString() {
        StringBuilder datos = new StringBuilder();
        datos.append(this.numero + ", ");
        datos.append(this.periodo + ", ");
        for (Materia materia : this.materias) {
            datos.append(materia + ";");
        }
        datos.append(".");
        return new String(datos);
    }
}