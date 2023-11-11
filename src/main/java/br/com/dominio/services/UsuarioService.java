package br.com.dominio.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.dominio.utility.NegocioException;
import br.com.medicamento.dao.DAO;
import br.com.medicamento.model.Usuario;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Usuario> dao;

	public void store(Usuario usuario) throws NegocioException {
		dao.salvar(usuario);
	}

	public void delete(Usuario usuario) throws NegocioException {
		dao.remover(Usuario.class, usuario.getId());
	}

	public List<Usuario> listUsuarios() {
		return dao.buscarTodos("select u from Usuario u order by u.nome asc");
	}

	public List<Usuario> filtrarUsuarios(String campo, String operadorComparacao, String valor) {
		return dao.filtrar("select u from Usuario u where " + campo + " " + operadorComparacao + 
				" '%" + valor
				+ "%' order by u.nome asc");
	}
}
