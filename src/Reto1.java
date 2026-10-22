/**
* U2 ARLSDCVerA: Biblioteca de libros
* @date 22 de octubre del 2026
* @name Camarillo Solano Ángel Nahúm
*/

package src;


public class Reto1 {

    // Clase Nodo interna para que pueda compilar y correr Reto1.java
    static class Nodo {
        String libro;
        Nodo siguiente;

        Nodo(String libro) {
            this.libro = libro;
        }
    }

    // Clase de la Lista Simple
    static class ListaSimple {
        private Nodo cabeza;

        // Inserta un libro al final de la lista
        public void insertarFinal(String libro) {
            Nodo nuevo = new Nodo(libro);
            if (cabeza == null) {
                // TODO 1: Si la lista está vacía, el nuevo nodo es la cabeza
                cabeza = nuevo;
            } else {
                Nodo actual = cabeza;
                // TODO 2: Avanzamos hasta detenernos en el ÚLTIMO nodo
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                // TODO 3: Enlazamos el nuevo nodo al final
                actual.siguiente = nuevo;
            }
        }

        // Devuelve true si el libro existe
        public boolean buscar(String libro) {
            Nodo actual = cabeza;
            while (actual != null) {
                // TODO 4: Comparamos con equals y retornamos true si coincide
                if (actual.libro.equals(libro)) {
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }

        // Elimina la primera aparición del libro
        public boolean eliminar(String libro) {
            if (cabeza == null) return false;

            if (cabeza.libro.equals(libro)) {
                // TODO 5: Eliminar la cabeza haciéndola apuntar al siguiente
                cabeza = cabeza.siguiente;
                return true;
            }

            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                // TODO 6: Verificamos si el siguiente nodo es el que buscamos
                if (actual.siguiente.libro.equals(libro)) {
                    // TODO 7: Saltamos el nodo a eliminar
                    actual.siguiente = actual.siguiente.siguiente;
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }

        public void mostrar() {
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.print(actual.libro + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        // Agregamos al menos 4 libros propios
        lista.insertarFinal("El Principito");
        lista.insertarFinal("Cien años de soledad");
        lista.insertarFinal("Don Quijote de la Mancha");
        lista.insertarFinal("1984");

        System.out.println("--- CATÁLOGO INICIAL DE LIBROS ---");
        lista.mostrar();

        // Pruebas de búsqueda (existente e inexistente)
        System.out.println("\n¿Se encuentra '1984'?: " + lista.buscar("1984"));
        System.out.println("¿Se encuentra 'Harry Potter'?: " + lista.buscar("Harry Potter"));

        // Pruebas de eliminación (cabeza, intermedio y último)
        System.out.println("\n1. Eliminando la cabeza ('El Principito')...");
        lista.eliminar("El Principito");
        lista.mostrar();

        System.out.println("\n2. Eliminando un nodo intermedio ('Don Quijote de la Mancha')...");
        lista.eliminar("Don Quijote de la Mancha");
        lista.mostrar();

        System.out.println("\n3. Eliminando el último nodo ('1984')...");
        lista.eliminar("1984");
        lista.mostrar();

        System.out.println("\n--- CATÁLOGO FINAL ---");
        lista.mostrar();
    }
}
