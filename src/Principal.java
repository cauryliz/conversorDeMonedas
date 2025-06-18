import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

            String apiKey = "a800616b3750baeace9c28f7";
            Scanner scanner = new Scanner(System.in);
            int opcion;

        do { //utilizamos ciclo do-while para que muestre el menu mientras la opcion elegida no sea 7(salir)
            System.out.println("""
                           
                     ========== BIENVENIDO/A AL CONVERSOR DE MONEDAS ==========
                     Selecciona la opción que deseas utilizar:  
                     1. USD → ARS (Dola a Peso argentino) 
                     2. ARS → USD (Peso argentino a Dolar
                     3. USD → MXN (Dolar a Peso mexicano) 
                     4. MXN → USD (Peso Mexicano a Dolar
                     5. USD → BRL (Dolar a Real brasileño)
                     6. BRL → USD (Real Brasileño a Dolar
                     7. Salir     
           """);
    opcion = scanner.nextInt();

    switch (opcion) { //utilizamos switch para darle una accion a cada opcion elegida. Se asignan los valores a l avariable de mostrarCambio
        case 1 -> mostrarCambio(apiKey, "USD", "ARS", scanner); //se llama al metodo mostrarCambio y se le asginan los parametros que solicita
        case 2 -> mostrarCambio(apiKey, "ARS", "USD", scanner);
        case 3 -> mostrarCambio(apiKey, "USD", "MXN", scanner);
        case 4 -> mostrarCambio(apiKey, "MXN", "USD", scanner);
        case 5 -> mostrarCambio(apiKey, "USD", "BRL", scanner);
        case 6 -> mostrarCambio(apiKey, "BRL", "USD", scanner);
        case 7 -> System.out.println("Saliendo...");
        default -> System.out.println("Opción inválida.");
    }

} while (opcion != 7);

scanner.close();
}

public static void mostrarCambio(String apiKey, String base, String destino, Scanner scanner) {
String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + base;
HttpClient client = HttpClient.newHttpClient();

HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();

try {
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    if (response.statusCode() == 200) {
        Gson gson = new Gson();
        ConsumoAPI.ApiResponse data = gson.fromJson(response.body(), ConsumoAPI.ApiResponse.class);
        Double tasa = ((ConsumoAPI.ApiResponse) data).conversion_rates.get(destino);

        if (tasa != null) {
            System.out.printf("Tipo de cambio actual de %s a %s: %.4f%n", base, destino, tasa);

            // Pedir al usuario una cantidad para convertir
            System.out.printf("Ingresa la cantidad de %s que deseas convertir: ", base);
            double cantidad = scanner.nextDouble();
            double convertido = cantidad * tasa;

            System.out.printf("%.2f %s equivalen a %.2f %s%n",
                    cantidad, base, convertido, destino);
        } else {
            System.out.println("Moneda de destino no encontrada.");
        }
    } else {
        System.out.println("Error en la solicitud: " + response.statusCode());
    }

} catch (IOException | InterruptedException e) {
    System.out.println("Error al obtener datos: " + e.getMessage());
}
}
}




