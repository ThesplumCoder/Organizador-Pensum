package excepciones;

public class SemestreVacio extends Exception {
    
    public SemestreVacio() {
        super("No se puede crear un semestre sin tener al menos una materia.");
    }
}
