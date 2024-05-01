package Aplicacao;
import java.util.Scanner;

import Restaurante.Restaurante;
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
	    System.out.print("Escolha uma das opções: ");
    	int num1 = input.nextInt();
	    switch(num1) {
	    	//[0]=Ver clientes
	    	case 0:
	    		Restaurante.getInstance().allClientes();
    		break;
    	    //[1]=Atualizar cliente
	    	case 1:
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
	    		Restaurante.getInstance().cadastrarCliente(nome, idade);;
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
	    		Restaurante.getInstance().getPedidos(false);
	    		Restaurante.getInstance().getPedidos(true);
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
	    		Restaurante.getInstance().getMesas(true);
	    		Restaurante.getInstance().getMesas(false);
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
	    		Restaurante.getInstance().getFuncionarios();
    		break;
    		//[12]=Alocar mesa
	    	case 12:
	    		input.nextLine();
	    	    System.out.print("Id do cliente: ");
	    	    idCliente =  input.nextInt();
	    		Restaurante.getInstance().alocarMesa(idCliente);
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
	    		Restaurante.getInstance().atenderCliente(index, descricao, false, "", preco);
    		break;
    		//[14]=Preparar Pedido
	    	case 14:
	    		input.nextLine();
	    	    System.out.print("Id do pedido: ");
	    	    index =  input.nextInt();
	    		Restaurante.getInstance().prepararPedido(index);
    		break;
    		//[15]=Entregar Pedido
	    	case 15:
	    		input.nextLine();
	    	    System.out.print("Id do pedido: ");
	    	    index =  input.nextInt();
	    		Restaurante.getInstance().entregarPedido(index);
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
	    		Restaurante.getInstance().fecharPedido(index);
    		break;
    		//[18]=Gerar Recibo
	    	case 18:
	    		input.nextLine();
	    	    System.out.println("Id do Pagamento: ");
	    	    index =  input.nextInt();
	    		Restaurante.getInstance().gerarRecibo(index);
    		break;
    		//[19]=Historico de Pagamentos
	    	case 19:
	    		Restaurante.getInstance().getHistoricoPagamentos();
    		break;
    		//[20]=Ver pessoas para almoçar
	    	case 20:
	    		Restaurante.getInstance().numParaAlmocar();
    		break;
    		//[21]=Ver pessoas na fila do caixa
	    	case 21:
	    		Restaurante.getInstance().numParaPagar();
    		break;
    		//[22]=Ver pessoas almoçando
	    	case 22:
	    		Restaurante.getInstance().numAlmocando();
    		break;
    		//[23]=Ver pessoas atendidas
	    	case 23:
	    		Restaurante.getInstance().numAtendidas();
    		break;
    		//[24]=Ver mesas livres
	    	case 24:
	    		Restaurante.getInstance().getMesas(false);
    		break;
	    }
    }

}
