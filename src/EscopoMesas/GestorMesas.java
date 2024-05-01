package EscopoMesas;

import EscopoCliente.Cliente;
import estruturas.EstruturaGenerica;
import estruturas.ListaEncadeada;
import gestao.Gestor;

public class GestorMesas implements Gestor{
	public EstruturaGenerica escopo = new ListaEncadeada();
	
	public EstruturaGenerica getEscopo() {
		return escopo;
	}
	public void setEscopo(EstruturaGenerica escopo) {
		this.escopo=escopo;
	}
	public void addCliente(int index, String nome, int idade) {
		Cliente cl = new Cliente(nome, idade);
		Mesa mesaAtual = (Mesa) escopo.get(index);
		mesaAtual.getClientes().add(cl);
	}
	public boolean cadastrar(String nome, int cadeiras) {
		Mesa mesa = new Mesa(nome, cadeiras);
		return escopo.add(mesa);
	}
	public boolean remover(int index) {
		return escopo.remove(index);
	}
	public <T> boolean update(int index, String nome, int cadeiras) {
		Mesa mesa = new Mesa(nome, cadeiras);
		return escopo.set(index, mesa);
	}
	public Mesa get(int index) {
		return (Mesa) escopo.get(index);
	}
	public int getSize() {
		return escopo.getSize();
	}
}
