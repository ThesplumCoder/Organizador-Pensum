package modelos;

import java.util.ArrayList;
import java.util.LinkedList;

import excepciones.PensumVacio;

public class Pensum {
    private LinkedList<Semestre> semestres;

    public Pensum (Semestre semestre) throws PensumVacio{
        if(semestre == null) {
            throw new PensumVacio();
        } else {
            this.semestres = new LinkedList<>();
            this.semestres.add(semestre);
        }
    }

    public Pensum (LinkedList<Semestre> semestres) throws PensumVacio {
        if(semestres.isEmpty()){
            throw new PensumVacio();
        } else {
            this.semestres = semestres;
        }
    }

    /**
     * Retorna los semestres del pensum.
     * @return Una lista que contiene los semestres.
     */
    public ArrayList<Semestre> darSemestres () {
        return new ArrayList<Semestre>(this.semestres);
    }

    /**
     * Agrega un semestre al final de la lista de semestres.
     * @param s semestre a agregar.
     */
    public void agregaSemestre (Semestre s) {
        this.semestres.add(s);
    }

    /**
     * Retorna los datos del objeto estructurados.
     */
    @Override
    public String toString() {
        StringBuilder datos = new StringBuilder();
        for (Semestre semestre : this.semestres) {
            datos.append(semestre);            
        }
        return new String(datos);
    }
}
