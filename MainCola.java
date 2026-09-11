public class MainCola {

    public static void main(String[] args) {
        System.out.println("=== Prueba con ColaVarianteA ===");
        probar(new ColaVarianteA<>(100), new ColaVarianteA<>(100));

        System.out.println("\n=== Prueba con ColaVarianteB ===");
        probar(new ColaVarianteB<>(100), new ColaVarianteB<>(100));
    }

    private static void probar(Cola<Integer> c1, Cola<Integer> c2) {
        int[] valoresC1 = {10, 20, 30, 40, 50};
        int[] valoresC2 = {99, 88, 77, 40, 50};
        for (int v : valoresC1) c1.encolar(v);
        for (int v : valoresC2) c2.encolar(v);

        System.out.println("c1 original: " + imprimir(c1));
        System.out.println("c2 original: " + imprimir(c2));

        
        Cola<Integer> copiaParaInvertir = pasarloA(c1); 
        Cola<Integer> invertida = UtilizacionCola.invertirColaConPila(copiaParaInvertir, 100);
        System.out.println("invertida (con pila) de c1: " + imprimir(invertida));

       
        for (int v : valoresC1) c1.encolar(v);

      
        Cola<Integer> pasada = UtilizacionCola.pasarCola(c1, 100);
        System.out.println("pasada (misma orden) desde c1: " + imprimir(pasada));
        System.out.println("c1 queda vacía tras pasarCola: " + c1.esVacia());

        
        for (int v : valoresC1) c1.encolar(v);

        
        Cola<Integer> mismaC1 = UtilizacionCola.invertirColaSinPila(c1);
        System.out.println("c1 invertida sin pila: " + imprimir(mismaC1));
       
        c1 = new ColaVarianteA<>(100);
        for (int v : valoresC1) c1.encolar(v);

       
        boolean coincideK2 = UtilizacionCola.finalCoincide(c1, c2, 2, 100);
        System.out.println("finalCoincide(c1, c2, k=2) [últimos 2 de ambas: 40,50 -> deberían coincidir]: " + coincideK2);
        System.out.println("c1 tras finalCoincide: " + imprimir(c1));
        System.out.println("c2 tras finalCoincide: " + imprimir(c2));

        boolean coincideK3 = UtilizacionCola.finalCoincide(c1, c2, 3, 100);
        System.out.println("finalCoincide(c1, c2, k=3) [c1: 30,40,50 vs c2: 77,40,50 -> deberían diferir]: " + coincideK3);

        boolean coincideK10 = UtilizacionCola.finalCoincide(c1, c2, 10, 100);
        System.out.println("finalCoincide(c1, c2, k=10) [no hay 10 elementos]: " + coincideK10);
    }

    private static Cola<Integer> pasarloA(Cola<Integer> origen) {
        Cola<Integer> destino = new ColaVarianteA<>(100);
        while (!origen.esVacia()) {
            destino.encolar(origen.frente());
            origen.desencolar();
        }
        return destino;
    }

    
    private static String imprimir(Cola<Integer> c) {
        Cola<Integer> aux = new ColaVarianteA<>(20);
        StringBuilder sb = new StringBuilder("[frente: ");
        while (!c.esVacia()) {
            Integer x = c.frente();
            c.desencolar();
            sb.append(x).append(" ");
            aux.encolar(x);
        }
        sb.append(": fin]");
        while (!aux.esVacia()) {
            c.encolar(aux.frente());
            aux.desencolar();
        }
        return sb.toString();
    }
}
