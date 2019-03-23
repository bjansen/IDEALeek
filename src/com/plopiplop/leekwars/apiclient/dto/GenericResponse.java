package com.plopiplop.leekwars.apiclient.dto;

public class GenericResponse {

	private boolean success;
	private String error;
	private Object[][] result;

	public boolean isSuccess() {
		return success;
	}

	public String getError() {
		return error;
	}

	public Object[][] getResult() {
		return result;
	}
}
