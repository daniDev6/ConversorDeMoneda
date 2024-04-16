package com.aluracursos.modelos;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {
    private static final Dotenv dotenv = Dotenv.configure().load();
    public static String getApiKey(){
        return dotenv.get("API_KEY");
    }

}
