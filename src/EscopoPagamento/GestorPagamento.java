package EscopoPagamento;

import EscopoCliente.Cliente;
import estruturas.EstruturaGenerica;
import estruturas.Fila;
import estruturas.ListaEncadeada;
import gestao.Gestor;

public class GestorPagamento implements Gestor{
	public EstruturaGenerica escopo = new Fila();
	public void cadastrar(ListaEncadeada pedidos, Cliente cliente) {
		Pagamento pagamento = new Pagamento(pedidos, cliente);
		escopo.add(pagamento);
	}
	public void update(ListaEncadeada pedidos, Cliente cliente) {
		Pagamento pagamento = new Pagamento(pedidos, cliente);
		escopo.set(-1, pagamento);
	}
	public void remove() {
		escopo.remove(-1);
	}
	public void get() {
		escopo.get(-1);
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
