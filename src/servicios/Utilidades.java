package servicios;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

import modelos.Materia;

public class Utilidades {
    private static Scanner lector = new Scanner(System.in);

    /**
     * Cierra la entrada por teclado.
     */
    public static void cerrarLector () {
        lector.close();
    }
    
    /**
     * Utilidad que nos permite leer cadenas escritas por teclado.
     * @return Retorna la cadena que se leyó del teclado, si ocurre un error retorna null.
     */
    public static String leer () {
        String res = null;
        try {
            res = lector.nextLine();
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error mientras leía");
        }
        return res;
    }

    public static void limpiar() {
        try {
            String os = System.getProperty("os.name");
            if(os.contains("Windows")) {
                String[] comandos = {"cls"};
                new ProcessBuilder(comandos).inheritIO().start().waitFor(); 
            } else {
                String[] comandos = {"clear"};
                new ProcessBuilder(comandos).inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static String normalizarDatos(String dato) {
        int diferencia = (Materia.darCaracteresMaximos() + 1) - dato.length();
        if(diferencia != 0) {
            StringBuilder aux = new StringBuilder();
            for(int i = 1; i <= diferencia; i++) {
                aux.append(" ");
            }
            return dato.concat(new String(aux));
        }
        return dato;
    }

    /**
     * Separa la cadena en varias cadenas siguiendo como regla que cada cadena está separada por el
     * delimitador.
     * @param cadena Cadena que se va a dividir.
     * @param delimitador Cadena que indica que símbolo va a ser el delimitador.
     * @return Arreglo con las cadenas encontradas después de haberlas dividido por el delimitador.
     */
    public static String[] fragmentarCadenas(String cadena, String delimitador) {
        String[] res = null;
        try {
            res = cadena.split(delimitador);
        } catch (PatternSyntaxException pse) {
            System.out.println("El delimitador no es válido.");
        }
        return res;
    }
}