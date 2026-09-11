
public interface Cola<T> {

    void encolar(T elemento);
  
    T desencolar();
  
    T frente();

    boolean esVacia();
}
