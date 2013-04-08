package organograma;
public class Info {
	private int idInfo;
	private int ramal;
	private String endereco;
	private String representante;
	private String emailRepresentante;

	public Info(int idInfo, int ramal, String endereco, String representante,
			String emailRepresentante) {
		super();
		this.idInfo = idInfo;
		this.ramal = ramal;
		this.endereco = endereco;
		this.representante = representante;
		this.emailRepresentante = emailRepresentante;
	}

	public int getIdInfo() {
		return idInfo;
	}

	public void setIdInfo(int idInfo) {
		this.idInfo = idInfo;
	}

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getEmailRepresentante() {
		return emailRepresentante;
	}

	public void setEmailRepresentante(String emailRepresentante) {
		this.emailRepresentante = emailRepresentante;
	}

}
