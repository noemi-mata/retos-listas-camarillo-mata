# Retos con listas simples, dobles y circulares 
 
## Integrantes - Camarillo Solano Angel Nahum - Mata Ruiz Noemi
 
## Datos de la actividad 
Estructura de datos

Gabriel Barron Rodriguez 

Jueves 22 de Octubre 2026

versión asignada A. 
 
## Conceptos aprendidos 

## lista simple 
Cada nodo guarda su dato y una referencia al siguiente. Solo se puede avanzar en un sentido, desde la cabeza hasta null.

Ventajas: es la más sencilla, usa poca memoria (un puntero por nodo) y insertar al inicio es muy rápido (O(1)).

Desventajas: no se puede retroceder; para insertar o eliminar al final hay que recorrer toda la lista (O(n)) y, al eliminar, hay que tener cuidado de no perder la referencia al nodo anterior.

Ejemplo real: una pila de pantallas por las que va pasando una aplicación, o un catálogo sencillo de libros que casi solo se recorre de principio a fin.

## lista doble 

Cada nodo guarda dato, siguiente y anterior. Se puede recorrer hacia adelante y hacia atrás.

Ventajas: se puede recorrer en ambos sentidos y eliminar un nodo que ya tenemos es más directo, porque el nodo sabe quién es su anterior.

Desventajas: usa más memoria (dos punteros por nodo) y hay que mantener dos enlaces correctos por cada conexión; si se olvida actualizar uno, la lista queda corrupta.

Ejemplo real: el historial del navegador (ir atrás / ir adelante) o el historial de lectura de libros.

## lista circular 

El último nodo apunta de regreso al primero, así que no existe null al final. Puede ser simple o doble.

Ventajas: ideal para cosas que se repiten en ciclo, porque nunca "se acaba"; llegar de la cola a la cabeza es inmediato.

Desventajas: el riesgo principal es el ciclo infinito si se recorre con while (actual != null); hay que recorrer con do { ... } while (actual != cabeza).

Ejemplo real: turnos de un juego, la cola de préstamo de un libro entre estudiantes, o una playlist en bucle.

---------------------------------------------------------------------------------------------------------------------------------------
## Reto 1 - Qué se pidió y cómo lo resolvió (explique cada NODO). - Captura de compilación y ejecución. 

Qué se pidió: completar insertarFinal, buscar y eliminar en una lista simple de libros y probarlas en el main con libros propios.

Cómo se resolvió cada NODO:

NODO 1 (insertarFinal, lista vacía): cabeza = nuevo;. Si no hay nada, el nuevo nodo es el primero y la cabeza debe apuntar a él.

NODO 2 (condición del while): actual.siguiente != null. Queremos detenernos en el último nodo, no pasarnos a null; por eso se pregunta por actual.siguiente y no por actual.

NODO 3 (enlazar al final): actual.siguiente = nuevo;. El último nodo ahora apunta al nuevo, que ya tiene siguiente = null.

NODO 4 (buscar): if (actual.libro.equals(libro)) return true;. Se usa equals y no == porque == compara referencias y equals compara el texto. Si el ciclo termina sin encontrarlo, el return false final se encarga.

NODO 5 (eliminar la cabeza): cabeza = cabeza.siguiente;. Basta con mover la cabeza al segundo nodo; el primero queda sin referencias.

NODO 6 (¿el siguiente es el que busco?): actual.siguiente.libro.equals(libro). Nos paramos en el nodo anterior al que queremos borrar, porque es el que debemos modificar.

NODO 7 (saltar el nodo): actual.siguiente = actual.siguiente.siguiente;. El nodo anterior se salta al eliminado y apunta directamente al que sigue.

Pruebas en main: se agregaron al menos 4 libros propios, se buscó uno existente y uno inexistente, y se eliminó la cabeza, un nodo intermedio y el último.

Capturas:


Ejecucion:


<img width="598" height="241" alt="reto1-ejecucion" src="https://github.com/user-attachments/assets/6c5e6fb4-f02f-427c-b0bb-10fd02e6ab95" />

Compilacion:


<img width="470" height="44" alt="reto1-compilacion" src="https://github.com/user-attachments/assets/49789892-18e3-4c6d-b5b3-962708f18a2a" />

 
## Reto 2 

Qué se pidió: completar la inserción al inicio, la eliminación de un nodo (ajustando los enlaces en ambos sentidos), el recorrido hacia adelante y el recorrido inverso.

Cómo se resolvió cada NODO:

