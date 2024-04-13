package nodo;

public class Nodo<T> {
	private T dado;
	private Nodo<?> proximo=null;
	public Nodo(T dado) {
		super();
		this.dado = dado;
	}
	public T getDado() {
		return dado;
	}
	public void setDado(T dado) {
		this.dado = dado;
	}
	public Nodo<?> getProximo() {
		return proximo;
	}
	public void setProximo(Nodo<?> aux) {
		this.proximo = aux;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nodo [dado=");
		builder.append(dado);
		builder.append("]");
		return builder.toString();
	}	
	
}
