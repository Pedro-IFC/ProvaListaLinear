package EscopoPedidos;

import java.time.LocalDateTime;

import EscopoCliente.Cliente;

public class Pedidos {
	private Cliente cliente;
	private LocalDateTime hora;
	private String descricao;
	private boolean cancelado;
	private String status;
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
	public Pedidos(Cliente cliente, LocalDateTime hora, String descricao, boolean cancelado, String status) {
		super();
		this.cliente = cliente;
		this.hora = hora;
		this.descricao = descricao;
		this.cancelado = cancelado;
		this.status = status;
	}
	
}
