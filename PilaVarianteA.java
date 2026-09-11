public class PilaVarianteA<T> implements Pila<T> {

    private final Object[] datos;
    private int cantidad;

    public PilaVarianteA(int capacidad) {
        datos = new Object[capacidad];
        cantidad = 0;
    }

    @Override
    public void apilar(T elemento) {
        if (cantidad == datos.length) {
            throw new RuntimeException("La pila está llena");
        }
        datos[cantidad] = elemento;
        cantidad++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T desapilar() {
        if (esVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        cantidad--;
        T elemento = (T) datos[cantidad];
        datos[cantidad] = null; // evita retener la referencia innecesariamente
        return elemento;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T tope() {
        if (esVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        return (T) datos[cantidad - 1];
    }

    @Override
    public boolean esVacia() {
        return cantidad == 0;
    }
}
