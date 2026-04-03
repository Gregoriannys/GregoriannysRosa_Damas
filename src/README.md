# Juego de Damas

## 1. Descripción del proyecto
Este proyecto consiste en el desarrollo de un juego de damas para dos jugadores en una misma maquina.  
Para este primer commit, que se esta es iniciando el proyecto, he creado la estructura inicial del proyecto y la pantalla principal (menu).

---

## 2. Funcionalidades implementadas
- Estructura basica del proyecto en JavaFX
- Ventana principal funcional
- Menu inicial con botones:
  - Iniciar juego
  - Salir

---

## 3. Requisitos previos
Para ejecutar este proyecto es necesario contar con:

- Java JDK 17 o superior
- JavaFX SDK
- IDE recomendado: IntelliJ IDEA o NetBeans

---

## 4. Cómo ejecutar el proyecto

1. Abrir el proyecto en el IDE
2. Configurar JavaFX (si es necesario)
3. Ejecutar la clase `Main.java`

---

## 5. Estructura del proyecto

- `Main.java`: Clase principal que inicia la aplicacion
- `MenuController.java`: Controlador del menu principal
- `ControladorJuego.java`: Controlador del juego (estructura inicial)
- `Tablero.java`: Representa el tablero (estructura inicial)
- `Ficha.java`: Representa una ficha (estructura inicial)
- `menu.fxml`: Interfaz grafica del menu
---

## 6. Decisiones de diseño

## 6. Decisiones de diseño

Decidi utilizar JavaFX junto con Scene Builder para la construcción de la interfaz grafica, aplicando el patron de diseño MVC (Modelo-Vista-Controlador).  

Este patron permite separar la logica del juego (modelo), la interfaz grafica (vista) y la interaccion del usuario (controlador), facilitando la organizacion del codigo y su mantenimiento.
---

## 7. Autor

Nombre: [Gregoriannys Rosa Riveras]  
Fecha: [2/4/2026]