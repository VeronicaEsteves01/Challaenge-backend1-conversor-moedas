package api;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/";

    public double buscarTaxa(String origem, String destino) throws Exception {
        URL url = new URL(API_URL + origem);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder resposta = new StringBuilder();
        String linha;

        while ((linha = reader.readLine()) != null) {
            resposta.append(linha);
        }
        reader.close();

        JSONObject json = new JSONObject(resposta.toString());
        JSONObject taxas = json.getJSONObject("conversion_rates");
        return taxas.getDouble(destino);
    }
}
