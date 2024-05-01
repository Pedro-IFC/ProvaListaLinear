package EscopoPedidos;


import EscopoCliente.Cliente;
import EscopoFuncionarios.Funcionario;

public class Pedidos {
	private Cliente cliente;
	private Funcionario garcon;
	private Funcionario cozinheiro;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Pedidos(Cliente cliente, Funcionario garcon, Funcionario cozinheiro, String descricao, boolean cancelado, String status, Double preco) {
		super();
		this.cliente = cliente;
		this.garcon = garcon;
		this.cozinheiro = cozinheiro;
		this.descricao = descricao;
		this.cancelado = cancelado;
		this.status=status;
		this.preco = preco;
	}
	public Funcionario getGarcon() {
		return garcon;
	}
	public void setGarcon(Funcionario garcon) {
		this.garcon = garcon;
	}
	public Funcionario getCozinheiro() {
		return cozinheiro;
	}
	public void setCozinheiro(Funcionario cozinheiro) {
		this.cozinheiro = cozinheiro;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
