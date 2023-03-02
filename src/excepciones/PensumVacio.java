package excepciones;

public class PensumVacio extends Exception {
    
    public PensumVacio() {
        super("Un pensum no puede estar vacio.");
    }
}
