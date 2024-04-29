package Restaurante;

import org.junit.jupiter.api.Test;

class TestesRestaurante {

	@Test
	void testes() {
		String nome="Pedro";
		int idade = 18;
		Restaurante.getInstance().cadastrarCliente(nome, idade);
		Restaurante.getInstance().allClientes();
		System.out.println("//////////////////////////////");
		nome="Emanuel";
		idade = 18;
		Restaurante.getInstance().atualizarCliente(nome, idade, 0);
		Restaurante.getInstance().allClientes();
		System.out.println("//////////////////////////////");
		Restaurante.getInstance().removerCliente(0);
		Restaurante.getInstance().allClientes();
		System.out.println("//////////////////////////////");
		nome="Daniel";
		idade = 18;
		Restaurante.getInstance().cadastrarCliente(nome, idade);
		Restaurante.getInstance().allClientes();
		System.out.println("//////////////////////////////");
		Restaurante.getInstance().cadastrarPedido(0, "Ovo frito", 2.55);
		Restaurante.getInstance().getPedidos(false);
	}

}
