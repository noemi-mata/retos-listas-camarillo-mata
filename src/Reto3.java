package src;

public class Reto3 {

    // Clase NodoCircular interna
    static class NodoCircular {
        String estudiante;
        NodoCircular siguiente;

        NodoCircular(String estudiante) {
            this.estudiante = estudiante;
        }
    }

    // Clase de la Lista Circular
    static class ListaCircular {
        private NodoCircular cabeza, cola;

        public void insertar(String estudiante) {
            NodoCircular nuevo = new NodoCircular(estudiante);
            if (cabeza == null) {
                cabeza = cola = nuevo;
                // TODO 1: Cuando solo hay uno, su siguiente apunta a sí mismo para cerrar el círculo
                cabeza.siguiente = cabeza;
            } else {
                // TODO 2: La cola actual apunta al nuevo nodo
                cola.siguiente = nuevo;
                // TODO 3: El nuevo apunta a la cabeza y actualizamos la cola
                nuevo.siguiente = cabeza;
                cola = nuevo;
            }
        }

        public void mostrarUnaVuelta() {
            if (cabeza == null) {
                System.out.println("null");
                return;
            }
            NodoCircular actual = cabeza;
            do {
                System.out.print(actual.estudiante + " -> ");
                // TODO 4: Avanzamos con .siguiente
                actual = actual.siguiente;
            } while (actual != cabeza); // TODO 5: Paramos cuando 'actual' le da la vuelta y llega otra vez a la cabeza
            System.out.println("(vuelve a " + cabeza.estudiante + ")");
        }

        public int contar() {
            if (cabeza == null) return 0;
            int contador = 0;
            NodoCircular actual = cabeza;
            do {
                contador++;
                // TODO 6: Contamos recorriendo con do-while para no atorarnos en un bucle infinito
                actual = actual.siguiente;
            } while (actual != cabeza);
            return contador;
        }

        // Elimina al estudiante que sigue después del indicado
        public void eliminarSiguienteDe(String estudiante) {
            // TODO 7: Buscar al estudiante, saltar su .siguiente y cuidar los casos borde
            if (cabeza == null) return;
            NodoCircular actual = cabeza;
            do {
                if (actual.estudiante.equals(estudiante)) {
                    NodoCircular aEliminar = actual.siguiente;
                    if (aEliminar == cabeza && aEliminar == cola) { // Un solo nodo
                        cabeza = cola = null;
                    } else {
                        actual.siguiente = aEliminar.siguiente;
                        if (aEliminar == cabeza) cabeza = actual.siguiente;
                        if (aEliminar == cola) cola = actual;
                    }
                    break;
                }
                actual = actual.siguiente;
            } while (actual != cabeza);
        }
    }

    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        // Agregamos estudiantes de prueba
<<<<<<< HEAD
        lista.insertar("Ana");
        lista.insertar("Carlos");
        lista.insertar("Sofía");
        lista.insertar("Mateo");
=======
        lista.insertar("Luis");
        lista.insertar("Teodora");
        lista.insertar("Sofía");
        lista.insertar("Kirk");
>>>>>>> a08e349eb638a1875a68cb14b034d90381fc27b6

        System.out.println("- LISTA CIRCULAR DE ESTUDIANTES -");
        lista.mostrarUnaVuelta();

        System.out.println("\nTotal de estudiantes en el círculo: " + lista.contar());

<<<<<<< HEAD
        System.out.println("\nEliminando al estudiante que sigue de 'Ana' (debería ser Carlos)...");
        lista.eliminarSiguienteDe("Ana");
=======
        System.out.println("\nEliminando al estudiante que sigue de 'Luis' (debería ser Teodora)...");
        lista.eliminarSiguienteDe("Luis");
>>>>>>> a08e349eb638a1875a68cb14b034d90381fc27b6
        lista.mostrarUnaVuelta();

        System.out.println("Total de estudiantes actual: " + lista.contar());
    }
}