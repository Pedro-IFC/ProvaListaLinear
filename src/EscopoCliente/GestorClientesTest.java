package EscopoCliente;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class GestorClientesTest {

	@Test
	void cadastrar() {
		GestorClientes gc = GestorClientes.getInstance();
		gc.cadastrar("Pedro", "47 99999-9999", 18);
		boolean response = gc.cadastrar("Pedro - 2", "47 99999-9999", 18);
		System.out.println(gc.get(0).getNome());
        assertEquals(true, response);
	}
	@Test
	void remover() {
		GestorClientes gc = GestorClientes.getInstance();
		gc.cadastrar("Pedro", "47 99999-9999", 18);
		gc.cadastrar("Pedro - 2", "47 99999-9999", 18);
		System.out.println(gc.get(0).getNome());
		boolean response = gc.remover(0);
		System.out.println(gc.get(0).getNome());
        assertEquals(true, response);
	}
	@Test
	void update() {
		GestorClientes gc = GestorClientes.getInstance();
		gc.cadastrar("Pedro", "47 99999-9999", 18);
		gc.cadastrar("Pedro - 2", "47 99999-9999", 18);
		System.out.println(gc.get(0).getNome());
		boolean response = gc.update(0, "Pedro - atualizado", "47 99999-9999", 18);
		System.out.println(gc.get(0).getNome());
        assertEquals(true, response);
	}

}
