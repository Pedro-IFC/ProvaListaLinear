package nodo;

public class NodoDuplamenteEncadeado<T> extends Nodo<T> {
	private Nodo<T> anterior=null;
	public NodoDuplamenteEncadeado(T dado) {
		super(dado);
	}
	public Nodo<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo<T> anterior) {
		this.anterior = anterior;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NodoDuplamenteEncadeado [anterior=");
		builder.append(anterior);
		builder.append(", getDado()=");
		builder.append(getDado());
		builder.append("]");
		return builder.toString();
	}
	
}