NODO 1 (lista vacía): la cabeza y la cola apuntan al mismo nodo nuevo, porque con un solo elemento es a la vez primero y último.

NODO 2: el siguiente del nodo nuevo se enlaza con la cabeza actual.

NODO 3: el anterior de la cabeza actual se enlaza con el nodo nuevo, para que la conexión funcione también hacia atrás.

NODO 4: la cabeza de la lista se actualiza al nodo nuevo. Se deja para el final a propósito: primero se hacen los enlaces y después se mueve la cabeza.

NODO 5 (enlace del nodo anterior): si el nodo a eliminar tiene anterior, ese anterior pasa a apuntar al siguiente del eliminado. Si no tiene anterior, significa que era la cabeza, por lo que la cabeza de la lista pasa a ser el siguiente.

NODO 6 (enlace del nodo siguiente): si el nodo a eliminar tiene siguiente, ese siguiente pasa a apuntar al anterior del eliminado. Si no tiene siguiente, significa que era la cola, por lo que la cola de la lista pasa a ser el anterior.

Recorrido hacia adelante: se empieza en la cabeza, se imprime cada libro y se avanza con el siguiente hasta llegar al final.

NODO 7 (recorrido inverso): se empieza en la cola, se imprime cada libro y se retrocede con el anterior hasta llegar al inicio.


Pruebas en main: se insertaron libros propios al inicio, se mostró la lista en ambos sentidos y se eliminó la cabeza, un nodo intermedio y la cola, comprobando que los dos recorridos siguieran coincidiendo.

Capturas:


Ejecucion:


<img width="652" height="252" alt="reto2-ejecucion" src="https://github.com/user-attachments/assets/9736316e-e2d8-45e0-b59b-9136826482b5" />


Compilacion:


<img width="521" height="46" alt="reto2-compilacion" src="https://github.com/user-attachments/assets/ea10bc09-bc01-4b84-8a8b-c6bf39f20a4a" />
 
## Reto 3 

Qué se pidió: completar la inserción, el recorrido de una sola vuelta, el conteo de estudiantes y la eliminación del estudiante que sigue después de uno indicado.

Cómo se resolvió cada NODO:

NODO 1 (un solo nodo): la cabeza y la cola son el nuevo nodo, y su siguiente apunta a sí mismo. Así el círculo queda cerrado desde el primer estudiante.

NODO 2: la cola actual se enlaza con el nuevo estudiante.

NODO 3: el nuevo estudiante se enlaza con la cabeza para cerrar el círculo y se convierte en la nueva cola.

NODO 4 (avanzar en el recorrido): el nodo actual pasa a ser su siguiente.

NODO 5 (condición para detenerse): se repite mientras el nodo actual no sea la cabeza, es decir, se termina al completar una vuelta. Se usa un ciclo que primero procesa y luego pregunta, para que el primer nodo sí se imprima aunque al empezar el actual ya sea la cabeza.

NODO 6 (contar): si la lista está vacía se devuelve cero; si no, se recorre una vuelta completa sumando uno por cada nodo y deteniéndose al regresar a la cabeza, con lo que se evita el ciclo infinito.

NODO 7 (eliminar al que sigue de un estudiante indicado): primero se ubica al estudiante indicado dando como máximo una vuelta; si no aparece, no se hace nada. Luego se cuidan los casos pedidos:

Un solo nodo: la lista queda vacía, con cabeza y cola nulas.

El eliminado es la cabeza: el estudiante indicado salta a quien sigue después del eliminado y la cabeza avanza a ese nodo.

El eliminado es la cola: el estudiante indicado salta al eliminado y pasa a ser la nueva cola, conservando el enlace hacia la cabeza.

Caso intermedio: simplemente se salta al eliminado.


Pruebas en main: se agregaron estudiantes propios, se mostró una vuelta, se contó la lista y se eliminaron turnos en distintas posiciones, incluyendo el caso de quedar un solo estudiante.

Capturas:


Ejecucion:


<img width="519" height="118" alt="reto3-ejecucion" src="https://github.com/user-attachments/assets/93aa18aa-a010-4911-9dfe-38f52c7cb746" />


compilacion:


<img width="462" height="45" alt="reto3-complacion" src="https://github.com/user-attachments/assets/f1ffd957-599c-4585-8641-20d71a144360" />


