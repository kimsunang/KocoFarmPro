package kosta.model.module.vo;

import java.io.Serializable;

public class NoticeSearch implements Serializable {
	private String schType;
	private String schWord;

	public String getSchType() {
		return schType;
	}

	public void setSchType(String schType) {
		this.schType = schType;
	}

	public String getSchWord() {
		return schWord;
	}

	public void setSchWord(String schWord) {
		this.schWord = schWord;
	}
	
}