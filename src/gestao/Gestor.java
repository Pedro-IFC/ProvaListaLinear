package gestao;

import estruturas.EstruturaGenerica;

public interface Gestor {
	public EstruturaGenerica getEscopo();
	public void setEscopo(EstruturaGenerica escopo);
	public int getSize();
}
