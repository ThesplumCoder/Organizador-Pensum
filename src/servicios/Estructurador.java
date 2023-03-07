package servicios;

import modelos.Pensum;

public abstract class Estructurador {
    private static Pensum pensumBase;

    public static Pensum estructurar(Pensum pensum) {
        Estructurador.pensumBase = pensum;
        return pensumBase;
    }

}
