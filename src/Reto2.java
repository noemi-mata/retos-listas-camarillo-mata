/**
* U2 ARLSDCVerA: Biblioteca de libros
* @date 22 de octubre del 2026
* @name Camarillo Solano Ángel Nahúm
*/

package src;

public class Reto2 {

    // Clase NodoDoble interna para que pueda compilar y ejecutar con el nombre de Reto2.java
    static class NodoDoble {
        String libro;
        NodoDoble siguiente, anterior;

        NodoDoble(String libro) {
            this.libro = libro;
        }
    }

    // Clase de la Lista Doblemente Enlazada
    static class ListaDoble {
        private NodoDoble cabeza, cola;

        // Inserta un libro al inicio de la lista
        public void insertarInicio(String libro) {
            NodoDoble nuevo = new NodoDoble(libro);
            if (cabeza == null) {
                // TODO 1: Si la lista está vacía, cabeza y cola apuntan al nuevo nodo
                cabeza = cola = nuevo;
            } else {
                // TODO 2: Enlazar nuevo.siguiente con la cabeza actual
                nuevo.siguiente = cabeza;
                // TODO 3: Enlazar cabeza.anterior con el nuevo
                cabeza.anterior = nuevo;
                // TODO 4: Actualizar la cabeza
                cabeza = nuevo;
            }
        }

        // Elimina un nodo buscando por el nombre del libro
        public boolean eliminar(String libro) {
            NodoDoble actual = cabeza;
            while (actual != null && !actual.libro.equals(libro)) {
                actual = actual.siguiente;
            }
            
            if (actual == null) return false;

            // TODO 5: Si 'actual' tiene anterior, su siguiente salta al de actual. Si no, actualizamos la cabeza
            if (actual.anterior != null) {
                actual.anterior.siguiente = actual.siguiente;
            } else {
                cabeza = actual.siguiente;
            }

            // TODO 6: Si 'actual' tiene siguiente, su anterior salta al anterior de actual. Si no, actualizamos la cola
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;
            } else {
                cola = actual.anterior;
            }

            return true;
        }

        // Muestra la lista hacia adelante
        public void mostrarAdelante() {
            NodoDoble actual = cabeza;
            while (actual != null) {
                System.out.print(actual.libro + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }

        // Muestra la lista de atrás hacia adelante (recorrido inverso)
        public void mostrarInverso() {
            NodoDoble actual = cola;
            while (actual != null) {
                // TODO 7: Imprima el libro y retroceda usando .anterior
                System.out.print(actual.libro + " -> ");
                actual = actual.anterior;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        ListaDoble historial = new ListaDoble();

        // Agregamos al menos 4 libros propios al historial
        historial.insertarInicio("Cien años de soledad");
        historial.insertarInicio("El Principito");
        historial.insertarInicio("1984");
        historial.insertarInicio("Don Quijote de la Mancha");

        System.out.println("--- HISTORIAL HACIA ADELANTE ---");
        historial.mostrarAdelante();

        System.out.println("\n--- HISTORIAL INVERSO (DESDE LA COLA) ---");
        historial.mostrarInverso();

        // Probando eliminaciones (cabeza, intermedio y cola)
        System.out.println("\nEliminando la cabeza ('Don Quijote de la Mancha')...");
        historial.eliminar("Don Quijote de la Mancha");
        historial.mostrarAdelante();

        System.out.println("\nEliminando un nodo intermedio ('1984')...");
        historial.eliminar("1984");
        historial.mostrarAdelante();

        System.out.println("\nEliminando la cola ('Cien años de soledad')...");
        historial.eliminar("Cien años de soledad");
        historial.mostrarAdelante();

        System.out.println("\n--- HISTORIAL FINAL INVERSO ---");
        historial.mostrarInverso();
    }
}
