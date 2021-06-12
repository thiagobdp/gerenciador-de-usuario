package br.com.gerenciador.assembleias.controller.dto;

public class UserAccreditationDto {

	private Boolean success;
	private Boolean accredited;

	public UserAccreditationDto(boolean success, boolean accredited) {
		this.success = success;
		this.accredited = accredited;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getAccredited() {
		return accredited;
	}

	public void setAccredited(Boolean accredited) {
		this.accredited = accredited;
	}

}
