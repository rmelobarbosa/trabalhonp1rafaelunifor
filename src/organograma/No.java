package organograma;
import java.util.Date;

public class No {
	private int idNo;
	private String nome;
	private String descricao;
	private String noIdPai;

	public No(int idNo, String nome, String descricao, Date dataCriacao,
			String noIdPai) {
		super();
		this.idNo = idNo;
		this.nome = nome;
		this.descricao = descricao;
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
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNoIdPai() {
		return noIdPai;
	}

	public void setNoIdPai(String noIdPai) {
		this.noIdPai = noIdPai;
	}

}
