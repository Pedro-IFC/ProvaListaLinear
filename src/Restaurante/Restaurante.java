package Restaurante;

import EscopoCliente.Cliente;
import EscopoCliente.GestorClientes;
import EscopoFuncionarios.Funcionario;
import EscopoFuncionarios.GestorFuncionarios;
import EscopoMesas.GestorMesas;
import EscopoPagamento.GestorPagamento;
import EscopoPedidos.GestorPedidos;
import estruturas.ListaEncadeada;

public class Restaurante {
	private int nmesas;
	private GestorClientes gestorClientes;
	private GestorFuncionarios gestorFuncionario;
	private GestorMesas gestorMesas;
	private GestorPedidos gestorPedidos;
	private GestorPagamento gestorPagamento;
	private static Restaurante instancia;
	public ListaEncadeada getAtendidas() {
		ListaEncadeada n = new ListaEncadeada();
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="finalizado") {
				n.add(gestorClientes.get(i));
			}
		}
		return n;
	}
	public ListaEncadeada getAlmocando() {
		ListaEncadeada n = new ListaEncadeada();
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="almocando") {
				System.out.println(gestorClientes.get(i));
			}
		}
		return n;
	}
	public ListaEncadeada getParaPagar() {
		ListaEncadeada n = new ListaEncadeada();
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="caixa") {
				System.out.println(gestorClientes.get(i));
			}
		}
		return n;
	}
	public ListaEncadeada getParaAlmocar() {
		ListaEncadeada n = new ListaEncadeada();
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="paraalmocar") {
				n.add(gestorClientes.get(i));
			}
		}
		return n;
	}
	public int mesasLivres() {
		int n=0;
		for(int i=0; i<gestorMesas.getSize(); i++) {
			if(gestorMesas.get(i).getClientes().getSize()==0) {
				n++;
			}
		}
		return n;
	}
	public int numAtendidas() {
		int n=0;
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="caifora") {
				n++;
			}
		}
		return n;
	}
	public int numAlmocando() {
		int n=0;
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="almocando") {
				n++;
			}
		}
		return n;
	}
	public int numParaPagar() {
		int n=0;
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="caixa") {
				n++;
			}
		}
		return n;
	}
	public int numParaAlmocar() {
		int n=0;
		for(int i=0; i<gestorClientes.getSize(); i++) {
			if(gestorClientes.get(i).getEtapa()=="paraalmocar") {
				n++;
			}
		}
		return n;
	}
	public ListaEncadeada getHistoricoPagamentos() {
		ListaEncadeada h = new ListaEncadeada();
		for(int i=0; i<gestorPagamento.getSize();i++) {
			if(gestorPagamento.get(i).isPago()) {
				h.add(gestorPagamento.get(i));
			}
		}
		return h;
	}
	public boolean pagar(int index, double pagamento) {
		if(!gestorPagamento.get(index).isPago()) {
			if(pagamento>=gestorPagamento.get(index).getPedidoPago().getPreco()) {
				System.out.println("Troco deve ser de: " + (pagamento-gestorPagamento.get(index).getPedidoPago().getPreco()));
				gestorPagamento.get(index).setPago(true);
				gestorPagamento.get(index).getClientepagando().setEtapa("caifora");
				return true;
			}else {
				System.out.println("Faltou dinheiro");
			}
		}else {
			System.out.println("Pagamento já realizado para este ID");
		}
		return false;
	}
	public String gerarRecibo(int index) {
		if(gestorPagamento.get(index).isPago()) {
			return (gestorPagamento.get(index).recibo());
		}else {
			return ("Nenhum pagamento realizado para este ID");
			
		}
	}
	public boolean fecharPedido(int index) {
		if(gestorPedidos.get(index).getStatus()=="entregue") {
			this.gestorPedidos.get(index).setStatus("caixa");
			gestorPedidos.get(index).getCliente().setEtapa("caixa");
			gestorPagamento.cadastrar(gestorPedidos.get(index), gestorPedidos.get(index).getCliente());
			return true;
		}
		return false;
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
	public boolean entregarPedido(int index) {
		if(gestorPedidos.get(index).getStatus()=="pronto") {
			this.gestorPedidos.get(index).setStatus("entregue");
			gestorPedidos.get(index).getCliente().setEtapa("almocando");
			return true;
		}
		return false;
	}
	public boolean prepararPedido(int index) {
		if(gestorPedidos.get(index).getStatus().contains("cozinha")) {
			this.gestorPedidos.get(index).setStatus("pronto");
			return true;
		}
		return false;
	}
	public boolean atenderCliente(int index, String descricao, boolean cancelado, String status, Double preco) {
		Funcionario fun = null;
		for(int i=0; i<gestorFuncionario.getSize();i++) {
			if(gestorFuncionario.get(i).getCargo().contains("garcon")) {
				fun = gestorFuncionario.get(i);
			}
		}
		if(fun==null) {
			return false;
		}
		Funcionario f2 = null;
		for(int i=0; i<gestorFuncionario.getSize();i++) {
			if(gestorFuncionario.get(i).getCargo().contains("cozinheiro")) {
				f2 = gestorFuncionario.get(i);
			}
		}
		if(f2==null) {
			return false;
		}
		this.cadastrarPedido(gestorClientes.get(index), fun, f2, descricao, cancelado, "cozinha", preco);
		return true;
	}
	public void cadastrarPedido(Cliente cliente, Funcionario garcon, Funcionario cozinheiro, String descricao, boolean cancelado, String status, Double preco) {
		gestorPedidos.cadastrar(cliente, garcon, cozinheiro, descricao, cancelado, status, preco);
	}
	public ListaEncadeada getFuncionarios() {
		ListaEncadeada fs = new ListaEncadeada();
		for(int i=0; i<gestorFuncionario.getSize();i++) {
			fs.add(gestorFuncionario.get(i));
		}
		return fs;
	}
	public void removerFuncionario(int index) {
		this.gestorFuncionario.remover(index);
	}
	public void cadastrarFuncionario(String nome, String cargo) {
		this.gestorFuncionario.cadastrar(nome, cargo);
	}
	public ListaEncadeada getMesas(boolean ocupada) {
		ListaEncadeada n = new ListaEncadeada();
		for(int i=0; i<gestorMesas.getSize();i++) {
			n.add(gestorMesas.get(i));
		}
		return n;
	}
	public boolean alocarMesa(int idCliente) {
		for(int i=0; i<gestorMesas.getSize();i++) {
			if(gestorMesas.get(i).getClientes().getSize()==0) {
				Cliente cl = gestorClientes.get(idCliente);
				gestorMesas.get(i).getClientes().add(cl);
				return true;
			}
		}
		return false;
	}
	public void cadastrarMesa(String nome, int cadeiras) {
		gestorMesas.cadastrar(nome, cadeiras);
	}
	public void atualizarFuncionario(String nome, String cargo, int index) {
		Funcionario funcionario = gestorFuncionario.get(index);
		funcionario.setNome(nome);
		funcionario.setCargo(cargo);
	}
	public ListaEncadeada getPedidos(boolean cancelado) {
		ListaEncadeada r = new ListaEncadeada();
		for(int i=0; i<gestorPedidos.getSize(); i++) {
			if(cancelado==gestorPedidos.get(i).isCancelado()) {
				r.add(gestorPedidos.get(i));
			}
		}
		return r;
	}
	public void cancelarPedido(int index){
		this.gestorFuncionario.remover(index);
	}
	public void atualizarPedido(int index, int indexCliente, int indexFun, String descricao, boolean cancelado, String status, Double preco) {
		Funcionario garcon = gestorFuncionario.get(indexFun);
		Cliente cliente = gestorClientes.get(indexCliente);
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
		gestorClientes.cadastrar(nome, idade);
	}
	public void removerCliente(int index) {
		gestorClientes.remover(index);
	}
	public void atualizarCliente(String nome, int idade, int index) {
		Cliente cliente = gestorClientes.get(index);
		cliente.setNome(nome);
		cliente.setIdade(idade);
	}
	public ListaEncadeada allClientes() {
		ListaEncadeada r = new ListaEncadeada();
		for(int i=0; i<gestorClientes.getSize(); i++) {
			r.add(gestorClientes.get(i));
		}
		return r;
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
