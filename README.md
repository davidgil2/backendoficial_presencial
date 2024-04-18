# AIRLINE-API

[Spring Boot](http://projects.spring.io/spring-boot/) application [3.1.2](https://spring.io/blog/2023/07/20/spring-boot-3-1-2-available-now)

## Ejecutar con Docker

> [!IMPORTANT]  
> Necesitas tener docker instalado y corriendo en tu máquina.

**Inicializando los servicios:**
Estando dentro del repositorio clonado, ejecutar:

```shell
docker compose up -d
```

Con este comando docker montará dos servicios: uno de bases de datos y la aplicación web.

> [!NOTE]  
> La descarga de las imagenes usadas puede tardar un tiempo considerable ya que la imagen
> de bases de datos Oracle usada tiene un peso aproximado de 3.3GB.

Luego de correr este comando, deberá esperar la inicialización de la bases de datos antes de comenzar a usar la API.

> [!TIP]
> Si tiene la aplicación Docker Desktop, puede visualizar el proceso de creación de la base de datos dando clic en el contenedor `sitas-db` y mirando los logs del mismo. Este proceso puede tardar varios minutos.

Una vez la base de datos esté disponible, puede ingresar a la aplicación en la URL [`http://localhost:8080`](http://localhost:8080). La documentación en Swagger la puede encontrar en la URL [http://localhost:8080/sitas-api/swagger-ui/index.html](http://localhost:8080/sitas-api/swagger-ui/index.html).

En caso de tener problemas, puede intentar reiniciando el contenedor de la API.

```shell
docker restart sitas-back
```

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

## Otros comandos

Si desea limpiar y compilar el proyecto use el siguiente comando:
```shell
mvn clean install
```

En el caso de que quiera correr el comando sin validar los test del aplicativo ejecute:
```shell
mvn clean install -DskipTests
```