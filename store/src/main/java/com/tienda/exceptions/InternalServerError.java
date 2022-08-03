package com.tienda.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.tienda.dtos.ErrorDto;

public class InternalServerError extends TiendaException {
	private static final long serialVersionUID = 8878786675042828734L;

	public InternalServerError(String code, int responseCode, String message, ErrorDto error) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(error));
	}

	public InternalServerError(String code, int responseCode, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
}
