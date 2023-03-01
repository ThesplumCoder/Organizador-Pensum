package modelos;

public class Semestre {
    private byte numero;
    private String periodo;
    private Materia[] materias;

    public Semestre(byte numero, String periodo, Materia[] materias) {
        this.numero = numero;
        this.periodo = periodo;
        this.materias = materias;
    }
}
