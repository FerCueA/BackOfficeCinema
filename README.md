# BackOfficeCinema

Sistema de login y gestión de usuarios para un cine.

## ¿Qué hace este proyecto?

Es una página web donde puedes:
- Iniciar sesión con usuario y contraseña
- Ver un panel de inicio después de loguearte
- Gestionar usuarios 
- Gestion de Peliculas


## Tecnologías que usé

- Java (Spring Boot)
- MySQL para la base de datos
- HTML y CSS para las páginas
- Spring Security para el login

## Cómo ejecutarlo

1. Tienes que tener Java 17 instalado
2. git clone https://github.com/FerCueA/BackOfficeCinema.git
3. Instala MySQL y crea la base de datos con el archivo `db_filmcinema.sql`
4. Ejecuta el proyecto
5. Abre el navegador en `http://localhost:8080`


## Estructura

```
BackOfficeCinema/
├── src/
│   ├── main/
│   │   ├── java/es/dsw/
│   │   │   ├── app/               # Configuración Spring Security
│   │   │   │   ├── DetallesUsuario.java
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   └── SeguridadApplication.java
│   │   │   ├── connections/       # Conexión a base de datos
│   │   │   │   └── MySqlConnection.java
│   │   │   ├── controller/        # Controladores MVC
│   │   │   │   └── MainController.java
│   │   │   ├── dao/               # Capa de acceso a datos
│   │   │   │   ├── RolDAO.java
│   │   │   │   └── UsuarioDAO.java
│   │   │   └── models/            # Modelos de datos
│   │   │       ├── Rol.java
│   │   │       └── Usuario.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/            # Recursos estáticos
│   │       │   ├── bootstrap/
│   │       │   ├── js/
│   │       │   └── styles/
│   │       └── templates/         # Plantillas HTML
│   │           ├── home.html
│   │           └── login.html
│   └── test/                      # Tests unitarios
├── db_filmcinema.sql              # Script de base de datos
├── pom.xml                        # Configuración Maven
└── README.md
```

## Sistema de cookies

El proyecto implementa un sistema de cookies para recordar el último acceso del usuario:

- **Nombre de cookie**: `ultimoAcceso`
- **Duración**: 7 días
- **Formato**: `dd-MM-yyyy-HH:mm:ss`
- **Funcionalidad**: Muestra en el login la fecha del último acceso exitoso


##  Características implementadas

- [x] Autenticación con Spring Security
- [x] Sistema de roles (Admin/Usuario)
- [x] Cookie de último acceso persistente
- [x] Conexión a MySQL mediante DAO
- [x] Encriptación de contraseñas con BCrypt
- [x] Diseño responsive con Bootstrap
- [x] Panel de usuario personalizado
- [x] Implementacion de la navegacion del nav con Control de Roles



## Próximas mejoras

- [ ] Implementar CRUD completo de usuarios en el panel
- [ ] Añadir gestión completa de películas
- [ ] Implementar paginación en listados


## Información

**Proyecto académico desarrollado como parte del Ciclo Formativo de Grado Superior en Desarrollo de Aplicaciones Web (DAWN)**

Este sistema fue creado con fines educativos para demostrar la implementación de:
- Autenticación y autorización con Spring Security
- Gestión de sesiones y cookies
- Arquitectura MVC
- Persistencia de datos con MySQL
- Integración de tecnologías frontend y backend

---

**Autor**: Aleixo Fernando Cuevas 
**Curso**: 2024-2025  
**Centro**: IES El Rincon
**Asignatura**: Desarrollo Web en Entorno Servidor



