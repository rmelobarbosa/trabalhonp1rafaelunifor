package organograma;

public class No {
	private int idNo;
	private String nome;
	private String cargo;
	private int noIdPai;

	public No(String nome, String cargo, int noIdPai) {

		this.nome = nome;
		this.cargo = cargo;
		this.noIdPai = noIdPai;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return cargo;
	}

	public void setDescricao(String cargo) {
		this.cargo = cargo;
	}

	public int getNoIdPai() {
		return noIdPai;
	}

	public void setNoIdPai(int noIdPai) {
		this.noIdPai = noIdPai;
	}

}
