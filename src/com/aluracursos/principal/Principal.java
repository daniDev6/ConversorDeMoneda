package com.aluracursos.principal;

import com.aluracursos.modelos.LlamadaApi;
import com.aluracursos.modelos.Moneda;
import com.aluracursos.modelos.Pasaje;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        LlamadaApi llamada = new LlamadaApi();
        // System.out.println(llamada.llamadaHttp("USD"));
        /*
        * ARS - Peso argentino
          BOB - Boliviano boliviano
          BRL - Real brasileño
          CLP - Peso chileno
          COP - Peso colombiano
          USD - Dólar estadounidense
        *
        *
        *
        * */
        //var respuesta =llamada.llamadaConversorDirecto("USD","ARS","125");
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()//setea el json bien dentro del archivo creado
                .create();
        //System.out.println(gson.toJson(respuesta));
        var menu=" Bienvenido al conversor de Moneda" +

                "\n Ingrese una de las siguientes opciones" +
                "\n 1) Dolar --> Peso Argentino" +
                "\n 2) Peso Argentino --> Dolar" +
                "\n 3) Dolar --> Real Brasileño" +
                "\n 4) Real Brasileño --> Dolar" +
                "\n 5) Dolar --> Peso Colombiano" +
                "\n 6) Peso Colombiano --> Dolar" +
                "\n 7) Salir " +

                "\n ****************************************" +
                "\n Elige una opcion: ";
        var menuError=" Elija una opcion correcta!!";

        Scanner lectura = new Scanner(System.in);

        String monedaBase = "vacio";
        String monedaFinal = "vacio";
        String cantidad = "0";
        String resultado;
        Boolean continuar = false;


        int opcion;
        while (true){
            System.out.println(menu);
            opcion = lectura.nextInt();
            switch (opcion){
                case 1:
                    monedaBase = "USD";
                    monedaFinal= "ARS";

                    break;
                case 2:
                    monedaBase = "ARS";
                    monedaFinal= "USD";

                    break;
                case 3:
                    monedaBase = "USD";
                    monedaFinal= "BRL";

                    break;
                case 4:
                    monedaBase = "BRL";
                    monedaFinal= "USD";

                    break;
                case 5:
                    monedaBase = "USD";
                    monedaFinal= "COP";

                    break;
                case 6:
                    monedaBase = "COP";
                    monedaFinal= "USD";

                    break;
                case 7:
                    continuar=true;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
            if (opcion != 7){
                System.out.println("Ingrese una cantidad: ");
                lectura.nextLine();
                cantidad=lectura.nextLine();
                String json=llamada.llamadaConversorDirecto(monedaBase,monedaFinal,cantidad);
                Pasaje pasaje= gson.fromJson(json, Pasaje.class);
                System.out.println("Prueba: "+cantidad);
                Moneda moneda1 = new Moneda(pasaje.baseCode(),Double.parseDouble(cantidad));
                Moneda moneda2 = new Moneda(pasaje.targetCode(),pasaje.conversionResult());
                System.out.println("**********************");
                System.out.println("\nConvercion exitosa ");
                System.out.println("\nSe convirtio con exito de " + moneda1.toString() + " --> " + moneda2.toString());
                System.out.println("**********************");
                System.out.println("Desea Realizar otra convercion?");
                System.out.println("1) SI");
                System.out.println("2) NO");

                String decicion = lectura.nextLine();
                if(decicion.equals("2") || continuar){
                    System.out.println("Gracias por Utilizar nuestra APP");
                    break;
                }
            }
            if(continuar){
                System.out.println("Gracias por Utilizar nuestra APP");
                break;
            }



        }













    }
}
