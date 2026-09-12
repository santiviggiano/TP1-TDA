public class ColaPrioridadVarianteB<T> implements ColaPrioridad<T> {

    private final Object[] elementos;
    private int cantidad;

    public ColaPrioridadVarianteB(int capacidad) {
        elementos = new Object[capacidad];
        cantidad = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insertar(T elemento, int prioridad) {
        if (cantidad == elementos.length) {
            throw new RuntimeException("La cola de prioridad está llena");
        }
        int i = cantidad - 1;
        while (i >= 0 && ((ElementoConPrioridad<T>) elementos[i]).getPrioridad() >= prioridad) {
            elementos[i + 1] = elementos[i];
            i--;
        }
        elementos[i + 1] = new ElementoConPrioridad<>(elemento, prioridad);
        cantidad++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ElementoConPrioridad<T> extraerMax() {
        if (esVacia()) {
            throw new RuntimeException("La cola de prioridad está vacía");
        }
        cantidad--;
        ElementoConPrioridad<T> resultado = (ElementoConPrioridad<T>) elementos[cantidad];
        elementos[cantidad] = null;
        return resultado;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ElementoConPrioridad<T> verMax() {
        if (esVacia()) {
            throw new RuntimeException("La cola de prioridad está vacía");
        }
        return (ElementoConPrioridad<T>) elementos[cantidad - 1];
    }

    @Override
    public boolean esVacia() {
        return cantidad == 0;
    }
}
