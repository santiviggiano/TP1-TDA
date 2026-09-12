
public class UtilizacionColaPrioridad {

  
    public static <T> ColaPrioridad<T> combinar(ColaPrioridad<T> cp1, ColaPrioridad<T> cp2, int capacidad) {
        ColaPrioridad<T> resultado = new ColaPrioridadVarianteA<>(capacidad);
        trasladarTodo(cp1, resultado);
        trasladarTodo(cp2, resultado);
        return resultado;
    }

    private static <T> void trasladarTodo(ColaPrioridad<T> origen, ColaPrioridad<T> destino) {
        if (origen.esVacia()) {
            return;
        }
        ElementoConPrioridad<T> x = origen.extraerMax();
        destino.insertar(x.getElemento(), x.getPrioridad());
        trasladarTodo(origen, destino);
    }

  
    public static <T> Cola<T> invertirColaConColaPrioridad(Cola<T> c, int capacidad) {
        ColaPrioridad<T> cp = new ColaPrioridadVarianteA<>(capacidad);
        int prioridad = 1;
        while (!c.esVacia()) {
            T x = c.frente();
            c.desencolar();
            cp.insertar(x, prioridad);
            prioridad++;
        }
        Cola<T> invertida = new ColaVarianteA<>(capacidad);
        while (!cp.esVacia()) {
            invertida.encolar(cp.extraerMax().getElemento());
        }
        return invertida;
    }

   
    public static int sumarValoresPrioridadPar(ColaPrioridad<Integer> cp, int capacidad) {
        Cola<ElementoConPrioridad<Integer>> extraidos = new ColaVarianteA<>(capacidad);
        int suma = 0;
        while (!cp.esVacia()) {
            ElementoConPrioridad<Integer> actual = cp.extraerMax();
            extraidos.encolar(actual);
            if (actual.getPrioridad() % 2 == 0) {
                suma += actual.getElemento();
            }
        }
        while (!extraidos.esVacia()) {
            ElementoConPrioridad<Integer> actual = extraidos.desencolar();
            cp.insertar(actual.getElemento(), actual.getPrioridad());
        }
        return suma;
    }
}
