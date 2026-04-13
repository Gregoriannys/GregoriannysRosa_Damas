# GregoriannysRosa_Damas
- Proyecto final, programacion3, juego damas.


# Juego de Damas

## 1. Descripción del proyecto
Este proyecto consiste en el desarrollo de un juego de damas para dos jugadores en una misma maquina. El juego se ejecuta mediante una interfaz grafica desarrollada en JavaFX, permitiendo a los usuarios interactuar con el tablero a traves de clics para seleccionar y mover las fichas. 

- Funcionamiento y reglas principales:
- Cada jugador controla un conjunto de fichas (blancas y negras)
- Las fichas se mueven en diagonal sobre casillas oscuras
- Se pueden capturar fichas enemigas saltando sobre ellas
- Si una ficha llega al extremo opuesto del tablero, se convierte en dama (reina)
- Las damas pueden moverse en más direcciones que las fichas normales
- El juego termina cuando un jugador se queda sin fichas o sin movimientos válidos

- En esta version final del proyecto, se han implementado tanto las reglas completas del juego como mejoras visuales y animaciones que hacen la experiencia mas dinamica e intuitiva para el usuario.


## 2. Funcionalidades implementadas

### Base del sistema
- Estructura basica del proyecto en JavaFX  
- Ventana principal funcional  
- Menu inicial con opciones:
  - Iniciar juego  
  - Salir  
- Navegacion entre pantallas (menu-juego)  
- Interfaz grafica construida con Scene Builder  
- Tablero dinamico de 8x8 usando GridPane  
- Panel lateral con informacion (turno y ganador)  
- Botones de reinicio y regreso al menu 

---

### Logica del juego
- Inicializacion del tablero con fichas en posiciones correctas  
- Seleccion de fichas mediante clic  
- Movimiento diagonal de fichas  
- Validacion de movimientos permitidos  
- Captura basica de fichas enemigas  
- Resaltado visual de:
  - Ficha seleccionada  
  - Movimientos validos disponibles  

---

### Reglas implementadas
- Captura multiple:
  - Implementada en ControladorJuego  
  - Si una ficha puede seguir capturando, el turno no cambia  

- Deteccion de fin de juego:
  - contarFichas: seguimiento de piezas restantes  
  - tieneMovimientos: verifica si un jugador esta bloqueado  
  - esFinDeJuego: determina si la partida termino  
  - obtenerGanador: define el ganador automaticamente  

- Actualizacion dinamica de la interfaz:
  - El sistema detecta el ganador y lo muestra en pantalla con resaltado especial  

---

### Animaciones 
- Movimiento animado de fichas utilizando TranslateTransition  
- Transiciones suaves entre casillas (evita cambios bruscos)  
- Mejora notable en la fluidez del juego  
- Experiencia visual mas natural y dinamica  


---

### Sistema de Damas (Reinas) 
- Coronación automatica:
  - Ficha blanca se convierte en dama al llegar a la fila 0  
  - Ficha negra se convierte en dama al llegar a la fila 7  

- Diferenciacion visual:
  - Representadas con un circulo interno dorado  
  - Borde resaltado para distinguirlas de las fichas normales  
  - Permite identificar facilmente piezas de mayor jerarquia  

- Mejora en la experiencia:
  - Mayor claridad visual en el tablero  
  
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

Decidi utilizar JavaFX junto con Scene Builder para la construccion de la interfaz grafica, aplicando el patron de diseño MVC (Modelo-Vista-Controlador).  

Este patron permite separar: 
- Modelo: clases como tablero y ficha (logica del juego)
- Vista: archivos FXML (interfaz grafica)
- Controlador: clases como juegoController y MenuController (interaccion).

- Identidad visual: estilo Neon para una apariencia moderna  
- Interactividad: transiciones para evitar una interfaz estática  
- Fluidez: animaciones que mejoran la experiencia de juego  
- Claridad visual: diferenciación de fichas normales y damas  
---

## 7. Autor

Nombre: [Gregoriannys Rosa Riveras]  
Fecha: [12/4/2026]

