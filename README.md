# retos-listas-camarillo-mata

# Retos con listas simples, dobles y circulares 
 
## Integrantes - Camarillo Solano Angel Nahum - Mata Ruiz Noemi
 
## Datos de la actividad 
Estructura de datos
Gabriel Barron Rodriguez 
Jueves 22 de Octubre 2026
versión asignada A. 
 
## Conceptos aprendidos 
Explique con sus palabras: 

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

 
## Reto 1 - Qué se pidió y cómo lo resolvió (explique cada TODO). - Captura de compilación y ejecución. 

Qué se pidió: completar insertarFinal, buscar y eliminar en una lista simple de libros y probarlas en el main con libros propios.

Cómo se resolvió cada TODO:

TODO 1 (insertarFinal, lista vacía): cabeza = nuevo;. Si no hay nada, el nuevo nodo es el primero y la cabeza debe apuntar a él.
TODO 2 (condición del while): actual.siguiente != null. Queremos detenernos en el último nodo, no pasarnos a null; por eso se pregunta por actual.siguiente y no por actual.
TODO 3 (enlazar al final): actual.siguiente = nuevo;. El último nodo ahora apunta al nuevo, que ya tiene siguiente = null.
TODO 4 (buscar): if (actual.libro.equals(libro)) return true;. Se usa equals y no == porque == compara referencias y equals compara el texto. Si el ciclo termina sin encontrarlo, el return false final se encarga.
TODO 5 (eliminar la cabeza): cabeza = cabeza.siguiente;. Basta con mover la cabeza al segundo nodo; el primero queda sin referencias.
TODO 6 (¿el siguiente es el que busco?): actual.siguiente.libro.equals(libro). Nos paramos en el nodo anterior al que queremos borrar, porque es el que debemos modificar.
TODO 7 (saltar el nodo): actual.siguiente = actual.siguiente.siguiente;. El nodo anterior se salta al eliminado y apunta directamente al que sigue.

Pruebas en main: se agregaron al menos 4 libros propios, se buscó uno existente y uno inexistente, y se eliminó la cabeza, un nodo intermedio y el último.

Capturas:

 
## Reto 2 
(Misma estructura) 
 
## Reto 3 
(Misma estructura) 
 
## Reflexión final (mínimo 5 líneas por pregunta) 
1. ¿Qué punteros tuvieron que actualizar en la eliminación de una lista doble y por 
qué son más que en la simple? 
2. ¿Qué error cometieron (o evitaron) por no considerar el caso de lista vacía o de 
un solo nodo? 
3. ¿Qué pasaría si en la lista circular se recorre con while (actual != null)? 
4. ¿En qué situación elegirían cada tipo de lista? 
5. ¿Qué fue lo más difícil y cómo lo resolvieron como bina? 
 
## Cómo compilar y ejecutar 
Comandos javac/java usados.
