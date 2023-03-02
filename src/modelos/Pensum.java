package modelos;

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

    public String toString() {
        StringBuilder datos = new StringBuilder();
        for (Semestre semestre : this.semestres) {
            datos.append(semestre);            
        }
        return new String(datos);
    }
}
