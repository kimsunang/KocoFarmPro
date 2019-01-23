package kosta.model.module.vo;

public class RentCarDetail {
	
	//private int seq;
	private String carId; //int->String으로 수정
	private String modelName;
	private String carModel;
	private String condition;
	private int price;
	private int year;
	private String oilType;
	private String regDt;
	private String upDt;
	
	
	public RentCarDetail() {}


	public RentCarDetail(String carId, String modelName, String carModel, String condition, int price, int year,
			String oilType, String regDt, String upDt) {
		this.carId = carId;
		this.modelName = modelName;
		this.carModel = carModel;
		this.condition = condition;
		this.price = price;
		this.year = year;
		this.oilType = oilType;
		this.regDt = regDt;
		this.upDt = upDt;
	}


	public String getCarId() {
		return carId;
	}


	public void setCarId(String carId) {
		this.carId = carId;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getCarModel() {
		return carModel;
	}


	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getOilType() {
		return oilType;
	}


	public void setOilType(String oilType) {
		this.oilType = oilType;
	}


	public String getRegDt() {
		return regDt;
	}


	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}


	public String getUpDt() {
		return upDt;
	}


	public void setUpDt(String upDt) {
		this.upDt = upDt;
	}


	@Override
	public String toString() {
		return "RentCarDetail [carId=" + carId + ", modelName=" + modelName + ", carModel=" + carModel + ", condition="
				+ condition + ", price=" + price + ", year=" + year + ", oilType=" + oilType + ", regDt=" + regDt
				+ ", upDt=" + upDt + "]";
	}



	
	
	
	
}
