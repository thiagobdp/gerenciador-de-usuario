package br.com.pollingmanager.model;

public enum AccreditationTypeEnum {
	BY_INCOME("BY_INCOME");

	private String type = new String();

	AccreditationTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
