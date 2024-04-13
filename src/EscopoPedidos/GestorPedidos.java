package EscopoPedidos;

import gestao.Gestor;
import listas.EstruturaGenerica;
import listas.ListaEncadeada;

public class GestorPedidos implements Gestor{
	public EstruturaGenerica escopo = new ListaEncadeada();
	public EstruturaGenerica getEscopo() {
		return escopo;
	}
	public void setEscopo(EstruturaGenerica escopo) {
		this.escopo=escopo;
	}
}
