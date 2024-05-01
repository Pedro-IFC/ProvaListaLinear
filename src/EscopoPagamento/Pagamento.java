package EscopoPagamento;

import EscopoCliente.Cliente;
import EscopoPedidos.Pedidos;

public class Pagamento {
	private Pedidos pedidoPago;
	private Cliente clientepagando;
	public String recibo() {
		return "Recibo do pedido" + this.getPedidoPago().getDescricao() + "\nValor: " + this.getPedidoPago().getPreco() +
				"\n Cliente: "+this.getClientepagando().getNome();
 	}
	public Pedidos getPedidoPago() {
		return pedidoPago;
	}
	public void setPedidoPago(Pedidos pedidoPago) {
		this.pedidoPago = pedidoPago;
	}
	public Pagamento(Pedidos pedidoPago, Cliente cientepagando) {
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pagamento [pedidoPago=");
		builder.append(pedidoPago);
		builder.append(", clientepagando=");
		builder.append(clientepagando);
		builder.append("]");
		return builder.toString();
	}
	
}
