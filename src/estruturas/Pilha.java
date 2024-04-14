package estruturas;

import nodo.Nodo;

public class Pilha implements EstruturaGenerica {
	private Nodo<?> topo;
    private int size;
    private int limite = -1;
	public boolean remove(int posicao) {
		if(size>0) {
			this.size--;
			topo = topo.getProximo();
			return true;
		}else {
			return false;
		}
	}
	public Object get(int posicao) {
		return topo.getDado();
	}
	public <T> boolean set(int posicao, T dado) {
        Nodo<?> nodoPos = topo;
        Nodo<?> novo = new Nodo<>(dado);
    	this.topo=novo;
    	topo.setProximo(nodoPos);
        return true;
	}
	public Nodo<?> getNodo(int posicao) {
		return topo;
	}
	public <T> boolean add(T dado) {
		if(hasSpace()) {
			Nodo<?> atual = new Nodo<T>(dado);
			size++;
			if(getTopo()!=null) {
				atual.setProximo(topo);
			}
			setTopo(atual);	
			return true;
		}else {
			System.out.println("Limite atingido");
			return false;
		}
	}
    public boolean hasSpace() {
        return limite < 0 || size < limite;
    }
	public int getSize() {
		return 0;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Nodo<?> getTopo() {
		return topo;
	}
	public void setTopo(Nodo<?> start) {
		this.topo = start;
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}

}
