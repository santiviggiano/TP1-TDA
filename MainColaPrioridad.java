public class MainColaPrioridad {

    public static void main(String[] args) {
        System.out.println("=== Prueba con ColaPrioridadVarianteA ===");
        probar(new ColaPrioridadVarianteA<>(20), new ColaPrioridadVarianteA<>(20));

        System.out.println("\n=== Prueba con ColaPrioridadVarianteB ===");
        probar(new ColaPrioridadVarianteB<>(20), new ColaPrioridadVarianteB<>(20));
    }

    private static void probar(ColaPrioridad<Integer> cp1, ColaPrioridad<Integer> cp2) {
       
        cp1.insertar(100, 5); 
        cp1.insertar(200, 5); 
        cp1.insertar(300, 3);

        System.out.println("Orden de extracción de cp1 (se espera 100, 200, 300):");
        System.out.println("  verMax: " + cp1.verMax());
        System.out.println("  extraerMax 1: " + cp1.extraerMax());
        System.out.println("  extraerMax 2: " + cp1.extraerMax());
        System.out.println("  extraerMax 3: " + cp1.extraerMax());

        
        cp1.insertar(100, 5);
        cp1.insertar(200, 5);
        cp1.insertar(300, 3);

       
        cp1.insertar(400, 8);
        cp1.insertar(500, 8); 
        int suma = UtilizacionColaPrioridad.sumarValoresPrioridadPar(cp1, 20);
        System.out.println("\nsumarValoresPrioridadPar(cp1) [debería ser 400+500=900]: " + suma);

        System.out.println("Orden de extracción de cp1 TRAS sumarValoresPrioridadPar");
        System.out.println("(debe seguir siendo el mismo orden que si nunca hubiéramos llamado al método:");
        System.out.println(" 400, 500, 100, 200, 300 -> el desempate 400 antes que 500 debe conservarse):");
        while (!cp1.esVacia()) {
            System.out.println("  extraerMax: " + cp1.extraerMax());
        }

        
        cp1.insertar(1, 10);
        cp1.insertar(2, 10);
        cp2.insertar(3, 10); 
        cp2.insertar(4, 1);
        ColaPrioridad<Integer> combinada = UtilizacionColaPrioridad.combinar(cp1, cp2, 20);
        System.out.println("\ncombinar(cp1, cp2) -> orden de extracción (se espera 1, 2, 3, 4):");
        while (!combinada.esVacia()) {
            System.out.println("  extraerMax: " + combinada.extraerMax());
        }
        System.out.println("cp1 vacía tras combinar: " + cp1.esVacia());
        System.out.println("cp2 vacía tras combinar: " + cp2.esVacia());

        
        Cola<Integer> c = new ColaVarianteA<>(10);
        c.encolar(10);
        c.encolar(20);
        c.encolar(30);
        Cola<Integer> invertida = UtilizacionColaPrioridad.invertirColaConColaPrioridad(c, 10);
        System.out.print("\ninvertirColaConColaPrioridad([10,20,30]) -> ");
        while (!invertida.esVacia()) {
            System.out.print(invertida.frente() + " ");
            invertida.desencolar();
        }
        System.out.println("(se espera 30 20 10)");
    }
}
