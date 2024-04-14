package EscopoFuncionarios;

import estruturas.EstruturaGenerica;
import estruturas.ListaEncadeada;
import gestao.Gestor;

public class GestorFuncionarios implements Gestor{
	public EstruturaGenerica escopo = new ListaEncadeada();
	public EstruturaGenerica getEscopo() {
		return escopo;
	}
	public void setEscopo(EstruturaGenerica escopo) {
		this.escopo=escopo;
	}

}
