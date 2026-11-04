# Laboratorio: Seguridad Web y API REST Stateless con JWT

Proyecto desarrollado para la asignatura de seguridad, estructurado en un único proyecto Maven (`seguridad-web/`) que cubre autenticación basada en sesiones, mitigación de vulnerabilidades y una API REST protegida con tokens JWT.

## Estructura del Proyecto
- `src/main/java/com/universidad/seguridad/config`: Configuraciones de Spring Security (Web y API).
- `src/main/java/com/universidad/seguridad/controller`: Controladores Web (Thymeleaf) y REST (`AuthRestController`).
- `src/main/java/com/universidad/seguridad/security`: Utilidades JWT (`JwtUtil`) y filtros de autenticación (`JwtRequestFilter`).
- `src/main/java/com/universidad/seguridad/service`: Lógica de negocio y detalles de usuario.
- `src/main/java/com/universidad/seguridad/repository`: Repositorios JPA con mitigación de SQL Injection (`@Query`).
- `capturas/`: Evidencias visuales de la ejecución del laboratorio.

## Evidencias en `/capturas`
1. `01-login-sesion.png`: Login con sesión activa y BCrypt.
2. `02-dashboard-th-text-seguro.png`: Dashboard con `th:text` seguro (XSS escapado).
3. `03-xss-th-utext-temporal.png`: XSS ejecutado con `th:utext` (prueba temporal).
4. `04-sql-injection-mitigado-query.png`: SQL Injection mitigado con `@Query`.
5. `05-csrf-rechazado-403.png`: Petición sin CSRF rechazada con 403.
6. `06-post-api-auth-login-token.png`: `POST /api/auth/login` con token JWT recibido.
7. `07-get-api-tareas-200.png`: `GET /api/tareas` autenticado (200 OK).
8. `08-get-api-tareas-sin-token-401.png`: `GET /api/tareas` sin token (401 Unauthorized).

## Parte 1: Login con Sesión, BCrypt, Roles y Mitigación de XSS/SQL Injection
- Autenticación tradicional basada en formularios y sesiones HTTP.
- Encriptación de credenciales con `BCryptPasswordEncoder`.
- Control de acceso por roles (`ADMIN`).
- Mitigación de XSS mediante codificación en Thymeleaf (`th:text`) y prevención de SQL Injection mediante consultas parametrizadas con `@Query`.

## Parte 2: API REST Stateless Protegida con JWT
- Configuración de políticas de sesión sin estado (`SessionCreationPolicy.STATELESS`).
- Generación, firma y validación de tokens JWT mediante `io.jsonwebtoken` (jjwt).
- Endpoints de autenticación y recursos protegidos mediante cabecera `Authorization: Bearer <token>`.