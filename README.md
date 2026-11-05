# Agenda de Contactos (Kotlin)

Aplicación de consola desarrollada en **Kotlin** para gestionar una agenda de contactos en memoria. Actividad 07 de la Unidad 1 (UD01), Ilerna.

**Autor:** Antonio Manuel González Martínez

## Descripción

El programa muestra un menú por consola que permite añadir, listar, buscar y eliminar contactos. Cada dato que se introduce (nombre, email y teléfono) se valida con expresiones regulares y se vuelve a pedir hasta que sea correcto.

## Funcionalidades

| Opción | Acción |
|--------|--------|
| 1 | Añadir un contacto (nombre, email y teléfono validados) |
| 2 | Listar todos los contactos ordenados alfabéticamente por nombre |
| 3 | Buscar contactos por nombre (coincidencia parcial) |
| 4 | Eliminar contactos por nombre |
| 0 | Salir del programa |

## Validaciones

- **Nombre:** solo letras, espacios y guiones.
- **Email:** formato `usuario@dominio.ext`.
- **Teléfono:** 9 dígitos seguidos que empiecen por 6 (ej: `611111111`).

Los mensajes de error se muestran en rojo mediante códigos ANSI.

## Estructura del proyecto

```
UD01_Actividad07_AgendaContactos/
└── src/
    ├── Main.kt       # Punto de entrada: lanza el menú
    ├── Agenda.kt     # Menú principal y lógica de la agenda
    ├── Contacto.kt   # Data class con nombre, teléfono y email
    └── Depurar.kt    # Funciones de entrada y validación de datos
```

## Requisitos

- JDK 8 o superior
- Kotlin (el proyecto está preparado para **IntelliJ IDEA**)

## Ejecución

1. Clonar o descargar el repositorio.
2. Abrir la carpeta del proyecto en IntelliJ IDEA.
3. Ejecutar la función `main` de `Main.kt`.

## Ejemplo de uso

```
===== AGENDA DE CONTACTOS =====
1. Añadir contacto
2. Listar contactos
3. Buscar contacto
4. Eliminar contacto
0. Salir
Seleccione una opción:
```
