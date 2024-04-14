package estruturas;

import nodo.Nodo;

public class Fila implements EstruturaGenerica  {
    private Nodo<?> start;
	private Nodo<?> end;
    private int size;
    private int limite = -1;
	public boolean remove(int posicao) {
		if(size>0) {
			start = start.getProximo();
			size--;
			if(size<=0)
				end = null;
			return true;
		}else {
			return false;
		}
	}
	public Object get(int posicao) {
		if(size>0)
			return this.start.getDado();
		return null;
	}
	public <T> boolean set(int posicao, T dado) {
        Nodo<?> nodoPos = start;
        Nodo<?> novo = new Nodo<>(dado);
    	this.start=novo;
    	start.setProximo(nodoPos);
        return true;
	}
	public Nodo<?> getNodo(int posicao) {
		if(size>0)
			return this.start;
		return null;
	}
	public <T> boolean add(T dado) {
		if(hasSpace()) {
			Nodo<?> novoItem = new Nodo<T>(dado);
			if(size<=0) {
				start = novoItem;
				end = novoItem;
			}else {
				end.setProximo(novoItem);
				end=novoItem;
			}
			size++;
			return true;
		}else {
			return false;
		}
	}
    public boolean hasSpace() {
        return limite < 0 || size < limite;
    }
	public int getSize() {
		return 0;
	}
	public Nodo<?> getStart() {
		return start;
	}
	public void setStart(Nodo<?> start) {
		this.start = start;
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Nodo<?> getEnd() {
		return end;
	}
	public void setEnd(Nodo<?> end) {
		this.end = end;
	}
	
}
