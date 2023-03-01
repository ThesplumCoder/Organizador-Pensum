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

    public String toString() {
        StringBuilder datos = new StringBuilder();
        datos.append(this.numero + ", ");
        datos.append(this.periodo + ", ");
        for (Materia materia : this.materias) {
            datos.append(materia + ";");
        }
        datos.append(".");
        return new String(datos);
    }
}
