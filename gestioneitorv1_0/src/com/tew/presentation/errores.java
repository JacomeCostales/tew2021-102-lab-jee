package com.tew.presentation;

public class errores {
	String ventana;
	String metodo;
	String clase;
	String error;
	
	public errores() {
		this.ventana ="GENERICO";
		this.metodo="GENERICO";
		this.clase="GENERICO";
		this.error="GENERICO";
	}
	
	public errores(String v, String m, String c, String e) {
		this.ventana =v;
		this.metodo=m;
		this.clase=c;
		this.error=e;
		
	}

	public String getVentana() {
		return ventana;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
