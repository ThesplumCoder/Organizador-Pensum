package inicio;

import excepciones.PensumVacio;
import interfaz.CrearSemestre;
import modelos.*;
import servicios.Utilidades;

public abstract class Inicio {
    public static Pensum pensumBase = null;

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
            String aux = Utilidades.leer();
            try {
                respuesta = Byte.parseByte(aux);
                Utilidades.limpiar();
            } catch (Exception e) {
                e.printStackTrace();
                respuesta = 5;
            }

            switch(respuesta){
                case 1:
                    crearPensum();
                    break;
                case 3:
                    if (pensumBase == null) {
                        System.out.println("No hay pensum aún.");
                        System.out.print("Salir...");
                        String salir = Utilidades.leer();
                    } else {
                        System.out.print(pensumBase);
                        System.out.print("Salir...");
                        String salir = Utilidades.leer();
                    }
                    break;
                case 5:
                    System.out.println("Cerrando organizador.");
                    break;
                default:
                    break;
            }
        } while (respuesta != 5);
        Utilidades.cerrarLector();
    }

    /**
     * Pide los datos necesarios por consola para crear un pensum.
     * @return Retorna un pensum hecho, si sucede un error retorna null.
     */
    public static void crearPensum() {
        try {
            Semestre semestre = null;
            boolean crearSmts = false;
            
            Utilidades.limpiar();
            semestre = CrearSemestre.crea();
            System.out.print("¿Otro semestre?(1:si|0:no) = ");
            crearSmts = (Utilidades.leer().equals("1"))? true : false;
            Utilidades.limpiar();
            pensumBase = new Pensum(semestre);
            
            while (crearSmts) {
                Utilidades.limpiar();
                semestre = CrearSemestre.crea();
                pensumBase.agregaSemestre(semestre);
                System.out.print("¿Otro semestre?(1:si|0:no) = ");
                crearSmts = (Utilidades.leer().equals("1"))? true : false;
            }
            
            Utilidades.limpiar();
        } catch (PensumVacio pV) {
            System.out.println(pV.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}