## Reflexión final (mínimo 5 líneas por pregunta) 
#### 1. ¿Qué punteros tuvieron que actualizar en la eliminación de una lista doble y por qué son más que en la simple?
En la lista doble, al eliminar un nodo hay que actualizar dos enlaces vecinos: el siguiente del nodo anterior y el anterior del nodo siguiente. Además, si el nodo eliminado era la cabeza o la cola, hay que mover también esas referencias de la lista. En la lista simple solo se cambia un puntero: el siguiente del nodo previo. La diferencia existe porque cada conexión en una lista doble está guardada dos veces, una en cada sentido, y las dos copias deben coincidir. Si solo se arregla una, recorrer hacia adelante puede funcionar pero hacia atrás puede llevar a un nodo que ya no pertenece a la lista, o incluso provocar un error. Por eso conviene dibujar los nodos en papel y revisar los dos sentidos. A cambio de este trabajo extra, ya no hace falta recorrer la lista para encontrar al anterior, porque el propio nodo lo conoce.

#### 2. ¿Qué error cometieron (o evitaron) por no considerar el caso de lista vacía o de un solo nodo? 
Un error muy fácil es intentar acceder a un dato o a un siguiente cuando la lista está vacía, lo que provoca un error de referencia nula. Por eso en la inserción y la eliminación se revisa primero si la lista está vacía. Con un solo nodo, el riesgo es olvidar que ese nodo es a la vez cabeza y cola: en la lista doble, al eliminarlo hay que dejar ambas vacías, y en la lista circular, un solo nodo apunta a sí mismo, y si no se trata aparte, el programa puede quedarse dando vueltas o dejar la cola apuntando a un nodo ya eliminado. Lo comprobamos probando en el main los casos borde a propósito: lista vacía, un solo elemento, eliminar la cabeza y eliminar la cola. Así vimos que los casos especiales no son opcionales, porque es justo donde más fallan las listas.

#### 3. ¿Qué pasaría si en la lista circular se recorre con while (actual != null)? 
El programa nunca terminaría. En una lista circular ningún nodo tiene un siguiente nulo, porque el último apunta de regreso al primero, así que la condición siempre sería verdadera y el ciclo se repetiría indefinidamente, imprimiendo los mismos elementos una y otra vez hasta que se interrumpa el programa. Por eso el recorrido correcto procesa un nodo, avanza y se detiene cuando vuelve a la cabeza. Se usa un ciclo que primero ejecuta y luego pregunta para que el primer nodo sí se procese, ya que al empezar el nodo actual ya es igual a la cabeza y, si se preguntara antes, el recorrido terminaría sin hacer nada. Este es el error más típico en las listas circulares y la razón por la que siempre hay que revisar con cuidado la condición de paro.

#### 4. ¿En qué situación elegirían cada tipo de lista? 
Elegiríamos la lista simple cuando solo necesitamos recorrer en un sentido y queremos ahorrar memoria, por ejemplo un catálogo de libros que se consulta de principio a fin, o una pila. Elegiríamos la lista doble cuando se necesita ir y volver, como el historial de lectura o el historial de un navegador, o cuando se eliminan nodos con frecuencia y queremos hacerlo sin buscar al anterior. Elegiríamos la lista circular cuando los elementos se repiten en ciclo, como los turnos de préstamo de un libro, el turno de los jugadores en un juego o una lista de reproducción en bucle. La decisión depende de qué operaciones se harán más seguido: si importa la memoria y la sencillez, simple; si importa la flexibilidad al recorrer y eliminar, doble; si importa la repetición continua, circular.

#### 5. ¿Qué fue lo más difícil y cómo lo resolvieron como bina? 
Lo más difícil fue la eliminación en la lista doble y en la circular, porque hay varios casos (cabeza, cola, nodo intermedio y un solo nodo) y es fácil dejar un puntero sin actualizar. Lo resolvimos dibujando los nodos en papel, siguiendo los punteros con el dedo antes de escribir el código y repartiéndonos el trabajo: uno escribía la solución de un reto mientras el otro la revisaba con casos de prueba en el main. Cuando algo fallaba, mostrábamos la lista después de cada operación para ver exactamente dónde se rompía el enlace. También nos ayudó hacer commits pequeños después de completar cada método, para poder volver atrás si algo salía mal, y explicarnos mutuamente cada parte, ya que cualquiera de los dos puede ser interrogado en la revisión oral.
 
## Cómo compilar y ejecutar 
Comandos javac/java usados.

Desde la carpeta retos-listas-camarillo-mata, para cada reto se compila con 
javac src/RetoN.java 
y se ejecuta con 
java src.RetoN 
donde N lo sustituyes por 1, 2 o 3 dependiendo de que reto quieras ejecutar
