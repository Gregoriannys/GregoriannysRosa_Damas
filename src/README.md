# Juego de Damas

## 1. Descripción del proyecto
Este proyecto consiste en el desarrollo de un juego de damas para dos jugadores en una misma maquina.  
Para este tercer avence, se ha implementado la logica principal del juego, permitiendo la interaccion entre el usuario y el tablero, asi como el movimiento de las fichas de acuerdo con las reglas basicas.

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

- Inicializacion del tablero con las fichas en su posicion correcta
- Seleccion de fichas mediante clic
- Movimiento de fichas en diagonal
- Validacion de movimientos permitidos
- Captura basica de fichas enemigas
- Resaltado visual de: 
   - Ficha seleccionada
   - Movimientos validos disponibles


---

## 3. Requisitos previos
Para ejecutar este proyecto es necesario contar con:

- Java JDK 17 o superior
- JavaFX SDK
- IDE recomendado: Visual Studio Code(con Extension Pack for java), IntelliJ IDEA o NetBeans.

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
- `ControladorJuego.java`: Controla la logica del juego(seleccion, movimiento y turnos)
- `Tablero.java`: Maneja el estado del tablero y movimientos validos 
- `Ficha.java`: Representa una ficha del juego
- `menu.fxml`: Interfaz grafica del menu
- `juego.fxml`: Interfaz grafica del juego (tablero y panel lateral)
---



## 6. Decisiones de diseño

Decidi utilizar JavaFX junto con Scene Builder para la construcción de la interfaz grafica, aplicando el patron de diseño MVC (Modelo-Vista-Controlador).  

Este patron permite separar: 
- Modelo: clases como tablero y ficha (logica del juego)
- Vista: archivos FXML (interfaz grafica)
- Controlador: clases como juegoController y MenuController (interaccion).

En este commit, la logica implementada se enfoca unicamente en el funcionamiento del juego, dejando las validaciones avanzadas y el manejo de estados finales para el siguiente avance.
---

## 7. Autor

Nombre: [Gregoriannys Rosa Riveras]  
Fecha: [9/4/2026]