package EscopoCliente;

import gestao.Gestor;
import listas.EstruturaGenerica;
import listas.ListaEncadeada;

public class GestorClientes implements Gestor{
	private EstruturaGenerica escopo;
	private static GestorClientes instancia;
	private GestorClientes() {
		this.escopo= new ListaEncadeada();
	}
	public static GestorClientes getInstance() {
		if(instancia==null)
			instancia = new GestorClientes();
		return instancia;
	}
	public boolean cadastrar(String nome, String telefone, int idade) {
		Cliente cl = new Cliente(nome, telefone, idade);
		return escopo.add(cl);
	}
	public boolean remover(int index) {
		return escopo.remove(index);
	}
	public <T> boolean update(int index, String nome, String telefone, int idade) {
		Cliente cl = new Cliente(nome, telefone, idade);
		return escopo.set(index, cl);
	}
	public Cliente get(int index) {
		return (Cliente) escopo.get(index);
	}
	public EstruturaGenerica getEscopo() {
		return escopo;
	}
	public void setEscopo(EstruturaGenerica escopo) {
		this.escopo=escopo;
	}
	public GestorClientes getInstancia() {
		return instancia;
	}
}
