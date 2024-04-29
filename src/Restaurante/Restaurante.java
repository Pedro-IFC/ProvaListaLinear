package Restaurante;

import java.time.LocalDateTime;

import EscopoCliente.Cliente;
import EscopoCliente.GestorClientes;
import EscopoFuncionarios.GestorFuncionarios;
import EscopoMesas.GestorMesas;
import EscopoPagamento.GestorPagamento;
import EscopoPedidos.GestorPedidos;

public class Restaurante {
	private GestorClientes gestorClientes;
	private GestorFuncionarios gestorFuncionario;
	private GestorMesas gestorMesas;
	private GestorPedidos gestorPedidos;
	private GestorPagamento gestorPagamento;
	private static Restaurante instancia;
	public void getPedidos(boolean cancelado) {
		System.out.println("Você escolheu ver todos os pedidos " + (cancelado?"cancelados":"não cancelados") );
		for(int i=0; i<gestorPedidos.getSize(); i++) {
			if(cancelado==gestorPedidos.get(i).isCancelado()) {
				System.out.println(gestorPedidos.get(i).toString());
			}
		}
	}
	public void cancelarPedido(int index){
		this.atualizarPedido(index, -1, null, null, true, null, null);
	}
	public void atualizarPedido(int index, int indexCliente, LocalDateTime hora, String descricao, boolean cancelado, String status, Double preco) {
		System.out.println("Você escolheu atualizar o pedido: " + gestorPedidos.get(index).getDescricao() );
		Cliente cliente = gestorClientes.get(index);
		if(cliente!=gestorPedidos.get(index).getCliente() && indexCliente>=0) {
			gestorPedidos.get(index).setCliente(cliente);
		}
		if(hora!=gestorPedidos.get(index).getHora() && cliente!=null) {
			gestorPedidos.get(index).setHora(hora);
		}
		if(descricao!=gestorPedidos.get(index).getDescricao() && cliente!=null) {
			gestorPedidos.get(index).setDescricao(descricao);
		}
		if(cancelado!=gestorPedidos.get(index).isCancelado()) {
			gestorPedidos.get(index).setCancelado(cancelado);
		}
		if(status!=gestorPedidos.get(index).getStatus() && cliente!=null) {
			gestorPedidos.get(index).setStatus(status);
		}
		if(preco!=gestorPedidos.get(index).getPreco() && cliente!=null) {
			gestorPedidos.get(index).setPreco(preco);
		}
	}
	public void cadastrarPedido(int index, String descricao, Double preco) {
		System.out.println("Você escolheu cadastrar pedido");
		LocalDateTime hora = LocalDateTime.now();
		Cliente cliente = gestorClientes.get(index);
		gestorPedidos.cadastrar(cliente, hora, descricao, false, "Encaminhado para a cozinha", preco);
	}
	public void cadastrarCliente(String nome, int idade) {
		System.out.println("Você escolheu cadastrar cliente");
		gestorClientes.cadastrar(nome, idade);
	}
	public void removerCliente(int index) {
		System.out.println("Você escolheu remover o cliente: " + gestorClientes.get(index).getNome());
		gestorClientes.remover(index);
	}
	public void atualizarCliente(String nome, int idade, int index) {
		System.out.println("Você escolheu atualizar o cliente: " + gestorClientes.get(index).getNome() );
		gestorClientes.update(index, nome, idade);
	}
	public void allClientes() {
		System.out.println("Você escolheu ver todos os clientes");
		for(int i=0; i<gestorClientes.getSize(); i++) {
			System.out.println(gestorClientes.get(i).toString());
		}
	}
	private Restaurante() {
		gestorClientes = new GestorClientes();
		gestorFuncionario = new GestorFuncionarios();
		gestorMesas = new GestorMesas();
		gestorPedidos = new GestorPedidos();
		gestorPagamento = new GestorPagamento();
	}
	public static Restaurante getInstance() {
		if(instancia==null)
			instancia = new Restaurante();
		return instancia;
	}
	public GestorClientes gerirCliente() {
		return gestorClientes;
	}
	public void setGestorClientes(GestorClientes gestorClientes) {
		this.gestorClientes = gestorClientes;
	}
	public GestorFuncionarios getGestorFuncionario() {
		return gestorFuncionario;
	}
	public void setGestorFuncionario(GestorFuncionarios gestorFuncionario) {
		this.gestorFuncionario = gestorFuncionario;
	}
	public GestorMesas getGestorMesas() {
		return gestorMesas;
	}
	public void setGestorMesas(GestorMesas gestorMesas) {
		this.gestorMesas = gestorMesas;
	}
	public GestorPedidos getGestorPedidos() {
		return gestorPedidos;
	}
	public void setGestorPedidos(GestorPedidos gestorPedidos) {
		this.gestorPedidos = gestorPedidos;
	}
	public GestorPagamento getGestorPagamento() {
		return gestorPagamento;
	}
	public void setGestorPagamento(GestorPagamento gestorPagamento) {
		this.gestorPagamento = gestorPagamento;
	}
}
