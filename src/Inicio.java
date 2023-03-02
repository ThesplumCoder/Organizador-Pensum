import java.util.LinkedList;
import java.util.Scanner;

import excepciones.MateriaIncompleta;
import excepciones.PensumVacio;
import excepciones.SemestreVacio;
import modelos.*;

public class Inicio {

    public static void main(String[] args) {
        byte respuesta = 5;
        Scanner lector = new Scanner(System.in);

        do {
            System.out.println("ORGANIZADOR DE PENSUM");
            String[] opciones = {
                "1. Crear pensum",
                "2. Leer de un archivo",
                "3. Mostrar pensum",
                "4. Aplicar ajustes",
                "5. Salir"};
            for(String opcion : opciones) {
                System.out.println(opcion);
            }

            System.out.print("R: ");
            try {
                respuesta = lector.nextByte();
            } catch (Exception e) {
                e.printStackTrace();
                respuesta = 5;
            }

            switch(respuesta){
                case 1:
                    crearPensum(lector);
                    break;
                default:
                    respuesta = 4;
                    break;
            }
        } while (respuesta != 5);

        lector.close();
    }

    /**
     * Pide los datos necesarios por consola para crear un pensum. Si sucede un
     * error se retornara un null.
     * @param lector : objeto que nos permite leer la entrada de consola.
     * @return pensum : Pensum|null.
     */
    public static Pensum crearPensum(Scanner lector) {
        LinkedList<Semestre> semestres = new LinkedList<>();
        Pensum pensum = null;

        boolean crearSemestres = true;
        do {
            semestres.push(creaSemestre(lector));
            System.out.print("¿Otro semestre?(1:si|0:no) = ");
            crearSemestres = lector.nextBoolean();
        } while (crearSemestres);
        
        try {
            pensum = new Pensum(semestres);
            return pensum;
        } catch (PensumVacio ex) {
            ex.printStackTrace();
        }
        return pensum;
    }

    /**
     * Pide los datos necesarios por consola para crear un semestre. Si sucede un
     * error se retornara un null.
     * @param lector : objeto que nos permite leer la entrada de consola.
     * @return semestre : Semestre|null.
     */
    public static Semestre creaSemestre(Scanner lector) {
        Semestre semestre = null;

        System.out.println("Semestre =");
        byte numeroSmt = lector.nextByte();
        System.out.println("Periodo =");
        String periodoSmt = lector.nextLine();
        
        boolean crearMaterias = true;
        LinkedList<Materia> materias = new LinkedList<>();
        do{
            materias.push(creaMateria(lector));
            System.out.print("¿Otra materia?(1:si|0:no) = ");
            crearMaterias = lector.nextBoolean();
        } while(crearMaterias);

        try {
            semestre = new Semestre(numeroSmt, periodoSmt, materias);
            return semestre;
        } catch (SemestreVacio ex) {
            ex.printStackTrace();
        }
        return semestre;
    }

    /**
     * Pide los datos necesarios por consola para crear una materia. Si sucede un
     * error se retornara un null.
     * @param lector : objeto que nos permite leer la entrada de consola.
     * @return materia : Materia|null.
     */
    public static Materia creaMateria(Scanner lector) {
        Materia materia = null;

        System.out.print("Codigo = ");
        String codigo = lector.nextLine();
        System.out.print("Nombre = ");
        String nombre = lector.nextLine();
        System.out.print("Creditos = ");
        byte creditos = lector.nextByte();
        System.out.print("Requisitos(separados por comas si es más de uno) = ");
        String requisitos = lector.nextLine();
        System.out.print("Estado(1:Cursada, 2:No cursada, 3:Perdida) = ");
        byte estadoRes = lector.nextByte();
        EstadoMateria estado;
        switch(estadoRes){
            case 1:
                estado = EstadoMateria.CURSADA;
                break;
            case 2:
                estado = EstadoMateria.NOCURSADA;
                break;
            case 3:
                estado = EstadoMateria.PERDIDA;
                break;
            default:
                estado = EstadoMateria.NOCURSADA;
                break;
        }

        try {
            materia = new Materia(codigo, nombre, creditos, null, estado);
            return materia;
        } catch (MateriaIncompleta ex) {
            ex.printStackTrace();
        }
        return materia;
    }
}