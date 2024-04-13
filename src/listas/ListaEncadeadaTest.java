package listas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListaEncadeadaTest {

	@Test
	void testAdd() {
		ListaEncadeada minhaClasse = new ListaEncadeada();
        
        minhaClasse.add(2);
        
        assertEquals(2, minhaClasse.get(0));
	}
	@Test
	void testeRemove() {
		ListaEncadeada minhaClasse = new ListaEncadeada();
        
        minhaClasse.add(2);
        minhaClasse.remove(0);
        
        assertEquals(null, minhaClasse.get(0));
	}
	@Test
	void testeLimite() {
		ListaEncadeada minhaClasse = new ListaEncadeada(1);
        
        minhaClasse.add(2);
        minhaClasse.add(2);
        minhaClasse.add(2);
        
        assertEquals(null, minhaClasse.get(1));
	}

}
