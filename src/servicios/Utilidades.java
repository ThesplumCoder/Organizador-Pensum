package servicios;

import modelos.Materia;

public class Utilidades {
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
}