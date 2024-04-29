package EscopoPagamento;

import EscopoCliente.Cliente;
import estruturas.ListaEncadeada;

public class Pagamento {
	private ListaEncadeada pedidoPago = new ListaEncadeada();
	private Cliente clientepagando;
	public ListaEncadeada getPedidoPago() {
		return pedidoPago;
	}
	public void setPedidoPago(ListaEncadeada pedidoPago) {
		this.pedidoPago = pedidoPago;
	}
	public Pagamento(ListaEncadeada pedidoPago, Cliente cientepagando) {
		super();
		this.pedidoPago = pedidoPago;
		this.clientepagando = cientepagando;
	}
	public Cliente getClientepagando() {
		return clientepagando;
	}
	public void setClientepagando(Cliente clientepagando) {
		this.clientepagando = clientepagando;
	}
	
}
