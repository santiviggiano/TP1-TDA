public class ColaPrioridadVarianteA<T> implements ColaPrioridad<T> {

    private final Object[] elementos; 
    private int cantidad;

    public ColaPrioridadVarianteA(int capacidad) {
        elementos = new Object[capacidad];
        cantidad = 0;
    }

    @Override
    public void insertar(T elemento, int prioridad) {
        if (cantidad == elementos.length) {
            throw new RuntimeException("La cola de prioridad está llena");
        }
        elementos[cantidad] = new ElementoConPrioridad<>(elemento, prioridad);
        cantidad++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ElementoConPrioridad<T> extraerMax() {
        if (esVacia()) {
            throw new RuntimeException("La cola de prioridad está vacía");
        }
        int mejor = indiceDelMaximo();
        ElementoConPrioridad<T> resultado = (ElementoConPrioridad<T>) elementos[mejor];
        for (int i = mejor; i < cantidad - 1; i++) {
            elementos[i] = elementos[i + 1]; 
        }
        cantidad--;
        elementos[cantidad] = null;
        return resultado;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ElementoConPrioridad<T> verMax() {
        if (esVacia()) {
            throw new RuntimeException("La cola de prioridad está vacía");
        }
        return (ElementoConPrioridad<T>) elementos[indiceDelMaximo()];
    }

    @Override
    public boolean esVacia() {
        return cantidad == 0;
    }

    @SuppressWarnings("unchecked")
    private int indiceDelMaximo() {
        int mejor = 0;
        int mejorPrioridad = ((ElementoConPrioridad<T>) elementos[0]).getPrioridad();
        for (int i = 1; i < cantidad; i++) {
            int p = ((ElementoConPrioridad<T>) elementos[i]).getPrioridad();
            if (p > mejorPrioridad) { 
                mejor = i;
                mejorPrioridad = p;
            }
        }
        return mejor;
    }
}
