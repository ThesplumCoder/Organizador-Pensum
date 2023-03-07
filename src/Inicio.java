import java.util.LinkedList;
import java.util.Scanner;
import excepciones.*;
import modelos.*;
import servicios.Buscador;
import servicios.Utilidades;

public class Inicio {
    static Scanner entrada = new Scanner(System.in);
    static Pensum pensumBase = null;

    public static void main(String[] args) {
        byte respuesta = 5;
        
        
        String[] opciones = {
            "1. Crear pensum",
            "2. Leer de un archivo",
            "3. Mostrar pensum",
            "4. Aplicar ajustes",
            "5. Salir"
        };
        do {
            Utilidades.limpiar();
            System.out.println("ORGANIZADOR DE PENSUM");
            for(String opcion : opciones) {
                System.out.println(opcion);
            }

            System.out.print("R: ");
            try {
                respuesta = entrada.nextByte();
                entrada.nextLine();
                Utilidades.limpiar();
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
                        System.out.print("Salir...");
                        String salir = entrada.nextLine();
                    } else {
                        System.out.print(pensumBase);
                        System.out.print("Salir...");
                        String salir = entrada.nextLine();
                    }
                    break;
                case 5:
                    System.out.println("Cerrando organizador.");
                    break;
                default:
                    break;
            }
        } while (respuesta != 5);

        entrada.close();
    }

    /**
     * Pide los datos necesarios por consola para crear un pensum. Si sucede un
     * error se retornara un null.
     * @param entrada : objeto que nos permite leer la entrada de consola.
     * @return pensum : Pensum|null.
     */
    public static Pensum crearPensum() {
        LinkedList<Semestre> semestres = new LinkedList<>();
        Pensum pensum = null;

        try {
            boolean crearSemestres = true;
            do {
                Utilidades.limpiar();
                semestres.push(creaSemestre());
                System.out.print("¿Otro semestre?(1:si|0:no) = ");
                crearSemestres = (entrada.nextByte() == 1)? true : false;
                entrada.nextLine();
            } while (crearSemestres);
            Utilidades.limpiar();
    
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
     * @param entrada : objeto que nos permite leer la entrada de consola.
     * @return semestre : Semestre|null.
     */
    public static Semestre creaSemestre() {
        Semestre semestre = null;

        try {
            System.out.println("[Creando Semestre]");
            System.out.print("Semestre = ");
            byte numeroSmt = entrada.nextByte();
            entrada.nextLine();
            System.out.print("Periodo = ");
            String periodoSmt = entrada.nextLine();
            Utilidades.limpiar();
            
            boolean crearMaterias = true;
            LinkedList<Materia> materias = new LinkedList<>();
            do{
                Utilidades.limpiar();
                materias.push(creaMateria());
                System.out.print("¿Otra materia?(1:si|0:no) = ");
                byte res = entrada.nextByte();
                crearMaterias = (res == 1)? true : false;
                entrada.nextLine();
            } while(crearMaterias);
            Utilidades.limpiar();
    
            semestre = new Semestre(numeroSmt, periodoSmt, materias);
            return semestre;
        } catch (SemestreVacio semestreVacio) {
            semestreVacio.printStackTrace();
        }
        return semestre;
    }

    private static LinkedList<Materia> pedirRequisitos () {
        do {
            System.out.print("Requisitos(separados por comas si es más de uno) = ");
            String codigosReq = entrada.nextLine();
            if(codigosReq.isBlank()) {
                break;
            }

            String[] aux = Utilidades.fragmentarCadenas(codigosReq, ",");
            LinkedList<Materia> materiasReq = new LinkedList<>();
            try {
                for (String codigoReq : aux) {
                    Materia materiaObj = Buscador.buscarMateria(codigoReq, pensumBase);
                    if (materiaObj != null) {
                        materiasReq.add(materiaObj);
                    } else {
                        throw new MateriaInexistente();
                    }
                }
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Intente de nuevo...");
            }
        } while (true);
        return null;
    }

    /**
     * Pide los datos necesarios por consola para crear una materia. Si sucede un
     * error se retornara un null.
     * @param entrada : objeto que nos permite leer la entrada de consola.
     * @return materia : Materia|null.
     */
    public static Materia creaMateria() {
        Materia materia = null;

        try {
            System.out.println("[Creando Materia]");
            System.out.print("Codigo = ");
            String codigo = entrada.nextLine();
            System.out.print("Nombre = ");
            String nombre = entrada.nextLine();
            System.out.print("Creditos = ");
            byte creditos = entrada.nextByte();
            entrada.nextLine();

            LinkedList<Materia> requisitos = pedirRequisitos();
            System.out.print("Estado(1:Cursada, 2:No cursada, 3:Perdida) = ");
            String estadoRes = entrada.nextLine();
            EstadoMateria estado;
            switch(estadoRes){
                case "1":
                    estado = EstadoMateria.CURSADA;
                    break;
                case "2":
                    estado = EstadoMateria.NOCURSADA;
                    break;
                case "3":
                    estado = EstadoMateria.PERDIDA;
                    break;
                default:
                    estado = EstadoMateria.NOCURSADA;
                    break;
            }

            materia = new Materia(codigo, nombre, creditos, requisitos, estado);
            return materia;
        } catch (MateriaIncompleta materiaIncompleta) {
            materiaIncompleta.printStackTrace();
        }
        return materia;
    }
}