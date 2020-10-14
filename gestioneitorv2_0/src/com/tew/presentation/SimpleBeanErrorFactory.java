package com.tew.presentation;

public class SimpleBeanErrorFactory implements BeanErrorFactory{

	BeanError error;
	@Override
	public BeanError instanciaError() {
		if(error !=null) {System.out.println("CREADO BEAN ERROR"); 
			return error;
					}
		else { return new BeanError();}
		
	}

}
