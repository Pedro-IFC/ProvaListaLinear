package EscopoCliente;

import estruturas.EstruturaGenerica;
import estruturas.ListaEncadeada;
import gestao.Gestor;

public class GestorClientes implements Gestor{
	private EstruturaGenerica escopo = new ListaEncadeada();
	public boolean cadastrar(String nome, int idade) {
		Cliente cl = new Cliente(nome, idade);
		cl.setEtapa("paraalmocar");
		return escopo.add(cl);
	}
	public boolean remover(int index) {
		return escopo.remove(index);
	}
	public <T> boolean update(int index, String nome, int idade) {
		Cliente cl = new Cliente(nome, idade);
		return escopo.set(index, cl);
	}
	public Cliente get(int index) {
		return index>=0?(Cliente) escopo.get(index):null;
	}
	public EstruturaGenerica getEscopo() {
		return escopo;
	}
	public void setEscopo(EstruturaGenerica escopo) {
		this.escopo=escopo;
	}
	public int getSize() {
		return escopo.getSize();
	}
}
