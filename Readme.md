
# Conversor de Moneda

Este programa en Java te permite convertir entre diferentes monedas utilizando una API externa.

## Requisitos

- Java JDK instalado en tu sistema.
- Conexión a internet para utilizar la API de conversión de moneda.
- Link a API : https://www.exchangerate-api.com/
- Generar una API KEY

## Instalación y Uso

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tu_usuario/conversor-moneda.git
   ```

2. Navega al directorio del proyecto:

   ```bash
   cd conversor-moneda
   ```

3. Cambiar API KEY:
   Debe generar una api key y reemplazarlo en la clase llamada LlamadaApi debido a que puede no estar disponible si lo desea realizar con mi apiKey

   ```bash
   35- public String llamadaConversorDirecto(String monedaBase, String monedaFinal,String cantidad){
   36-     var apiKey="a5f6fceec983c1c2c7f1a56c";

   ```
   

4. Ejecuta el programa:

   ```bash
   java -cp out com.aluracursos.principal.Principal
   ```

5. Sigue las instrucciones en pantalla para realizar conversiones entre diferentes monedas.

### Ejemplo de modo de uso

#### Menu del programa
<image src="src/img/Menu.png" alt= "menu principal">


#### Ejemplo de USD a ARS 

<image src="src/img/ingreseValor.png" alt= "ingrese moneda base">

#### Ejemplo de convercion exitosa

<image src="src/img/ejemploConvercion.png" alt= "Convercion exitosa">

#### Ejemplo de fin de programa

<image src="src/img/finDelPrograma.png" alt= "Fin de programa">


## Créditos

Este programa utiliza la API de conversión de moneda proporcionada por [ExchangeRate-API](https://www.exchangerate-api.com/).

## Contribución

¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, no dudes en enviar una solicitud de extracción.

## Conclusion
   Este codigo forma parte de la plataforma alura Cursos [AluraCursos](https://app.aluracursos.com/dashboard)