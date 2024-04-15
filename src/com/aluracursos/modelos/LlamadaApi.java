package com.aluracursos.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlamadaApi {
    public String llamadaHttp( String moneda){
    var direccion = "https://v6.exchangerate-api.com/v6/a5f6fceec983c1c2c7f1a56c/latest/" + moneda;
        HttpClient client = HttpClient.newHttpClient();
        //patron builder: Construir algo q tenga una cierta forma
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //agregar las exepciones debido a q laburams en internet
        System.out.println(response.body());
        String json = response.body();
        return json;
    }
    public String llamadaConversorDirecto(String monedaBase, String monedaFinal,String cantidad){
        var direccion = "https://v6.exchangerate-api.com/v6/a5f6fceec983c1c2c7f1a56c/pair/" + monedaBase +"/"+monedaFinal+"/"+cantidad;
        HttpClient client = HttpClient.newHttpClient();
        //patron builder: Construir algo q tenga una cierta forma
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //agregar las exepciones debido a q laburams en internet
        //System.out.println(response.body());
        String json = response.body();

        return json;
    }











}
