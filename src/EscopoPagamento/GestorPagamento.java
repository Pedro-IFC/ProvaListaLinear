package EscopoPagamento;

import EscopoCliente.Cliente;
import EscopoPedidos.Pedidos;
import estruturas.EstruturaGenerica;
import estruturas.ListaEncadeada;
import gestao.Gestor;

public class GestorPagamento implements Gestor{
	public EstruturaGenerica escopo = new ListaEncadeada();
	public void cadastrar(Pedidos pedido, Cliente cliente) {
		Pagamento pagamento = new Pagamento(pedido, cliente);
		escopo.add(pagamento);
	}
	public void update(int index, Pedidos pedido, Cliente cliente) {
		Pagamento pagamento = new Pagamento(pedido, cliente);
		escopo.set(index, pagamento);
	}
	public void remove(int index) {
		escopo.remove(index);
	}
	public Pagamento get(int index) {
		return (Pagamento) escopo.get(index);
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
