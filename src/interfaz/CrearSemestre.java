package interfaz;

import java.util.LinkedList;

import modelos.Materia;
import modelos.Semestre;
import servicios.Utilidades;

/**
 * Se encargar de pedir y validar los datos necesarios para crear un semestre.
 * @author ThesplumCoder
 */
public abstract class CrearSemestre {

    private static byte pedirNumero () {
        byte numero = 0;
        do {
            System.out.print("Semestre = ");
            String aux = Utilidades.leer();
            try {
                numero = Byte.parseByte(aux);
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Intente de nuevo...");
            }
        } while (true);
        return numero;
    }

    private static String pedirPeriodo () {
        String periodo = null;
        do {
            System.out.print("Periodo = ");
            String aux = Utilidades.leer();
            try {
                periodo = aux;
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Intente de nuevo...");
            }
        } while (true);
        return periodo;
    }

    private static LinkedList<Materia> pedirMaterias () {
        LinkedList<Materia> materias = new LinkedList<>();
        do{
            Utilidades.limpiar();
            materias.push(CrearMateria.crea());
            System.out.print("¿Otra materia?(1:si|0:no) = ");
            String res = Utilidades.leer();
            if(!(res.equals("1"))) {
                break;
            }
        } while(true);
        return materias;
    }

    /**
     * Pide los datos necesarios por consola para crear un semestre. Si sucede un error se retornara
     * un null.
     * @return Retorna un semestre, si ocurre un error retorna null.
     */
    public static Semestre crea () {
        Semestre semestre = null;
        do {
            try {
                System.out.println("[Creando Semestre]");
                byte numero = pedirNumero();
                String periodo = pedirPeriodo();
                LinkedList<Materia> materias = pedirMaterias();
                Utilidades.limpiar();
        
                semestre = new Semestre(numero, periodo, materias);
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Intente de nuevo...");
            }
        } while (true);
        return semestre;
    }
}
