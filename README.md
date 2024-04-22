# AIRLINE-API

[Spring Boot](http://projects.spring.io/spring-boot/) application [3.1.2](https://spring.io/blog/2023/07/20/spring-boot-3-1-2-available-now)

## Despliegue

La aplicación web fue desplegada junto con la respectiva base de datos Oracle en el servidor proporcionado por la CodeFactory:

- **Swagger UI:** https://codefact.udea.edu.co/modulo-18/swagger-ui/index.html
- **URL Base:** https://codefact.udea.edu.co/modulo-18

> [!IMPORTANT]  
> Para realizar pruebas desde la interfaz gráfica de Swagger, es necesario seleccionar la URL de servidor de producción al inicio de la página.

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
