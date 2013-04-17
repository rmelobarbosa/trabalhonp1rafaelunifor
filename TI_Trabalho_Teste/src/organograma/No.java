package organograma;

import java.util.List;

public class No {
	private int idNo;
	private String nome;
	private String descricao;
	private Integer noIdPai;
	
	private List<No> filhos;

	public No(String nome, String descricao, int noIdPai) {

		this.nome = nome;
		this.descricao = descricao;
		this.noIdPai = noIdPai;
	}
	
	public No(int idNo, String nome, String descricao, int noIdPai) {
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

	public Integer getNoIdPai() {
		return noIdPai;
	}

	public List<No> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<No> filhos) {
		this.filhos = filhos;
	}

	public void setNoIdPai(Integer noIdPai) {
		this.noIdPai = noIdPai;
	}

}
