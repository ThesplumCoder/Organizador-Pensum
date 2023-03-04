import java.util.LinkedList;
import java.util.Scanner;
import excepciones.MateriaIncompleta;
import excepciones.PensumVacio;
import excepciones.SemestreVacio;
import modelos.*;
import utilidades.*;

public class Inicio {

    public static void main(String[] args) {
        byte respuesta = 5;
        Pensum pensumBase = null;
        Scanner lector = new Scanner(System.in);
        
        String[] opciones = {
            "1. Crear pensum",
            "2. Leer de un archivo",
            "3. Mostrar pensum",
            "4. Aplicar ajustes",
            "5. Salir"
        };
        do {
            System.out.println("ORGANIZADOR DE PENSUM");
            for(String opcion : opciones) {
                System.out.println(opcion);
            }

            System.out.print("R: ");
            try {
                respuesta = lector.nextByte();
                lector.nextLine();
                LimpiarPantalla.limpiar();
            } catch (Exception e) {
                e.printStackTrace();
                respuesta = 5;
            }

            switch(respuesta){
                case 1:
                    pensumBase = crearPensum();
                    break;
                case 3:
                    if (pensumBase == null) {
                        System.out.println("No hay pensum aún.");
                    } else {
                        System.out.println(pensumBase);
                    }
                    break;
                case 5:
                    System.out.println("Cerrando organizador.");
                    break;
                default:
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
    public static Pensum crearPensum() {
        LinkedList<Semestre> semestres = new LinkedList<>();
        Pensum pensum = null;

        try (Scanner lector = new Scanner(System.in)) {
            boolean crearSemestres = true;
            do {
                semestres.push(creaSemestre());
                System.out.print("¿Otro semestre?(1:si|0:no) = ");
                crearSemestres = (lector.nextByte() == 1)? true : false;
                lector.nextLine();
            } while (crearSemestres);
            LimpiarPantalla.limpiar();
    
            pensum = new Pensum(semestres);
            return pensum;
        } catch (PensumVacio pensumVacio) {
            pensumVacio.printStackTrace();
        }
        return pensum;
    }

    /**
     * Pide los datos necesarios por consola para crear un semestre. Si sucede un
     * error se retornara un null.
     * @param lector : objeto que nos permite leer la entrada de consola.
     * @return semestre : Semestre|null.
     */
    public static Semestre creaSemestre() {
        Semestre semestre = null;

        try (Scanner lector = new Scanner(System.in)) {
            System.out.println("Semestre =");
            byte numeroSmt = lector.nextByte();
            lector.nextLine();
            System.out.println("Periodo =");
            String periodoSmt = lector.nextLine();
            
            boolean crearMaterias = true;
            LinkedList<Materia> materias = new LinkedList<>();
            do{
                materias.push(creaMateria());
                System.out.print("¿Otra materia?(1:si|0:no) = ");
                byte res = lector.nextByte();
                crearMaterias = (res == 1)? true : false;
                lector.nextLine();
            } while(crearMaterias);
            LimpiarPantalla.limpiar();
    
            semestre = new Semestre(numeroSmt, periodoSmt, materias);
            return semestre;
        } catch (SemestreVacio semestreVacio) {
            semestreVacio.printStackTrace();
        }
        return semestre;
    }

    /**
     * Pide los datos necesarios por consola para crear una materia. Si sucede un
     * error se retornara un null.
     * @param lector : objeto que nos permite leer la entrada de consola.
     * @return materia : Materia|null.
     */
    public static Materia creaMateria() {
        Materia materia = null;

        try (Scanner lector = new Scanner(System.in)) {
            System.out.print("Codigo = ");
            String codigo = lector.nextLine();
            System.out.print("Nombre = ");
            String nombre = lector.nextLine();
            System.out.print("Creditos = ");
            byte creditos = lector.nextByte();
            lector.nextLine();
            System.out.print("Requisitos(separados por comas si es más de uno) = ");
            String requisitos = lector.nextLine();
            System.out.print("Estado(1:Cursada, 2:No cursada, 3:Perdida) = ");
            byte estadoRes = lector.nextByte();
            lector.nextLine();
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

            materia = new Materia(codigo, nombre, creditos, null, estado);
            return materia;
        } catch (MateriaIncompleta materiaIncompleta) {
            materiaIncompleta.printStackTrace();
        }
        return materia;
    }
}