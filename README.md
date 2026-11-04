# Laboratorio: Seguridad Web y API REST Stateless con JWT

Proyecto desarrollado para la asignatura de seguridad, estructurado en un único proyecto Maven (`seguridad-web/`) que cubre autenticación basada en sesiones, mitigación de vulnerabilidades y una API REST protegida con tokens JWT.

## Estructura del Proyecto
- `src/main/java/com/universidad/seguridad/config`: Configuraciones de Spring Security (Web y API).
- `src/main/java/com/universidad/seguridad/controller`: Controladores Web (Thymeleaf) y REST (`AuthRestController`).
- `src/main/java/com/universidad/seguridad/security`: Utilidades JWT (`JwtUtil`) y filtros de autenticación (`JwtRequestFilter`).
- `src/main/java/com/universidad/seguridad/service`: Lógica de negocio y detalles de usuario.
- `src/main/java/com/universidad/seguridad/repository`: Repositorios JPA con mitigación de SQL Injection (`@Query`).
- `capturas/`: Evidencias visuales de la ejecución del laboratorio[cite: 9].

## Parte 1: Login con Sesión, BCrypt, Roles y Mitigación de XSS/SQL Injection
- Autenticación tradicional basada en formularios y sesiones HTTP.
- Encriptación de credenciales con `BCryptPasswordEncoder`.
- Control de acceso por roles (`ADMIN`).
- Mitigación de XSS mediante codificación en Thymeleaf (`th:text`) y prevención de SQL Injection mediante consultas parametrizadas con `@Query`.

## Parte 2: API REST Stateless Protegida con JWT
- Configuración de políticas de sesión sin estado (`SessionCreationPolicy.STATELESS`).
- Generación, firma y validación de tokens JWT mediante `io.jsonwebtoken` (jjwt).
- Endpoints de autenticación y recursos protegidos mediante cabecera `Authorization: Bearer <token>`.
