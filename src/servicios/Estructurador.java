package servicios;

import modelos.Pensum;

public abstract class Estructurador {
    /**
     * Esta variable guarda el pensum base sobre el que se va a trabajar.
     */
    static Pensum pensumBase;

    public static Pensum estructurar(Pensum pensum) {
        Estructurador.pensumBase = pensum;
        return pensumBase;
    }

}
