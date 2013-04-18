package organograma;
public class NoInfo {
	private No idNo;
	private Info idInfo;
	private boolean flagExibe;

	public NoInfo(No idNo, Info idInfo, boolean flagExibe) {
		super();
		this.idNo = idNo;
		this.idInfo = idInfo;
		this.flagExibe = flagExibe;
	}

	public No getIdNo() {
		return  idNo;
	}

	public void setIdNo(No idNo) {
		this.idNo = idNo;
	}

	public Info getIdInfo() {
		return idInfo;
	}

	public void setIdInfo(Info idInfo) {
		this.idInfo = idInfo;
	}

	public boolean isFlagExibe() {
		return flagExibe;
	}

	public void setFlagExibe(boolean flagExibe) {
		this.flagExibe = flagExibe;
	}

}
