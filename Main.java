public class Main {

    public static void main(String[] args) {
        System.out.println("=== Prueba con PilaVarianteA ===");
        probar(new PilaVarianteA<>(10));

        System.out.println("\n=== Prueba con PilaVarianteB ===");
        probar(new PilaVarianteB<>(10));
    }

    private static void probar(Pila<Integer> p) {
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        p.apilar(2);
        p.apilar(4);
        

        Pila<Integer> copia = Utilizacion.copiarPila(p, 10);
        System.out.println("p sigue igual tras copiar: " + imprimir(p));
        System.out.println("copia: " + imprimir(copia));

        Pila<Integer> invertida = Utilizacion.invertirPila(p, 10);
        System.out.println("invertida: " + imprimir(invertida));
        System.out.println("p sigue igual tras invertir: " + imprimir(p));

        boolean repetidos = Utilizacion.masDeUnaOcurrencia(p, 10);
        System.out.println("¿tiene repetidos?: " + repetidos);
        System.out.println("p sigue igual tras la consulta: " + imprimir(p));

        Pila<Integer> pares = Utilizacion.eliminarImpares(p, 10);
        System.out.println("pares (mismo orden relativo): " + imprimir(pares));
        System.out.println("p sigue igual tras eliminarImpares: " + imprimir(p));

        Pila<Integer> pasada = Utilizacion.pasarPila(p, 10);
        System.out.println("pasada: " + imprimir(pasada));
        System.out.println("p debe quedar vacía tras pasarPila: " + p.esVacia());
    }

    
    private static String imprimir(Pila<Integer> p) {
        Pila<Integer> aux = new PilaVarianteA<>(20);
        StringBuilder sb = new StringBuilder("[tope: ");
        while (!p.esVacia()) {
            Integer x = p.tope();
            p.desapilar();
            sb.append(x).append(" ");
            aux.apilar(x);
        }
        sb.append(": fondo]");
        while (!aux.esVacia()) {
            p.apilar(aux.tope());
            aux.desapilar();
        }
        return sb.toString();
    }
}
