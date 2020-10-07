package com.tew.presentation;

import javax.faces.context.FacesContext;

public class SimpleBeanAlumnoFactory implements BeanAlumnoFactory {

	BeanAlumno alumno;
	
	
	@Override
	public BeanAlumno instanciaAlumno() {
		
		
		alumno = (BeanAlumno) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("alumno"));
		
		if (alumno == null) {
			System.out.println("BeanAlumnos - No existia");
			alumno = new BeanAlumno();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "alumno",alumno);
		}
		
		return alumno;
	}

}
