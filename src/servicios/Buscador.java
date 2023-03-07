package servicios;

import java.util.ArrayList;
import excepciones.PensumVacio;
import modelos.*;

public abstract class Buscador {

    /**
     * Busca la materia en el pensum dado, según el código.
     * @param codigo Codigo de la materia.
     * @param pensum Pensum sobre el cual se busca la materia.
     * @return materia Si encuentra una materia que tenga ese código la retorna, sino retorna null.
     * @throws PensumVacio Se lanza si el pensum dado apunta a null. 
     */
    public static Materia buscarMateria(String codigo, Pensum pensum) throws PensumVacio {
        if (pensum == null) {
            throw new PensumVacio();
        }
        Materia res = null;
        ArrayList<Semestre> semestres = pensum.darSemestres();
        ArrayList<Materia> materias = new ArrayList<>();

        for (Semestre semestre : semestres) {
            for (Materia materia : semestre.darMaterias()) {
                materias.add(materia);
            }
        }
        for (Materia materia : materias) {
            if(materia.darCodigo().equals(codigo)) {
                return res = materia;
            }
        }
        return res;
    }
}