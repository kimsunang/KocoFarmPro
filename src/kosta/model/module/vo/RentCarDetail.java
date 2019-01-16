package kosta.model.module.vo;

public class RentCarDetail {
	
	//private int seq;
	private String car_id; //int->String으로 수정
	private String modelName;
	private String carModel;
	private String condition;
	private int price;
	private int year;
	private String oil_Type;
	private String REG_DT;
	private String UP_DT;
	
	
	public RentCarDetail() {}


	public RentCarDetail(String car_id, String modelName, String carModel, String condition, int price, int year,
			String oil_Type, String rEG_DT, String uP_DT) {
		super();
		this.car_id = car_id;
		this.modelName = modelName;
		this.carModel = carModel;
		this.condition = condition;
		this.price = price;
		this.year = year;
		this.oil_Type = oil_Type;
		REG_DT = rEG_DT;
		UP_DT = uP_DT;
	}


	public String getCar_id() {
		return car_id;
	}


	public void setCar_id(String car_id) {
		this.car_id = car_id;
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


	public String getOil_Type() {
		return oil_Type;
	}


	public void setOil_Type(String oil_Type) {
		this.oil_Type = oil_Type;
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


	@Override
	public String toString() {
		return "RentCarDetail [car_id=" + car_id + ", modelName=" + modelName + ", carModel=" + carModel
				+ ", condition=" + condition + ", price=" + price + ", year=" + year + ", oil_Type=" + oil_Type
				+ ", REG_DT=" + REG_DT + ", UP_DT=" + UP_DT + "]";
	}



	
	
	
	
}
