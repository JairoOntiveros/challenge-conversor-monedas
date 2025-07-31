package com.JairoOntiveros.conversor.servicios;

import com.JairoOntiveros.conversor.modelos.ConversionFinal;
import com.JairoOntiveros.conversor.modelos.ExchangeRateResponse;
import com.JairoOntiveros.conversor.utilidades.Utilidades;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIService {

    private static final String URL = "https://v6.exchangerate-api.com/v6/";

    //para usar este programa reemplaza tu API aqui
    private static final String API_KEY = ;

    private final Gson gson = new Gson();

    public ConversionFinal Convertir(String base, String objetivo, double cantidad){

        URI direccion = URI.create(URL + API_KEY + "/pair/"+ base + "/" + objetivo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            ExchangeRateResponse resultado = gson.fromJson(response.body(), ExchangeRateResponse.class);

            if (resultado == null){
                throw new RuntimeException("No se pudo obtener una tasa de conversion valida")
            }

            double resultadoConversion = cantidad* resultado.conversion_rate();
            String fechaES = Utilidades.formatearFechaEnEspanol(resultado.time_last_update());

            return new ConversionFinal(resultadoConversion,fechaES);

        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un problema al intentar realizar la conversión." +
                    " Por favor, verifica tu conexión a internet o intenta más tarde.");
        }
    }

}
