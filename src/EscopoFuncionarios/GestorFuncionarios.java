package EscopoFuncionarios;

import estruturas.EstruturaGenerica;
import estruturas.ListaEncadeada;
import gestao.Gestor;

public class GestorFuncionarios implements Gestor{
	public EstruturaGenerica escopo = new ListaEncadeada();
	public EstruturaGenerica getEscopo() {
		return escopo;
	}
	public void setEscopo(EstruturaGenerica escopo) {
		this.escopo=escopo;
	}
	public boolean cadastrar(String nome, String cargo) {
		Funcionario f = new Funcionario(nome, cargo);
		return escopo.add(f);
	}
	public boolean remover(int index) {
		return escopo.remove(index);
	}
	public <T> boolean update(int index, String nome, String cargo) {
		Funcionario fun = new Funcionario(nome, cargo);
		return escopo.set(index, fun);
	}
	public Funcionario get(int index) {
		return (Funcionario) escopo.get(index);
	}
	public int getSize() {
		return escopo.getSize();
	}
}
