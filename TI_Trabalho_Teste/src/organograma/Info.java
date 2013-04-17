package organograma;

public class Info {
	private int idInfo;
	private int ramal;
	private int sala;
	private String representante;
	private String emailRepresentante;
	private int idno_fk;

	public Info(int idInfo, int ramal, int sala, String representante,
			String emailRepresentante, int idno_fk) {
		super();
		this.idInfo = idInfo;
		this.ramal = ramal;
		this.sala = sala;
		this.representante = representante;
		this.emailRepresentante = emailRepresentante;
		this.idno_fk = idno_fk;
	}

	public Info(int ramal, int sala, String representante,
			String emailRepresentante, int idno_fk) {
		super();
		this.ramal = ramal;
		this.sala = sala;
		this.representante = representante;
		this.emailRepresentante = emailRepresentante;
		this.idno_fk = idno_fk;
	}

	public Info(int ramal, int sala, String representante,
			String emailRepresentante) {
		super();
		this.ramal = ramal;
		this.sala = sala;
		this.representante = representante;
		this.emailRepresentante = emailRepresentante;
	}

	public Info() {

	}

	public int getIdno_fk() {
		return idno_fk;
	}

	public void setIdno_fk(int idno_fk) {
		this.idno_fk = idno_fk;
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

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
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
