package excepciones;

public class MateriaIncompleta extends Exception {

    public MateriaIncompleta() {
        super("No se puede crear una materia sin codigo o nombre, los dos son necesarios.");
    }
}
