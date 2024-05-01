package EscopoCliente;

public class Cliente {
	private String nome;
	private int idade;
	private String etapa;
	public Cliente(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [nome=");
		builder.append(nome);
		builder.append(", idade=");
		builder.append(idade);
		builder.append("]");
		return builder.toString();
	}
	public String getEtapa() {
		return etapa;
	}
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	
}
