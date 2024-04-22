# AIRLINE-API

[Spring Boot](http://projects.spring.io/spring-boot/) application [3.1.2](https://spring.io/blog/2023/07/20/spring-boot-3-1-2-available-now)

## Requisitos

Para construir y ejecutar la aplicación necesita:

- [JDK 20](https://jdk.java.net/20/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Ejecutando la aplicación localmente

Hay varias formas de ejecutar una aplicación Spring Boot en su máquina local. Una forma es ejecutar el método `main` en la clase `co.udea.airline.api.AirlineApiApplication` desde su IDE.

Alternativamente, puedes usar el [Plugin de Spring Boot Maven](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) de esta manera:
```shell
mvn spring-boot:run
```
## Ejecutando la aplicación en producción

La aplicación está actualmente desplegada y accesible a través del siguiente enlace:

```shell
https://codefact.udea.edu.co/modulo-19/swagger-ui/index.html#/
```
En los Servers debes elegir: 

```shell
https://codefact.udea.edu.co/modulo-19 - Server URL in Production enviroment 
```

Este enlace te llevará a la interfaz de usuario de Swagger, donde podrás explorar y probar los endpoints de la API de manera interactiva.

## Otros comandos

Si desea limpiar y compilar el proyecto use el siguiente comando:
```shell
mvn clean install
```

En el caso de que quiera correr el comando sin validar los test del aplicativo ejecute:
```shell
mvn clean install -DskipTests
```

