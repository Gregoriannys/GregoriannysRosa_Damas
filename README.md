# GregoriannysRosa_Damas
Proyecto final, programacion3, juego damas.


# Juego de Damas

## 1. Descripción del proyecto
Este proyecto consiste en el desarrollo de un juego de damas para dos jugadores en una misma maquina.  
Para este cuarto avence, se han completado las reglas logicas avanzadas, se ha implementado la deteccion de victoria y se realizo una mejora a lo que es su interfaz grafica con un estilo visual tipoNeon, ademas de incorporar animaciones que mejoran significativamente la experiencia del usuario.

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

- Captura multiple: implementacion en `ControladorJuego`. Si una ficha captura y puede seguir capturando, el turno se mantiene y se bloquea la seleccion a esa pieza.
- Deteccion de fin de juego: Metodos logicos en la clase Tablero para determinar el ganador:

- contarFichas: Seguimiento en tiempo real de las piezas restantes.

- tieneMovimientos: Verificación de bloqueo (si un jugador no tiene movimientos válidos, pierde).

- finalDelJuego y obtenerGanador: Validación automática del estado de la partida.

- Actualización Dinámica de UI: El sistema ahora detecta el ganador y lo muestra con un resaltado especial (color Oro) en la interfaz.

- Animación de movimiento de fichas:
- Las piezas se desplazan suavemente entre casillas en lugar de cambiar instantáneamente
- Implementado con TranslateTransition de JavaFX
- Mejora en la interacción:
   - Sensación más fluida y natural al jugar
  - Mayor realismo visual en cada movimiento

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
- `ControladorJuego.java`: Controla la logica de turnos y el control de capturas multiples.
- `Tablero.java`: Maneja el estado del tablero y movimientos validos 
- `Ficha.java`: Define las propiedades de las piezas (Blanco/Negro).
- `menu.fxml`: Interfaz grafica del menu
- `juego.fxml`: Interfaz grafica del juego (tablero y panel lateral), creados mediante Scene builder.
---



## 6. Decisiones de diseño

Decidi utilizar JavaFX junto con Scene Builder para la construcci0n de la interfaz grafica, aplicando el patron de diseño MVC (Modelo-Vista-Controlador).  

Este patron permite separar: 
- Modelo: clases como tablero y ficha (logica del juego)
- Vista: archivos FXML (interfaz grafica)
- Controlador: clases como juegoController y MenuController (interaccion).

- se ha profundizado en la experiencia visual y la robustez de la logica:

- Identidad Visual: Se abandonaron los  colores planos por un estilo Neon para darle un aspecto mas cercano a un videojuego moderno.

- Interactividad: El uso de transiciones de opacidad al iniciar el menu busca que la aplicación no se sienta estatica.

- Fluidez del Juego: Las animaciones de movimiento aportan continuidad visual, evitando cambios bruscos en el tablero.
---

## 7. Autor

Nombre: [Gregoriannys Rosa Riveras]  
Fecha: [11/4/2026]