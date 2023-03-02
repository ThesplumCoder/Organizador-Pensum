package servicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import modelos.Materia;
import modelos.Pensum;
import modelos.Semestre;

public abstract class LectorPensum {
    public LectorPensum() {
        //Vacio.
    }

    private static Pensum Leer(String ruta) {
        File archivo = new File(ruta);
        Scanner lector = null;
        try {
            lector = new Scanner(archivo);
            while(lector.hasNextLine()) {
                formatoMateria(lector.nextLine());
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            lector.close();
        }
        return null;
    }

    private static Pensum formatoPensum() {
        return null;
    }

    private static Semestre formatoSemestre() {
        return null;
    }

    private static Materia formatoMateria(String datos) {
        return null;
    }
}
