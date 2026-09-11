public class PilaEstaticaA implements Pila {

    private int[] datos;
    private int capacidad;
    private int tope;

    public PilaEstaticaA(int capacidad) {
        this.datos = new int[capacidad];
        this.capacidad = capacidad;
        this.tope = -1;
    }

    @Override
    public void apilar(int elemento) {
        if (!esLlena()) {
            tope++;
            datos[tope] = elemento;
        }
    }

    @Override
    public int desapilar() {
        if (!esVacia()) {
            int elemento = datos[tope];
            tope--;
            return elemento;
        }

        throw new IllegalStateException("La pila está vacía");
    }

    @Override
    public int tope() {
        if (!esVacia()) {
            return datos[tope];
        }

        throw new IllegalStateException("La pila está vacía");
    }

    @Override
    public boolean esVacia() {
        return tope == -1;
    }

    @Override
    public boolean esLlena() {
        return tope == capacidad - 1;
    }
}
