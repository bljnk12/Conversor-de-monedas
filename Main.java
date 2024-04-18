
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Divisa> listaDeConversiones;
        listaDeConversiones = new ArrayList<>();
        Scanner proceso = new Scanner(System.in);

        int salir = 2;
        while (salir != 1) {
            Scanner moneda = new Scanner(System.in);
            ConsultaDivisa consulta = new ConsultaDivisa();

            System.out.print("Escriba el codigo de una divisa: ");
            var monedaLocal = String.valueOf(moneda.nextLine());
            System.out.print("Escriba el codigo de la divisa a la que desea hacer la conversion: ");
            var monedaExt = String.valueOf(moneda.nextLine());
            System.out.print("Escriba la cantidad que desea convertir: ");
            double cantidad = moneda.nextDouble();

            try {
                Divisa divisa = consulta.buscaDivisa(monedaLocal, monedaExt);
                listaDeConversiones.add(divisa);

                double total = cantidad * divisa.conversion_rate();
                DecimalFormat df = new DecimalFormat("#.00");
                double totalF  = Double.parseDouble(df.format(total));

                System.out.println(divisa+""+cantidad+" "+divisa.base_code()+" es igual a "+totalF+" "+divisa.target_code());
                System.out.println("Escriba 1 para salir y ver el historial de conversiones o 2 para hacer otra conversion");
                salir = proceso.nextInt();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("no funciono");
            }

        }

        String listString = listaDeConversiones.stream().map(Object::toString)
                .collect(Collectors.joining());
        System.out.println(listString);
    }

}




