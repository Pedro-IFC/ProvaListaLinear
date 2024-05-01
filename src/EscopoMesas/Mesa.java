package EscopoMesas;

import estruturas.ListaEncadeada;

public class Mesa {
	private ListaEncadeada clientes;
	private String nome;
	public Mesa(String nome, int cadeiras) {
		this.nome=nome;
		this.clientes.setLimite(cadeiras);
		clientes = new ListaEncadeada();
	}
	public void nCadeiras(int n) {
		this.clientes.setLimite(n);
	}
	public ListaEncadeada getClientes() {
		return clientes;
	}
	public void setClientes(ListaEncadeada clientes) {
		this.clientes = clientes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean hasSpace() {
		return clientes.hasSpace();
	}
	public boolean isBusy() {
		return clientes.getSize()==0;
	}
}
