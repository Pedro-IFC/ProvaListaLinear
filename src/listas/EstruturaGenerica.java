package listas;

import nodo.Nodo;

public interface EstruturaGenerica{
	public boolean remove(int posicao);
	public Object get(int posicao);
	public <T> boolean set(int posicao, T dado);
	public Nodo<?> getNodo(int posicao);
    public <T> boolean add(T dado);
    public int getSize();
}
