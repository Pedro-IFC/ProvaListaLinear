package Aplicacao;
import java.util.Scanner;

import EscopoMesas.Mesa;
import Restaurante.Restaurante;
import estruturas.ListaEncadeada;
public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    	while(true) {
    		inicial();
        	input.nextLine();
    		System.out.println("Pressione enter para continuar");
        	input.nextLine();
    	}
	}
    public static void inicial() {
	    System.out.println("");
	    System.out.println("[0]=Ver clientes");
	    System.out.println("[1]=Atualizar cliente");
	    System.out.println("[2]=Remover cliente");
	    System.out.println("[3]=Cadastrar cliente");
	    System.out.println("[4]=Atualizar pedido");
	    System.out.println("[5]=Cancelar pedido");
	    System.out.println("[6]=Ver pedidos");
	    System.out.println("[7]=Cadastrar mesa");
	    System.out.println("[8]=Ver mesas");
	    System.out.println("[9]=Cadastrar funcionario");
	    System.out.println("[10]=Remover funcionario");
	    System.out.println("[11]=Ver funcionarios");
	    System.out.println("[12]=Alocar Mesa");
	    System.out.println("[13]=Atender cliente");
	    System.out.println("[14]=Preparar Pedido");
	    System.out.println("[15]=Entregar Pedido");
	    System.out.println("[16]=Terminar Almoco");
	    System.out.println("[17]=Fechar Pedido");
	    System.out.println("[18]=Gerar Recibo");
	    System.out.println("[19]=Historico de Pagamentos");
	    System.out.println("[20]=Ver pessoas para almoçar");
	    System.out.println("[21]=Ver pessoas na fila do caixa");
	    System.out.println("[22]=Ver pessoas almoçando");
	    System.out.println("[23]=Ver pessoas atendidas");
	    System.out.println("[24]=Ver mesas livres");
	    System.out.println("[25]=Pagar");
	    System.out.print("Escolha uma das opções: ");
    	int num1 = input.nextInt();
	    switch(num1) {
	    	//[0]=Ver clientes
	    	case 0:
	    		ListaEncadeada cls = Restaurante.getInstance().allClientes();
	    		System.out.println("Você escolheu ver todos os clientes");
	    		for(int i=0; i<cls.getSize(); i++) {
	    			System.out.println(cls.get(i).toString());
	    		}
    		break;
    	    //[1]=Atualizar cliente
	    	case 1:
	    		System.out.println("Você escolheu atualizar o cliente: ");
	    		input.nextLine();
	    		System.out.print("Novo nome: ");
	    		String nome = input.nextLine();
	    	    System.out.print("Nova idade: ");
	    		int idade =  input.nextInt();
	    	    System.out.print("Id do cliente: ");
	    		int index =  input.nextInt();
	    		Restaurante.getInstance().atualizarCliente(nome, idade, index);
    		break;
    	    //[2]=Remover cliente
	    	case 2:
	    	    System.out.println("Você escolheu remover o cliente");
	    		input.nextLine();
	    	    System.out.print("Id do cliente: ");
	    	    index =  input.nextInt();
	    		Restaurante.getInstance().removerCliente(index);
    		break;
    	    //[3]=Cadastrar cliente
	    	case 3:
	    		input.nextLine();
	    		System.out.print("Nome: ");
	    		nome = input.nextLine();
	    	    System.out.print("Idade: ");
	    		idade =  input.nextInt();
	    		System.out.println("Você escolheu cadastrar cliente");
	    		Restaurante.getInstance().cadastrarCliente(nome, idade);
    		break;
    	    //[4]=Atualizar pedido
	    	case 4:
	    	    System.out.print("Id do Pedido: ");
	    		int idPedido =  input.nextInt();
	    	    System.out.print("Id do Cliente: ");
	    		int idCliente =  input.nextInt();
	    	    System.out.print("Id do Garçon: ");
	    		int idFun =  input.nextInt();
	    		input.nextLine();
	    	    System.out.print("Insira a descricao: ");
	    		String descricao =  input.nextLine();
	    	    System.out.print("Insira o status: ");
	    		String status = input.nextLine();
	    	    System.out.print("Insira o preço: ");
	    		Double preco = input.nextDouble();
	    		System.out.println("Você escolheu atualizar o pedido");
	    		Restaurante.getInstance().atualizarPedido(idPedido, idCliente, idFun, descricao, false, status, preco);
    		break;
    		//[5]=Cancelar pedido
	    	case 5:
	    		input.nextLine();
	    	    System.out.print("Id do Pedido: ");
	    	    index =  input.nextInt();
	    		Restaurante.getInstance().cancelarPedido(index);
    		break;
    	    //[6]=Ver pedidos
	    	case 6:
	    		System.out.println("Você escolheu ver todos os pedidos não cancelados");
	    		ListaEncadeada pedidos = Restaurante.getInstance().getPedidos(false);
	    		for(int i=0; i<pedidos.getSize(); i++) {
	    			System.out.println(pedidos.toString());
	    		}
	    		System.out.println("Você escolheu ver todos os pedidos cancelados");
	    		pedidos = Restaurante.getInstance().getPedidos(true);
	    		for(int i=0; i<pedidos.getSize(); i++) {
	    			System.out.println(pedidos.toString());
	    		}
    		break;
    	    //[7]=Cadastrar mesa
	    	case 7:
	    		input.nextLine();
	    		System.out.print("Nome: ");
	    		nome = input.nextLine();
	    	    System.out.print("capacidade: ");
	    		int capacidade =  input.nextInt();
	    		Restaurante.getInstance().cadastrarMesa(nome, capacidade);
    		break;
    		//[8]=Ver mesas
	    	case 8:
	    		ListaEncadeada mesasL = Restaurante.getInstance().getMesas(true);
	    		int mesasn = 0;
	    		for(int i=0; i<mesasL.getSize();i++) {
	    			Mesa aux = (Mesa) mesasL.get(i);
	    			if(aux.getClientes().getSize()==0) {
	    				mesasn++;
	    			}
	    		}
	    		System.out.println("Mesas ocupadas: " + (mesasL.getSize()-mesasn));
	    		System.out.println("Mesas vazias: " + mesasn);
    		break;
    		//[9]=Cadastrar funcionario
	    	case 9:
	    		input.nextLine();
	    		System.out.print("Nome: ");
	    		nome = input.nextLine();
	    		System.out.print("Cargo: ");
	    		String cargo = input.nextLine();
	    		Restaurante.getInstance().cadastrarFuncionario(nome, cargo);
    		break;
    		//[10]=Remover funcionario
	    	case 10:
	    		input.nextLine();
	    	    System.out.print("Id do funcionario: ");
	    	    index =  input.nextInt();
	    		Restaurante.getInstance().removerFuncionario(index);
    		break;
    		//[11]=Ver funcionarios
	    	case 11:
	    		System.out.println("Você escolheu ver todos os funcionarios ");
	    		ListaEncadeada fs = Restaurante.getInstance().getFuncionarios();
	    		for(int i=0; i<fs.getSize();i++) {
	    			System.out.println(fs.get(i).toString());
	    		}
    		break;
    		//[12]=Alocar mesa
	    	case 12:
	    		input.nextLine();
	    	    System.out.print("Id do cliente: ");
	    	    idCliente =  input.nextInt();
	    		System.out.println(Restaurante.getInstance().alocarMesa(idCliente)?"Mesa alocada":"Mesa não alocada");
    		break;
    		//[13]=Atender cliente
	    	case 13:
	    		input.nextLine();
	    	    System.out.print("Id do cliente: ");
	    	    index =  input.nextInt();
	    		input.nextLine();
	    	    System.out.print("Insira a descricao: ");
	    		descricao =  input.nextLine();
	    	    System.out.print("Insira o preço: ");
	    		preco = input.nextDouble();
	    		if(Restaurante.getInstance().atenderCliente(index, descricao, false, "", preco)) {
					System.out.println("Cliente atendido");
	    		}else {
					System.out.println("Sem funcionários disponíveis");
	    		}
    		break;
    		//[14]=Preparar Pedido
	    	case 14:
	    		input.nextLine();
	    	    System.out.print("Id do pedido: ");
	    	    index =  input.nextInt();
	    		;
	    		if(Restaurante.getInstance().prepararPedido(index)) {
	    			System.out.println("Pedido preparado");
	    		}else {
	    			System.out.println("Nenhum pedido feito com esse index");
	    		}
    		break;
    		//[15]=Entregar Pedido
	    	case 15:
	    		input.nextLine();
	    	    System.out.print("Id do pedido: ");
	    	    index =  input.nextInt();
	    		if(Restaurante.getInstance().entregarPedido(index)) {
	    			System.out.println("Pedido entregue");
	    		}else {
	    			System.out.println("Nenhum pedido feito com esse index");
	    		}
    		break;
    		//[16]=Terminar Almoco
	    	case 16:
	    		input.nextLine();
	    	    System.out.print("Id do pedido: ");
	    	    index =  input.nextInt();
	    		Restaurante.getInstance().terminarAlmoco(index);
    		break;
    		//[17]=Fechar Pedido
	    	case 17:
	    		input.nextLine();
	    	    System.out.print("Id do pedido: ");
	    	    index = input.nextInt();
	    		if(Restaurante.getInstance().fecharPedido(index)) {
	    			System.out.println("Pedido fechado");
	    		}else {
	    			System.out.println("Nenhum pedido feito com esse index");
	    		}
    		break;
    		//[18]=Gerar Recibo
	    	case 18:
	    		input.nextLine();
	    	    System.out.println("Id do Pagamento: ");
	    	    index =  input.nextInt();
	    		System.out.println(Restaurante.getInstance().gerarRecibo(index));
    		break;
    		//[19]=Historico de Pagamentos
	    	case 19:
	    		ListaEncadeada h = Restaurante.getInstance().getHistoricoPagamentos();
	    		for(int i=0; i<h.getSize();i++) {
    				System.out.println(h.get(i).toString());
	    		}
    		break;
    		//[20]=Ver pessoas para almoçar
	    	case 20:
	    		System.out.println(Restaurante.getInstance().numParaAlmocar());
    		break;
    		//[21]=Ver pessoas na fila do caixa
	    	case 21:
	    		System.out.println(Restaurante.getInstance().numParaPagar());
    		break;
    		//[22]=Ver pessoas almoçando
	    	case 22:
	    		System.out.println(Restaurante.getInstance().numAlmocando());
    		break;
    		//[23]=Ver pessoas atendidas
	    	case 23:
	    		System.out.println(Restaurante.getInstance().numAtendidas());
    		break;
    		//[24]=Ver mesas livres
	    	case 24:
	    		System.out.println(Restaurante.getInstance().mesasLivres());
    		break;
    		//[24]=Pagar
	    	case 25:
	    		input.nextLine();
	    	    System.out.println("Id do Pagamento: ");
	    	    index = input.nextInt();
	    	    System.out.println("Valor a ser pago: ");
	    	    Double pagamento = input.nextDouble();
	    		Restaurante.getInstance().pagar(index, pagamento);
	    	break;
	    }
    }

}
