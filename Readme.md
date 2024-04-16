
# Conversor de Moneda

Este programa en Java te permite convertir entre diferentes monedas utilizando una API externa.

## Requisitos

- Java JDK instalado en tu sistema.
- Conexión a internet para utilizar la API de conversión de moneda.
- Link a API : [Exchangerate-API](https://www.exchangerate-api.com/)
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
   Debe generar una api key y crear en la raiz del proyecto un archivo .env

   ```bash
   API_KEY="debe ingresar aca su api key"
   ```
4. Debe agregar las dependencias
   Para hacer esto debe dirigirse a las configuraciones de su aplicacion y agregar 2 dependencias que se encuentran en la carpeta dependecias de 
   programa
   ##### En codigo iml
Deberia quedar similar al siguiente codigo el iml
```bash
   <?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4">
  <component name="NewModuleRootManager" inherit-compiler-output="true">
    <exclude-output />
    <content url="file://$MODULE_DIR$">
      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
    </content>
    <orderEntry type="inheritedJdk" />
    <orderEntry type="sourceFolder" forTests="false" />
    <orderEntry type="module-library">
      <library>
        <CLASSES>
          <root url="jar://$MODULE_DIR$/dependencias/gson-2.10.1.jar!/" />
        </CLASSES>
        <JAVADOC />
        <SOURCES />
      </library>
    </orderEntry>
    <orderEntry type="module-library">
      <library>
        <CLASSES>
          <root url="jar://$MODULE_DIR$/dependencias/java-dotenv-5.2.2.jar!/" />
        </CLASSES>
        <JAVADOC />
        <SOURCES />
      </library>
    </orderEntry>
  </component>
</module>
   ```

5. Ejecuta el programa:

   ```bash
   java -cp out com.aluracursos.principal.Principal
   ```

6. Sigue las instrucciones en pantalla para realizar conversiones entre diferentes monedas.

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