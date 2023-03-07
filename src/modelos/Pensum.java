package modelos;

import java.util.ArrayList;
import java.util.LinkedList;

import excepciones.PensumVacio;

public class Pensum {
    private LinkedList<Semestre> semestres;

    public Pensum(LinkedList<Semestre> semestres) throws PensumVacio {
        if(semestres.isEmpty()){
            throw new PensumVacio();
        } else {
            this.semestres = semestres;
        }
    }

    /**
     * Retorna los semestres del pensum.
     * @return semestres Una instancia de ArrayList que contiene los semestres.
     */
    public ArrayList<Semestre> darSemestres () {
        return new ArrayList<Semestre>(this.semestres);
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
