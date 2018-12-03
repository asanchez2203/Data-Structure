package Ejercicio30;

import java.util.Iterator;

class ListaDeIds {

    Lista ids;

    ListaDeIds() {
        ids = new Lista();
    }

    public void insertar(String identificador, Integer linea) {
        boolean encontre = false;

        Iterator it = ids.iterador();

        while (it.hasNext() && !encontre) {
            IdyLista id = (IdyLista) it.next();
            if (id.obtenerNombre().equals(identificador)) {
                Lista lis = id.obtenerLista();
                lis.agregar(linea);
                encontre = true;
            }
        }
        //No est� este identificador
        if (!encontre) {
            Lista lis = new Lista();
            lis.agregar(linea);
            ids.agregar(new IdyLista(identificador, lis));
        }
    }

    public void imprimir() {
        for (Iterator it = ids.iterador(); it.hasNext();) {
            IdyLista idLista = (IdyLista) it.next();
            System.out.print(idLista.obtenerNombre() + ": ");
            Lista lista = idLista.obtenerLista();
            for (Iterator ilista = lista.iterador(); ilista.hasNext();) {
                System.out.print(ilista.next() + ", ");
            }
            System.out.println();
        }
    }

    private class ComparadorNyL implements java.util.Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            String oo1 = ((IdyLista) o1).obtenerNombre();
            String oo2 = (String) o2;
            return oo1.compareToIgnoreCase(oo2);
        }
    }

}
