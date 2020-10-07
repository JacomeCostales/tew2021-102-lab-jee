package com.tew.presentation;

public class SimpleBeanErrorFactory implements BeanErrorFactory{

	BeanError error;
	@Override
	public BeanError instanciaError() {
		if(error !=null) { 
			return error;
					}
		else { return new BeanError();}
		
	}

}
