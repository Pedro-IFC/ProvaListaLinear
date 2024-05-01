package EscopoPedidos;


import EscopoCliente.Cliente;
import EscopoFuncionarios.Funcionario;
import estruturas.EstruturaGenerica;
import estruturas.ListaEncadeada;
import gestao.Gestor;

public class GestorPedidos implements Gestor{
	public EstruturaGenerica escopo = new ListaEncadeada();
	public void cadastrar(Cliente cliente, Funcionario garcon, Funcionario cozinheiro, String descricao, boolean cancelado, String status, Double preco) {
		Pedidos pedido = new Pedidos(cliente, garcon, cozinheiro, descricao, cancelado, status, preco);
		escopo.add(pedido);
	}
	public void update(int index, Pedidos novo) {
		escopo.set(index, novo);
	}
	public void remove() {
		escopo.remove(-1);
	}
	public Pedidos get(int index) {
		return (Pedidos) escopo.get(index);
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
