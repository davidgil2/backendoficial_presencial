# AIRLINE-API

[Spring Boot](http://projects.spring.io/spring-boot/) application [3.1.2](https://spring.io/blog/2023/07/20/spring-boot-3-1-2-available-now)

## API Architecture

| Name                    | HTTP Method | Active Versions | Path                                        | Status Codes          | Implemented | Description                                      |
| ----------------------- | ----------- | --------------- | ------------------------------------------- | --------------------- | ----------- | ------------------------------------------------ |
| GET Flights             | `GET`       | `v1`            | /api/v1/flights                             | `200`                 | ✅          | Get basic information of all flights             |
| GET Flight              | `GET`       | `v1`            | /api/v1/flights/{id}                        | `200` - `400` - `404` | ✅          | Returns only one flight by its id                |
| POST Flight             | `POST`      | `v1`            | /api/v1/flights                             | `201` - `400`         | ✅          | Create a flight and its scales                   |
| PUT Flight              | `PUT`       | - -             | /api/v1/flights/{id}                        | `200` - `400` - `404` | ❌          | Update the flight and scales info by its id      |
| DELETE                  | `DELETE`    | `v1`            | /api/v1/flights/{id}                        | `200` - `400` - `404` | ✅          | Delete a flight by its id                        |
| GET Airports            | `GET`       | `v1`            | /api/v1/airports                            | `200`                 | ✅          | Get basic information of all airports            |
| GET Airport             | `GET`       | `v1`            | /api/v1/airports/{id}                       | `200` - `400` - `404` | ✅          | Returns only one airport by its id               |
| GET Countries           | `GET`       | `v1`            | /api/v1/airports/Countries                  | `200`                 | ✅          | Get the list of all cities                       |
| GET Airports by Country | `GET`       | `v1`            | /api/v1/airports/Countries/{country}        | `200` - `400`         | ✅          | Get all airports of a specific country           |
| GET Cities by Country   | `GET`       | `v1`            | /api/v1/airports/Countries/{country}/cities | `200` - `400`         | ✅          | Get the list of all cities of a specific country |
| GET Airports by City    | `GET`       | `v1`            | /api/v1/airports/cities/{city}              | `200` - `400`         | ✅          | Get all airports of a specific city              |
| GET Airplane Models     | `GET`       | `v1`            | /api/v1/airplanes-models                    | `200`                 | ✅          | Get all airplane models                          |
| GET Airplane Model      | `GET`       | `v1`            | /api/v1/airplanes-models/{id}               | `200` - `400` - `404` | ✅          | Get only one airplane model by its id            |
| GET Airplane families   | `GET`       | `v1`            | /api/v1/airplanes-models/families           | `200`                 | ✅          | Get a list of all airplane families              |
| GET Airplanes by family | `GET`       | `v1`            | /api/v1/airplanes-models/families/{family}  | `200` - `400`         | ✅          | Get all airplane models of a specific family     |

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
> de bases de datos Oracle usada tiene un peso aproximado de 1.4GB.

Luego de correr este comando, deberá esperar la inicialización de la bases de datos antes de comenzar a usar la API.

> [!TIP]
> Si tiene la aplicación Docker Desktop, puede visualizar el proceso de creación de la base de datos dando clic en el contenedor `modulo-vuelos-a-db` y mirando los logs del mismo. Este proceso puede tardar varios minutos.

Una vez la base de datos esté disponible, puede ingresar a la aplicación en la URL [**`http://localhost:8018`**](http://localhost:8018). La documentación en Swagger la puede encontrar en la URL [**`http://localhost:8018/modulo-18/swagger-ui/index.html`**](http://localhost:8018/modulo-18/swagger-ui/index.html).

En caso de tener problemas, puede intentar reiniciando el contenedor de la API.

```shell
docker restart modulo-vuelos-a-api
```
