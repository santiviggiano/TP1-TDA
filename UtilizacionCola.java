public class UtilizacionCola {

   
    public static <T> Cola<T> pasarCola(Cola<T> origen, int capacidad) {
        Cola<T> destino = new ColaVarianteA<>(capacidad);
        pasarColaAux(origen, destino);
        return destino;
    }

    private static <T> void pasarColaAux(Cola<T> origen, Cola<T> destino) {
        if (origen.esVacia()) {
            return;
        }
        T x = origen.frente();
        origen.desencolar();
        destino.encolar(x); 
        pasarColaAux(origen, destino);
    }

    
    public static <T> Cola<T> invertirColaConPila(Cola<T> c, int capacidad) {
        Pila<T> pila = new PilaVarianteA<>(capacidad);
        while (!c.esVacia()) {
            pila.apilar(c.frente());
            c.desencolar();
        }
        Cola<T> invertida = new ColaVarianteA<>(capacidad);
        while (!pila.esVacia()) {
            invertida.encolar(pila.tope());
            pila.desapilar();
        }
        return invertida;
    }

    
    public static <T> Cola<T> invertirColaSinPila(Cola<T> c) {
        invertirRec(c);
        return c;
    }

    private static <T> void invertirRec(Cola<T> c) {
        if (c.esVacia()) {
            return;
        }
        T x = c.frente();
        c.desencolar();
        invertirRec(c);   
        c.encolar(x);     
    }

    
    public static <T> boolean finalCoincide(Cola<T> c1, Cola<T> c2, int k, int capacidad) {
        if (k <= 0) {
            return true;
        }
        Cola<T> ultimosC1 = ultimosK(c1, k, capacidad);
        Cola<T> ultimosC2 = ultimosK(c2, k, capacidad);
        if (ultimosC1 == null || ultimosC2 == null) {
            return false;
        }
        boolean coincide = true;
        while (!ultimosC1.esVacia()) {
            T x1 = ultimosC1.frente();
            ultimosC1.desencolar();
            T x2 = ultimosC2.frente();
            ultimosC2.desencolar();
            if (!x1.equals(x2)) {
                coincide = false;
            }
        }
        return coincide;
    }

    
    private static <T> Cola<T> ultimosK(Cola<T> c, int k, int capacidad) {
        Pila<T> pila = new PilaVarianteA<>(capacidad);
        int n = 0;
        while (!c.esVacia()) {
            pila.apilar(c.frente());
            c.desencolar();
            n++;
        }
        

        if (k > n) {
            restaurarColaDesdePila(pila, c, capacidad);
            return null;
        }

        Pila<T> guardado = new PilaVarianteA<>(k);
        for (int i = 0; i < k; i++) {
            guardado.apilar(pila.tope());
            pila.desapilar();
        }
        

        Cola<T> resultado = new ColaVarianteA<>(k);
        while (!guardado.esVacia()) {
            T x = guardado.tope();
            guardado.desapilar();
            resultado.encolar(x);
                                   
            pila.apilar(x);       
                                   
        }

        restaurarColaDesdePila(pila, c, capacidad);
        return resultado;
    }

    
    private static <T> void restaurarColaDesdePila(Pila<T> pila, Cola<T> c, int capacidad) {
        Pila<T> pila2 = new PilaVarianteA<>(capacidad);
        while (!pila.esVacia()) {
            pila2.apilar(pila.tope());
            pila.desapilar();
        }
        while (!pila2.esVacia()) {
            c.encolar(pila2.tope());
            pila2.desapilar();
        }
    }
}
