import com.JairoOntiveros.conversor.modelos.ConversionFinal;
import com.JairoOntiveros.conversor.servicios.APIService;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        APIService apiservice = new APIService();

        int opcion;
        do {
            System.out.println("***************************************************");
            System.out.println("Bienvenidos al Conversor de Monedas");
            System.out.println("***************************************************");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("***************************************************");

            System.out.print("Elija una opción válida: ");
            opcion = entrada.nextInt();

            String base = "";
            String objetivo = "";

            switch (opcion) {
                case 1 -> {
                    base = "USD";
                    objetivo = "ARS";
                }
                case 2 -> {
                    base = "ARS";
                    objetivo = "USD";
                }
                case 3 -> {
                    base = "USD";
                    objetivo = "BRL";
                }
                case 4 -> {
                    base = "BRL";
                    objetivo = "USD";
                }
                case 5 -> {
                    base = "USD";
                    objetivo = "COP";
                }
                case 6 -> {
                    base = "COP";
                    objetivo = "USD";
                }
                case 7 -> {
                    System.out.println("¡Gracias por usar el conversor!");
                    break;
                }
                default -> {
                    System.out.println("Opción inválida. Intente de nuevo.\n");
                    continue;
                }
            }
            if (opcion >=1 && opcion <= 6){
                System.out.println("Ingrese la cantidad a convertir: ");
                double cantidad = entrada.nextDouble();
                if(cantidad < 0){
                    System.out.println("La cantidad no puede sernegativa. Intente nuevamente");
                    continue;
                }

                try{
                    ConversionFinal resultado = apiservice.Convertir(base,objetivo,cantidad);
                    System.out.println("\n=== Resultado de la Conversión ===");
                    System.out.printf("De %s a %s: %.2f => %.2f\n", base, objetivo, cantidad, resultado.resultadoConversion());
                    System.out.println("Fecha de la tasa: " + resultado.fechaES() + "\n");
                }catch (RuntimeException e){
                    System.out.println("Ocurrio un error: "+e.getMessage());
                }
            }
        } while(opcion !=7);
    }
}
