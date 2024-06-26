package EscopoFuncionarios;

public class Funcionario {
	private String nome;
	private String cargo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Funcionario(String nome, String cargo) {
		super();
		this.nome = nome;
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append(", cargo=");
		builder.append(cargo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
