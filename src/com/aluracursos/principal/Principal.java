package com.aluracursos.principal;

import com.aluracursos.modelos.Converciones;
import com.aluracursos.modelos.LlamadaApi;
import com.aluracursos.modelos.Moneda;
import com.aluracursos.modelos.Pasaje;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        /*----------------Declaraciones de variables---------------*/
        LlamadaApi llamada = new LlamadaApi();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()//setea el json bien dentro del archivo creado
                .create();
        var menu = " Bienvenido al conversor de Moneda" +
                "\n Ingrese una de las siguientes opciones" +
                "\n 1) Dolar (USD)--> Peso Argentino (ARS)" +
                "\n 2) Peso Argentino (ARS) --> Dolar (USD)" +
                "\n 3) Dolar (USD)--> Real Brasileño (BRL)" +
                "\n 4) Real Brasileño (BRL)--> Dolar (USD)" +
                "\n 5) Dolar (USD)--> Peso Colombiano (COP)" +
                "\n 6) Peso Colombiano (COP)--> Dolar (USD)" +
                "\n 7) Salir " +
                "\n ****************************************";
        var menuError = " Elija una opcion correcta!!";
        var menuFinal = "Desea Realizar otra convercion?"+
                "\n1)(Ingrese cualquier nro) SI"+
                "\n2)(Ingrese 2) NO";
        var despedida = "Gracias por Utilizar nuestra APP";
        Scanner lectura = new Scanner(System.in);

        String monedaBase = "vacio";
        String monedaFinal = "vacio";
        String cantidad;

        Boolean continuar = false;
        String opcion;
        boolean condicion =true;
        List<Converciones> converciones= new ArrayList<>();
        /*------------------Comienzo del algoritmo---------------*/
        while (true){
            System.out.println(menu);
            if(condicion){
                System.out.println("Ingrese una opcion:");
            }else{
                System.out.println("Ingrese una opcion valida: ");
            }
            opcion = lectura.nextLine();
            if(!isNumeric(opcion)){
                System.out.println("Debe ingresar un numero");
                opcion = lectura.nextLine();

            }
            switch (opcion){
                case "1":
                    monedaBase = "USD";
                    monedaFinal= "ARS";
                    condicion=true;
                    break;
                case "2":
                    monedaBase = "ARS";
                    monedaFinal= "USD";
                    condicion=true;
                    break;
                case "3":
                    monedaBase = "USD";
                    monedaFinal= "BRL";
                    condicion=true;
                    break;
                case "4":
                    monedaBase = "BRL";
                    monedaFinal= "USD";
                    condicion=true;
                    break;
                case "5":
                    monedaBase = "USD";
                    monedaFinal= "COP";
                    condicion=true;
                    break;
                case "6":
                    monedaBase = "COP";
                    monedaFinal= "USD";
                    condicion=true;
                    break;
                case "7":
                    continuar=true;
                    break;
                default:
                    System.out.println("\n**********************************");
                    System.out.println("\nIngrese una opcion valida");
                    System.out.println("\n*********************************");
                    condicion=false;
                    break;
            }
            if (opcion != "7" && condicion){
                System.out.println("Ingrese una cantidad de " + monedaBase + " :");
                cantidad=lectura.nextLine();
                isNumeric(cantidad);
                while (!isNumeric(cantidad)){
                    if(!isNumeric(cantidad)){
                        System.out.println("Ingreso una cantidad no valida");
                        System.out.println("Ingrese de nuevo ");
                        cantidad=lectura.nextLine();
                    }
                }
                String json=llamada.llamadaConversorDirecto(monedaBase,monedaFinal,cantidad);
                Pasaje pasaje= gson.fromJson(json, Pasaje.class);
                Moneda moneda1 = new Moneda(pasaje.baseCode(),Double.parseDouble(cantidad));
                Moneda moneda2 = new Moneda(pasaje.targetCode(),pasaje.conversionResult());
                ZonedDateTime horaActual = ZonedDateTime.now();
                Converciones convercion = new Converciones(pasaje.baseCode(),pasaje.targetCode(),Double.parseDouble(cantidad),pasaje.conversionResult(),horaActual.toString().replace("T"," hora: "));
                converciones.add(convercion);

                System.out.println("**********************"+
                        "\nConvercion exitosa "+
                        "\nSe convirtio con exito de " + moneda1.toString() + " --> " + moneda2.toString()+
                        "\n**********************");
                System.out.println(menuFinal);
                String desicion = lectura.nextLine();
                if(desicion.equals("2")){
                    System.out.println("Lista de converciones: "+ converciones);

                    System.out.println(despedida);
                    FileWriter fileWriter = new FileWriter("listaConverciones.txt");
                    fileWriter.write(gson.toJson(converciones));
                    fileWriter.close();
                    break;
                }
            }
            if(continuar){
                System.out.println(despedida);
                break;
            }
        }
    }
    private static boolean isNumeric( String cantidad){
        if(cantidad==null || cantidad.length()==0 ){
            return false;
        }
        try{
            Double.parseDouble(cantidad);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
