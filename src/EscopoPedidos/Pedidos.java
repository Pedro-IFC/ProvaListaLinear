package EscopoPedidos;

import java.time.LocalDateTime;

import EscopoCliente.Cliente;

public class Pedidos {
	private Cliente cliente;
	private LocalDateTime hora;
	private String descricao;
	private boolean cancelado;
	private String status;
	private Double preco;
	public boolean isCancelado() {
		return cancelado;
	}
	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDateTime getHora() {
		return hora;
	}
	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isStatus() {
		return cancelado;
	}
	public void setStatus(boolean cancelado) {
		this.cancelado = cancelado;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Pedidos(Cliente cliente, LocalDateTime hora, String descricao, boolean cancelado, String status, Double preco) {
		super();
		this.cliente = cliente;
		this.hora = hora;
		this.descricao = descricao;
		this.cancelado = cancelado;
		this.status = status;
		this.preco = preco;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedidos [cliente=");
		builder.append(cliente);
		builder.append(", hora=");
		builder.append(hora);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", cancelado=");
		builder.append(cancelado);
		builder.append(", status=");
		builder.append(status);
		builder.append(", preco=");
		builder.append(preco);
		builder.append("]");
		return builder.toString();
	}
	
}
