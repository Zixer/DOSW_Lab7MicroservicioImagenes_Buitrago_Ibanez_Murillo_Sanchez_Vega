# DOSW_Lab7MicroservicioImagenes_Buitrago_Ibanez_Murillo_Sanchez_Vega

Microservicio de gestión y almacenamiento de imágenes desarrollado con **Spring Boot** y **MongoDB**, estructurado en capas (Modelo, Repositorio, Servicio y Controlador REST).

## Instrucciones para Ejecutar y Probar

1. **Levantar MongoDB en Docker:**
   ```bash
   docker run --name mongo-lab7 -p 27017:27017 -d mongo