# Juego de Damas

## 1. Descripción del proyecto
Este proyecto consiste en el desarrollo de un juego de damas para dos jugadores en una misma maquina.  
Para este segundo avence, se ha implementado la interfaz grafica del juego utilizando javaFX y Scene builder, incluyendo el tablero visual (8x8) y la navegacion desde el menu principal hacia la pantalla de juego.
---

## 2. Funcionalidades implementadas
- Estructura basica del proyecto en JavaFX
- Ventana principal funcional
- Menu inicial con botones:
  - Iniciar juego
  - Salir
- Navegacion entre pantallas(menu-juego)
- Interfaz grafica del juego creada con Scene builder
- Tablero visual de 8x8 generado dinamicamente con GridPane
- Panel lateral con informacion (turno y ganador)
- Botones de reinicio y regreso al menu (funcionales a nivel visual)

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

- `Main.java`: Clase principal que gestiona las escenas(menu y juego)
- `MenuController.java`: Controlador del menu principal
- `JuegoController.java`: Controlador de la interfazdel juego
- `ControladorJuego.java`: Controlador del juego (estructura inicial, sin logica aun)
- `Tablero.java`: Representa el tablero (estructura inicial)
- `Ficha.java`: Representa una ficha (estructura inicial)
- `menu.fxml`: Interfaz grafica del menu
- `juego.fxml`: Interfaz grafica del juego (tablero y panel lateral)
---



## 6. Decisiones de diseño

Decidi utilizar JavaFX junto con Scene Builder para la construcción de la interfaz grafica, aplicando el patron de diseño MVC (Modelo-Vista-Controlador).  

Este patron permite separar: 
- Modelo: clases como tablero y ficha (logica del juego)
- Vista: archivos FXML (interfaz grafica)
- Controlador: clases como juegoController y MenuController (interaccion).
---

## 7. Autor

Nombre: [Gregoriannys Rosa Riveras]  
Fecha: [2/4/2026]