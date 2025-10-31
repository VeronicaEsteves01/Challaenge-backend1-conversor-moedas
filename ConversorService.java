package service;

import api.ApiClient;

public class ConversorService {
    private final ApiClient apiClient = new ApiClient();

    public double converter(String origem, String destino, double valor) throws Exception {
        double taxa = apiClient.buscarTaxa(origem, destino);
        return valor * taxa;
    }
}
