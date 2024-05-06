# Ecommerce challenge
> . funcionalidades implementadas...

> Live demo [_here_](/). # no implementado
> Backend Demo [_here_](/swagger-ui/index.html#). #no implementado


## General Information
datos proyecto


## Technologies Used
- **Backend:** Java, Spring Boot, Hibernate, REST, API, JWT, JSON, Maven, Apache, Swagger, MapStruct, Docker
- **Database:** PostgreSQL
- **Frontend:** HTML, CSS, Typescript, Angular 16, Tailwind
- **Infrastructure:** correr en local


## Setup
### Prerequistes
For running this project you need:
- Docker 3.9

### pasos a seguir
- clonar repositorio: 
```console
git clone https://github.com/Gabusy07/factor-challenge.git
```

### dirigirse a la carpeta raiz

### Backend
1. Para levantar el docker en backend seguir los siguientes pasos:
```bash
cd /factor-challenge/back 
```
2. construir las imagenes:
```bash
   Docker-compose build
```
3. levantar contenedor:
```bash
  docker-compose up
```
4. Si falla la primera ejecucion interrumpir el proceso y volver a ejecutar el ultimo comando:


### Frontend
1. Una vez levantado la base de datos y la aplicacion backend los pasos para el frontend con los siguientes:
```bash
 cd ..
 cd /front/factor-ecommerce
```
2. instalar librerias:
```console
npm i
```
3. levantar aplicacion:
```console
npm run start:dev
```

## Uso

### Backend (Swagger)
Para acceder a swagger ve a http://localhost:port/swagger-ui/index.html#.

### Database

Para ver la base de datos deberas acceder con las siguientes credenciales:

- URL: jdbc:postgresql://localhost:5432/postgres
- USERNAME: postgres
-PASSWORD: postgres


## Project Status

En desarrollo

## To do: 
- Implementar cambio categoria en usuarios
- Implementar spring security y manejo de peticiones por token
- implementar mensajes de error en front y manejo de caso orden producto no se vea duplicado sino que se sumen los productos
