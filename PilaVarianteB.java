public class PilaVarianteB<T> implements Pila<T> {

    private final Object[] datos;
    private int cantidad;

    public PilaVarianteB(int capacidad) {
        datos = new Object[capacidad];
        cantidad = 0;
    }

    @Override
    public void apilar(T elemento) {
        if (cantidad == datos.length) {
            throw new RuntimeException("La pila está llena");
        }
        for (int i = cantidad; i > 0; i--) {
            datos[i] = datos[i - 1];
        }
        datos[0] = elemento;
        cantidad++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T desapilar() {
        if (esVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        T elemento = (T) datos[0];
        for (int i = 0; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1];
        }
        cantidad--;
        datos[cantidad] = null;
        return elemento;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T tope() {
        if (esVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        return (T) datos[0];
    }

    @Override
    public boolean esVacia() {
        return cantidad == 0;
    }
}
