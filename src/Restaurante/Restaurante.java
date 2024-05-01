package Restaurante;

import EscopoCliente.Cliente;
import EscopoCliente.GestorClientes;
import EscopoFuncionarios.Funcionario;
import EscopoFuncionarios.GestorFuncionarios;
import EscopoMesas.GestorMesas;
import EscopoPagamento.GestorPagamento;
import EscopoPedidos.GestorPedidos;

public class Restaurante {
	private int nmesas;
	private GestorClientes gestorClientes;
	private GestorFuncionarios gestorFuncionario;
	private GestorMesas gestorMesas;
	private GestorPedidos gestorPedidos;
	private GestorPagamento gestorPagamento;
	private static Restaurante instancia;
	
	public void mesasLivres() {
		int n=0;
		for(int i=0; i<gestorMesas.getSize(); i++) {
			if(gestorMesas.get(i).getClientes().getSize()==0) {
				n++;
			}
		}
		System.out.println(n);
	}
	public void numAtendidas() {
		int n=0;
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="finalizado") {
				n++;
			}
		}
		System.out.println(n);
	}
	public void numAlmocando() {
		int n=0;
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="almocando") {
				n++;
			}
		}
		System.out.println(n);
	}
	public void numParaPagar() {
		int n=0;
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="caixa") {
				n++;
			}
		}
		System.out.println(n);
	}
	public void numParaAlmocar() {
		int n=0;
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="paraalmocar") {
				n++;
			}
		}
		System.out.println(n);
	}
	public void getHistoricoPagamentos() {
		for(int i=0; i<gestorPagamento.getSize();i++) {
			System.out.println(gestorPagamento.get(i));
		}
	}
	public void gerarRecibo(int index) {
		System.out.println(gestorPagamento.get(index).recibo());
	}
	public void fecharPedido(int index) {
		if(gestorPedidos.get(index).getStatus()=="entregue") {
			this.gestorPedidos.get(index).setStatus("finalizado");
			gestorPagamento.cadastrar(gestorPedidos.get(index), gestorPedidos.get(index).getCliente());
		}else {
			System.out.println("Nenhum pedido entregue com esse index");
		}
	}
	public void terminarAlmoco(int index) {
		int iMesa =0;
		for(int i=0; i<gestorMesas.getSize();i++) {
			for(int z=0;z<gestorMesas.get(i).getClientes().getSize();z++) {
				if(gestorPedidos.get(index).getCliente()==gestorMesas.get(i).getClientes().get(z)) {
					iMesa=i;
				}
			}
		}
		gestorPedidos.get(index).getCliente().setEtapa("caixa");
		while(gestorMesas.get(iMesa).getClientes().getSize()>0) {
			gestorMesas.get(iMesa).getClientes().remove(0);
		}
	}
	public void entregarPedido(int index) {
		if(gestorPedidos.get(index).getStatus()=="pronto") {
			this.gestorPedidos.get(index).setStatus("entregue");
			gestorPedidos.get(index).getCliente().setEtapa("almocando");
		}else {
			System.out.println("Nenhum pedido pronto com esse index");
		}
	}
	public void prepararPedido(int index) {
		if(gestorPedidos.get(index).getStatus()=="cozinha") {
			this.gestorPedidos.get(index).setStatus("pronto");
		}else {
			System.out.println("Nenhum pedido feito com esse index");
		}
	}
	public void atenderCliente(int index, String descricao, boolean cancelado, String status, Double preco) {
		Funcionario fun = null;
		for(int i=0; i<gestorFuncionario.getSize();i++) {
			if(gestorFuncionario.get(i).getCargo().toLowerCase()=="garçon") {
				fun = gestorFuncionario.get(i);
			}
		}
		if(fun==null) {
			System.out.println("Sem garçons");
			return ;
		}
		Funcionario f2 = null;
		for(int i=0; i<gestorFuncionario.getSize();i++) {
			if(gestorFuncionario.get(i).getCargo().toLowerCase()=="cozinheiro") {
				f2 = gestorFuncionario.get(i);
			}
		}
		if(f2==null) {
			System.out.println("Sem cozinheiros");
			return ;
		}
		this.cadastrarPedido(gestorClientes.get(index), fun, f2, descricao, cancelado, "cozinha", preco);
	}
	public void cadastrarPedido(Cliente cliente, Funcionario garcon, Funcionario cozinheiro, String descricao, boolean cancelado, String status, Double preco) {
		
		gestorPedidos.cadastrar(cliente, garcon, cozinheiro, descricao, cancelado, status, preco);
	}
	public void getFuncionarios() {
		for(int i=0; i<gestorFuncionario.getSize();i++) {
			System.out.println(gestorFuncionario.get(i));
		}
	}
	public void removerFuncionario(int index) {
		this.gestorFuncionario.remover(index);
	}
	public void cadastrarFuncionario(String nome, String cargo) {
		this.gestorFuncionario.cadastrar(nome, cargo);
	}
	public void getMesas(boolean ocupada) {
		int mesas = 0;
		for(int i=0; i<gestorMesas.getSize();i++) {
			if(gestorMesas.get(i).hasSpace()) {
				mesas++;
			}
		}
		System.out.println("Mesas " +(ocupada?"ocupadas: ": "vazias: ") + (ocupada?gestorMesas.getSize()-mesas:mesas));
	}
	public void alocarMesa(int idCliente) {
		if(idCliente<0) {
			this.cadastrarCliente("Precisa preencher", 12);
			idCliente = gestorClientes.getSize()-1;
		}
		if(gestorMesas.getEscopo().hasSpace()) {
			if(gestorMesas.get(gestorMesas.getSize()-1).hasSpace()) {
				Cliente cl = gestorClientes.get(idCliente);
				gestorMesas.get(gestorMesas.getSize()-1).getClientes().add(cl);
			}else {
				System.out.println("Não possui cadeiras livres");
			}
		}else {
			System.out.println("Não possui mesas");
		}
	}
	public void cadastrarMesa(String nome, int cadeiras) {
			gestorMesas.cadastrar(nome, cadeiras);
	}
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
	public void atualizarPedido(int index, int indexCliente, Funcionario garcon, String descricao, boolean cancelado, String status, Double preco) {
		System.out.println("Você escolheu atualizar o pedido: " + gestorPedidos.get(index).getDescricao() );
		Cliente cliente = gestorClientes.get(index);
		if(cliente!=gestorPedidos.get(index).getCliente() && indexCliente>=0) {
			gestorPedidos.get(index).setCliente(cliente);
		}
		if(garcon!=gestorPedidos.get(index).getGarcon() && cliente!=null) {
			gestorPedidos.get(index).setGarcon(garcon);
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
		gestorMesas.getEscopo().setLimite(this.nmesas);;
		gestorPedidos = new GestorPedidos();
		gestorPagamento = new GestorPagamento();
	}
	public static Restaurante getInstance() {
		if(instancia==null)
			instancia = new Restaurante();
		return instancia;
	}
	
	public int getNmesas() {
		return nmesas;
	}
	public void setNmesas(int nmesas) {
		this.nmesas = nmesas;
		gestorMesas.getEscopo().setLimite(this.nmesas);
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
