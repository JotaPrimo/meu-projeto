package br.com.dominio.medicamento.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dominio.services.UsuarioService;
import br.com.dominio.utility.Message;
import br.com.dominio.utility.NegocioException;
import br.com.medicamento.model.Usuario;

@Named
@ViewScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Usuario> listUsuarios = new ArrayList<Usuario>();

	@Inject
	private Usuario usuario;

	@Inject
	private UsuarioService usuarioService;

	private String busca;

	@PostConstruct
	public void carregarListaUsuarios() {
		listUsuarios = usuarioService.listUsuarios();
	}

	public String store() {
		try {

			usuarioService.store(usuario);

			usuario = new Usuario();

			carregarListaUsuarios();

			Message.info("Usuário cadastrado com sucesso");

			return "";
		} catch (NegocioException e) {
			Message.fatal(e.getMessage());

			return "";
		}
	}

	public String delete() {
		try {
			usuarioService.delete(usuario);

			Message.info("Usuário deletado com sucesso");

			listUsuarios = usuarioService.listUsuarios();

			return "";

		} catch (Exception e) {

			Message.info("Usuário cadastrado com sucesso");

			return "";
		}
	}
	
	public String pesquisar() {
		
		listUsuarios = usuarioService.filtrarUsuarios("nome", " LIKE ", busca);
		
		return "";
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

}
