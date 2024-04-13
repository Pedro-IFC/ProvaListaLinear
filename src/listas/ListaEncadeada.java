package listas;

import nodo.Nodo;

public class ListaEncadeada {
    private Nodo<?> start;
    private int size;
    private int limite=-1;
    public ListaEncadeada(int limite) {
		this.limite = limite;
	}
	public Object get(int posicao) {
        if (posicao < size) {
            Nodo<?> aux = start;
            int index = 0;
            while (aux != null) {
                if (index == posicao) {
                    return aux.getDado();
                }
                index++;
                aux = aux.getProximo();
            }
        }
        System.out.println("Index out of range");
        return null;
    }

    public <T> void add(T dado) {
		if(hasSpace()) {
			if(size==0) {
				start = new Nodo<T>(dado);
			}else {
				Nodo<?> aux = new Nodo<T>(dado);
				Nodo<?> last = (Nodo<?>) start;
				while(aux.getProximo()!=null) {
					last=last.getProximo();
				}
				last.setProximo(aux);
			}
			size++;
		}else {
			System.out.println("Limite atingido, não inserido: " + dado);
		}
    }
    public boolean hasSpace() {
    	return size<limite || limite<0;
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
