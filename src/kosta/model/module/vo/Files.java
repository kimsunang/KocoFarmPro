package kosta.model.module.vo;

import java.io.Serializable;

public class Files implements Serializable{
	private String file_id;
	private int file_size;
	private String file_name;
	private String file_path;
	private String file_date;
	private String file_icon_image;
	private String file_extention;
	private String emp_id;

	public Files(){}
	
	public Files(String file_id, int file_size, String file_name, String file_path, String file_date,
			String file_icon_image, String file_extention, String emp_id) {
		this.file_id = file_id;
		this.file_name = file_name;
		this.file_size = file_size;
		this.file_path = file_path;
		this.file_date = file_date;
		this.file_icon_image = file_icon_image;
		this.file_extention = file_extention;
		this.emp_id = emp_id;
	}


	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_date() {
		return file_date;
	}
	public void setFile_date(String file_date) {
		this.file_date = file_date;
	}
	public String getFile_icon_image() {
		return file_icon_image;
	}
	public void setFile_icon_image(String file_icon_image) {
		this.file_icon_image = file_icon_image;
	}
	public String getFile_extention() {
		return file_extention;
	}
	public void setFile_extention(String file_extention) {
		this.file_extention = file_extention;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

}
