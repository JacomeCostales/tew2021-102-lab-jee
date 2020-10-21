package com.tew.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@RequestScoped
public class GrowlError {
	
    private String message = "Error de ejemplo";
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String e) {
        this.message = "Error: ERROR DE EJEMPLO"+e;
    }
     
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(message) );
        
    }

	
    
    
}