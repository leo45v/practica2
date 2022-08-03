package com.tienda.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.tienda.dtos.ErrorDto;

public class TiendaException extends Exception {
	private static final long serialVersionUID = 1L;

	private final String code;
	private final int responseCode;
	private final List<ErrorDto> errorList = new ArrayList<>();

	public TiendaException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public TiendaException(String code, int responseCode, String message, List<ErrorDto> errors) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errors);
	}
	
	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public List<ErrorDto> getErrorList() {
		return errorList;
	}
}
