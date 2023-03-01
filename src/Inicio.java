import java.util.Scanner;

import modelos.Materia;

public class Inicio {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Inicio Organizador de Pensum.");
        String codigo;
        String nombre;
        byte creditos;
        Scanner lector = new Scanner(System.in);

        System.out.println("codigo");
        codigo = lector.nextLine();
        System.out.println("nombre");
        nombre = lector.nextLine();
        System.out.println("creditos");
        creditos = lector.nextByte();

        lector.close();
        Materia materia = new Materia(codigo, nombre, creditos, null);
        System.out.println(materia);
    }
}