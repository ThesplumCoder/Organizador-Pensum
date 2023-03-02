package utilidades;

public abstract class LimpiarPantalla {
    
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
}