# BackOfficeCinema

Sistema de login y gestión de usuarios para un cine.

## ¿Qué hace este proyecto?

Es una página web donde puedes:
- Iniciar sesión con usuario y contraseña
- Ver un panel de inicio después de loguearte
- Gestionar usuarios (todavía en desarrollo)

## Tecnologías que usé

- Java (Spring Boot)
- MySQL para la base de datos
- HTML y CSS para las páginas
- Spring Security para el login

## Cómo ejecutarlo

1. Tienes que tener Java 17 instalado
2. Instala MySQL y crea la base de datos con el archivo `db_filmcinema.sql`
3. Cambia los datos de conexión en `application.properties`:
   - Usuario de MySQL
   - Contraseña de MySQL
4. Ejecuta el proyecto:
   ```
   ./mvnw spring-boot:run
   ```
5. Abre el navegador en `http://localhost:8080`

## Estructura

- `src/main/java` - Todo el código Java
- `src/main/resources/templates` - Las páginas HTML
- `src/main/resources/static` - CSS y JavaScript
- `db_filmcinema.sql` - Script de la base de datos

## Problemas que tuve

- Al principio no me conectaba a MySQL porque tenía mal la configuracion de los DAO y no tenia el Services.
- Tuve que aprender cómo funciona Spring Security para hacer el login con base de datos.

## Por hacer

- [ ] Mejorar el diseño de las páginas
- [ ] Añadir más funciones de administración
- [ ] Hacer el CRUD completo de usuarios

---
Proyecto hecho mientras aprendo Spring Boot
