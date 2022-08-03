package com.tienda.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.tienda.dtos.ErrorDto;

public class NotFoundException extends TiendaException {
	private static final long serialVersionUID = -3135538726273024662L;

	public NotFoundException(String code, int responseCode, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}

	public NotFoundException(String code, int responseCode, String message, ErrorDto error) {
		super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(error));
	}
}
