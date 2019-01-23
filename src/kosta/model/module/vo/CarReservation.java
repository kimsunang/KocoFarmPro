package kosta.model.module.vo;

public class CarReservation {
	
	private String RES_ID;
	private String WRITER;
	private String RES_USER;
	private String PURPOSE;
	private String ST_ADDR;
	private String DE_ADDR;
	private String REG_DT;
	private String UP_DT;
	private String ST_TIME;
	private String EN_TIME;
	private String CAR_ID;
	
	public CarReservation() {}

	public CarReservation(String rES_ID, String wRITER, String rES_USER, String pURPOSE, String sT_ADDR, String dE_ADDR,
			String rEG_DT, String uP_DT, String sT_TIME, String eN_TIME, String cAR_ID) {
		super();
		RES_ID = rES_ID;
		WRITER = wRITER;
		RES_USER = rES_USER;
		PURPOSE = pURPOSE;
		ST_ADDR = sT_ADDR;
		DE_ADDR = dE_ADDR;
		REG_DT = rEG_DT;
		UP_DT = uP_DT;
		ST_TIME = sT_TIME;
		EN_TIME = eN_TIME;
		CAR_ID = cAR_ID;
	}

	public String getRES_ID() {
		return RES_ID;
	}

	public void setRES_ID(String rES_ID) {
		RES_ID = rES_ID;
	}

	public String getWRITER() {
		return WRITER;
	}

	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}

	public String getRES_USER() {
		return RES_USER;
	}

	public void setRES_USER(String rES_USER) {
		RES_USER = rES_USER;
	}

	public String getPURPOSE() {
		return PURPOSE;
	}

	public void setPURPOSE(String pURPOSE) {
		PURPOSE = pURPOSE;
	}

	public String getST_ADDR() {
		return ST_ADDR;
	}

	public void setST_ADDR(String sT_ADDR) {
		ST_ADDR = sT_ADDR;
	}

	public String getDE_ADDR() {
		return DE_ADDR;
	}

	public void setDE_ADDR(String dE_ADDR) {
		DE_ADDR = dE_ADDR;
	}

	public String getREG_DT() {
		return REG_DT;
	}

	public void setREG_DT(String rEG_DT) {
		REG_DT = rEG_DT;
	}

	public String getUP_DT() {
		return UP_DT;
	}

	public void setUP_DT(String uP_DT) {
		UP_DT = uP_DT;
	}

	public String getST_TIME() {
		return ST_TIME;
	}

	public void setST_TIME(String sT_TIME) {
		ST_TIME = sT_TIME;
	}

	public String getEN_TIME() {
		return EN_TIME;
	}

	public void setEN_TIME(String eN_TIME) {
		EN_TIME = eN_TIME;
	}

	public String getCAR_ID() {
		return CAR_ID;
	}

	public void setCAR_ID(String cAR_ID) {
		CAR_ID = cAR_ID;
	}

	@Override
	public String toString() {
		return "CarReservation [RES_ID=" + RES_ID + ", WRITER=" + WRITER + ", RES_USER=" + RES_USER + ", PURPOSE="
				+ PURPOSE + ", ST_ADDR=" + ST_ADDR + ", DE_ADDR=" + DE_ADDR + ", REG_DT=" + REG_DT + ", UP_DT=" + UP_DT
				+ ", ST_TIME=" + ST_TIME + ", EN_TIME=" + EN_TIME + ", CAR_ID=" + CAR_ID + "]";
	}
	
	

	
	

}
