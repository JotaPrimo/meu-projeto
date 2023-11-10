package br.com.dominio.utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Message {
	
	public static void info(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "Info"));
	}

	public static void warn(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, msg, "Warning!" ));
	}

	public static void error(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "Error!"));
	}

	public static void fatal(String msg) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, "Fatal!"));
	}
	
}
