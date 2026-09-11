public class Utilizacion {

    
    public static <T> Pila<T> pasarPila(Pila<T> origen, int capacidad) {
        if (origen.esVacia()) {
            return new PilaVarianteA<>(capacidad);
        }
        T x = origen.tope();
        origen.desapilar();
        Pila<T> resto = pasarPila(origen, capacidad);
        resto.apilar(x);
        return resto;
    }

   
    public static <T> Pila<T> copiarPila(Pila<T> p, int capacidad) {
        if (p.esVacia()) {
            return new PilaVarianteA<>(capacidad);
        }
        T x = p.tope();
        p.desapilar();
        Pila<T> copia = copiarPila(p, capacidad);
        p.apilar(x);     
        copia.apilar(x);  
        return copia;
    }

    
    public static <T> Pila<T> invertirPila(Pila<T> p, int capacidad) {
        Pila<T> copia = copiarPila(p, capacidad);
        invertirEnLugar(copia);
        return copia;
    }

    private static <T> void invertirEnLugar(Pila<T> pila) {
        if (!pila.esVacia()) {
            T x = pila.tope();
            pila.desapilar();
            invertirEnLugar(pila);
            insertarAlFondo(pila, x);
        }
    }

    private static <T> void insertarAlFondo(Pila<T> pila, T x) {
        if (pila.esVacia()) {
            pila.apilar(x);
        } else {
            T y = pila.tope();
            pila.desapilar();
            insertarAlFondo(pila, x);
            pila.apilar(y);
        }
    }

    
    public static <T> boolean masDeUnaOcurrencia(Pila<T> p, int capacidad) {
        Pila<T> copia = copiarPila(p, capacidad);
        return tieneRepetidos(copia);
    }

    private static <T> boolean tieneRepetidos(Pila<T> pila) {
        if (pila.esVacia()) {
            return false;
        }
        T x = pila.tope();
        pila.desapilar();
        boolean repetido = contiene(pila, x) || tieneRepetidos(pila);
        pila.apilar(x); 
        return repetido;
    }

    private static <T> boolean contiene(Pila<T> pila, T x) {
        if (pila.esVacia()) {
            return false;
        }
        T y = pila.tope();
        pila.desapilar();
        boolean encontrado = x.equals(y) || contiene(pila, x);
        pila.apilar(y); 
        return encontrado;
    }

    
    public static Pila<Integer> eliminarImpares(Pila<Integer> p, int capacidad) {
        Pila<Integer> copia = copiarPila(p, capacidad);
        return filtrarPares(copia, capacidad);
    }

    private static Pila<Integer> filtrarPares(Pila<Integer> pila, int capacidad) {
        if (pila.esVacia()) {
            return new PilaVarianteA<>(capacidad);
        }
        Integer x = pila.tope();
        pila.desapilar();
        Pila<Integer> resto = filtrarPares(pila, capacidad);
        if (x % 2 == 0) {
            resto.apilar(x);
        }
        return resto;
    }
}
