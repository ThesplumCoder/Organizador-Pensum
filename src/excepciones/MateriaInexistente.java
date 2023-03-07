package excepciones;

public class MateriaInexistente extends RuntimeException {
    
    public MateriaInexistente () {
        super("Esta materia no existe.");
    }
}
