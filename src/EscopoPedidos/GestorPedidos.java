package EscopoPedidos;

import java.time.LocalDateTime;

import EscopoCliente.Cliente;
import estruturas.EstruturaGenerica;
import estruturas.Fila;
import gestao.Gestor;

public class GestorPedidos implements Gestor{
	public EstruturaGenerica escopo = new Fila();
	private static GestorPedidos instancia;
	public void cadastrar(Cliente cliente, LocalDateTime hora, String descricao, boolean cancelado, String status) {
		Pedidos pedido = new Pedidos(cliente, hora, descricao, cancelado, status);
		escopo.add(pedido);
	}
	public void update(Cliente cliente, LocalDateTime hora, String descricao, boolean cancelado, String status) {
		Pedidos pedido = new Pedidos(cliente, hora, descricao, cancelado, status);
		escopo.set(-1, pedido);
	}
	public void remove() {
		escopo.remove(-1);
	}
	public void get() {
		escopo.get(-1);
	}
	private GestorPedidos() {
		this.escopo= new Fila();
	}
	public static GestorPedidos getInstance() {
		if(instancia==null)
			instancia = new GestorPedidos();
		return instancia;
	}
	public EstruturaGenerica getEscopo() {
		return escopo;
	}
	public void setEscopo(EstruturaGenerica escopo) {
		this.escopo=escopo;
	}
}
