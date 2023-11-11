package br.com.dominio.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.medicamento.model.Usuario;

@Named
@ViewScoped
public class BuscaMB {
	
	public void selecionarUsuario(Usuario usuario) {
		RequestContext.getCurrentInstance().closeDialog(usuario);
		
	}
}
