package interfaz;

import java.util.LinkedList;
import excepciones.MateriaInexistente;
import inicio.Inicio;
import modelos.EstadoMateria;
import modelos.Materia;
import servicios.Utilidades;
import servicios.Buscador;

/**
 * Se encargar de pedir y validar los datos necesarios para crear una materia.
 * @author ThesplumCoder
 */
public abstract class CrearMateria {

    private static String pedirCodigo () {
        String codigo = null;
        do {
            System.out.print("Codigo = ");
            codigo = Utilidades.leer();

            try {
                // Validación si el código no está en el pensum.
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Intente de nuevo...");
            }
        } while (true);
        return codigo;
    }

    private static byte pedirCreditos () {
        byte creditos = 0;
        do {
            System.out.print("Créditos = ");
            String res = Utilidades.leer();
            try {
                creditos = Byte.parseByte(res);
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Intente de nuevo...");
            }
        } while (true);
        return creditos;
    }

    private static EstadoMateria pedirEstado () {
        EstadoMateria estado = null;
        System.out.print("Estado(1:Cursada, 2:No cursada, 3:Perdida) = ");
        String estadoRes = Utilidades.leer();
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
        return estado;
    }

    private static LinkedList<Materia> pedirRequisitos () {
        LinkedList<Materia> materiasReq = null;
        do {
            System.out.print("Requisitos(separados por comas si es más de uno) = ");
            String codigosReq = Utilidades.leer();
            if(codigosReq.isBlank()) {
                break;
            }

            String[] aux = Utilidades.fragmentarCadenas(codigosReq, ",");
            materiasReq = new LinkedList<>();
            try {
                for (String codigoReq : aux) {
                    Materia materiaObj = Buscador.buscarMateria(codigoReq, Inicio.pensumBase);
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
        return materiasReq;
    }

    /**
     * Pide los datos necesarios por consola para crear una materia. Si sucede un
     * error se retornara un null.
     * @param entrada : objeto que nos permite leer la entrada de consola.
     * @return materia : Materia|null.
     */
    public static Materia crea () {
        Materia materia = null;
        do {
            try {
                System.out.println("[Creando Materia]");
                String codigo = pedirCodigo();
                System.out.print("Nombre = ");
                String nombre = Utilidades.leer();
                byte creditos = pedirCreditos();
                LinkedList<Materia> requisitos = pedirRequisitos();
                EstadoMateria estado = pedirEstado();
    
                materia = new Materia(codigo, nombre, creditos, requisitos, estado);
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Intente de nuevo...");
            }
        } while (true);
        return materia;
    }
}
