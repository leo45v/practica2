package com.tienda.response;

import java.io.Serializable;

public class TiendaResponse<T> implements Serializable {
	private static final long serialVersionUID = -5482666144624843367L;

	private String status;
	private String code;
	private String message;
	private T data;

	public TiendaResponse(String status, String code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public TiendaResponse(String status, String code, String message, T data) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
