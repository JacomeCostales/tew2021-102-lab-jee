package com.tew.presentation;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.tew.model.Alumno;
@ManagedBean(name="error")
@SessionScoped
public class BeanError extends Alumno implements Serializable {
	 private static final long serialVersionUID = 55557L;
	 
	 private String vista;
	 private String metodo;
	 private String clase;
	 private String error;
	 
	 public BeanError(String vista,String metodo,String clase,String error) {
		 setVista(vista);
		 setMetodo(metodo);
		 setClase(clase);
		 setError(error);
	 }
	 public BeanError() {
		 new BeanError("POR DEFECTO","POR DEFECTO","POR DEFECTO","POR DEFECTO");
	 }

	
	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
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
