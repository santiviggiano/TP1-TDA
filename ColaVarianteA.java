public class ColaVarianteA<T> implements Cola<T> {

    private final Object[] datos;
    private int frenteIdx; 
    private int cantidad;  

    public ColaVarianteA(int capacidad) {
        datos = new Object[capacidad];
        frenteIdx = 0;
        cantidad = 0;
    }

    @Override
    public void encolar(T elemento) {
        int finIdx = frenteIdx + cantidad;
        if (finIdx == datos.length) {
            throw new RuntimeException("La cola está llena");
        }
        datos[finIdx] = elemento;
        cantidad++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T desencolar() {
        if (esVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        T elemento = (T) datos[frenteIdx];
        datos[frenteIdx] = null;
        frenteIdx++;   
        cantidad--;
        return elemento;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T frente() {
        if (esVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        return (T) datos[frenteIdx];
    }

    @Override
    public boolean esVacia() {
        return cantidad == 0;
    }
}
