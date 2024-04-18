import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {

    public Divisa buscaDivisa(String monedaLocal, String monedaExt) {
        String direccion = "https://v6.exchangerate-api.com/v6/a2f888e8a20103ec15438342/pair/"+monedaLocal+"/"+monedaExt;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);
        } catch (Exception e) {
            throw new  RuntimeException("no existe");
        }
    }
}
