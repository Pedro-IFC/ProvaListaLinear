package listas;

import nodo.Nodo;

public class ListaEncadeada implements EstruturaGenerica {
    private Nodo<?> start;
    private int size;
    private int limite = -1;

    public ListaEncadeada() {}

    public ListaEncadeada(int limite) {
        this.limite = limite;
    }

    public boolean remove(int posicao) {
        if (posicao < 0 || posicao >= size) {
            System.out.println("Index out of range");
            return false;
        }

        if (posicao == 0) {
            start = start.getProximo();
        } else {
            Nodo<?> aux = getNodo(posicao);
            aux.getAnterior().setProximo(aux.getProximo());
            if (aux.getProximo() != null) {
                aux.getProximo().setAnterior(aux.getAnterior());
            }
        }
        size--;
        return true;
    }

    public Nodo<?> getNodo(int posicao) {
        if (posicao < 0 || posicao >= size) {
            System.out.println("Index out of range");
            return null;
        }

        Nodo<?> aux = start;
        for (int index = 0; index < posicao; index++) {
            aux = aux.getProximo();
        }
        return aux;
    }

    public Object get(int posicao) {
        Nodo<?> nodo = getNodo(posicao);
        return nodo != null ? nodo.getDado() : null;
    }

    public <T> boolean set(int posicao, T dado) {
        Nodo<?> nodoAnt = getNodo(posicao).getAnterior();
        Nodo<?> nodoPos = getNodo(posicao).getProximo();
        Nodo<?> novo = new Nodo<>(dado);
        if(nodoAnt!=null) {
            nodoAnt.setProximo(novo);
            novo.setAnterior(nodoAnt);
        }
        if(nodoPos!=null) {
            nodoPos.setAnterior(novo);
            novo.setProximo(nodoPos);
        }
        if(posicao==0) {
        	this.start=novo;
        }
        return nodoAnt!=null||nodoPos!=null||posicao==0;
    }
    
    public <T> boolean add(T dado) {
        if (!hasSpace()) {
            System.out.println("Limite atingido, não inserido: " + dado);
            return false;
        }

        Nodo<?> novo = new Nodo<>(dado);
        if (size == 0) {
            start = novo;
        } else {
            Nodo<?> last = start;
            while (last.getProximo() != null) {
                last = last.getProximo();
            }
            last.setProximo(novo);
            novo.setAnterior(last);
        }
        size++;
        return true;
    }

    public boolean hasSpace() {
        return limite < 0 || size < limite;
    }

    public int getSize() {
        return size;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
}
