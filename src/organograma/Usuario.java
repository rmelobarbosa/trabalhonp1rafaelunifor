package organograma;


public class Usuario {
	private String login;
	private String senha;
	private String nome;
	private String perfil;
	
	public Usuario(String login, String senha, String nome, String perfil) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
	
	
}
