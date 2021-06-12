package br.com.gerenciador.assembleias.model;

public enum VotoEnum {
	SIM("SIM"),
	NAO("NÃO");

	private String type = new String();

	VotoEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
