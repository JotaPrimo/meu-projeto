package br.com.dominio.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.dominio.utility.NegocioException;
import br.com.medicamento.dao.DAO;
import br.com.medicamento.model.Medicamento;

public class MedicamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Medicamento> dao;

	public void salvar(Medicamento medicamento) throws NegocioException {
		dao.salvar(medicamento);
	}

	public void remover(Medicamento medicamento) throws NegocioException {
		dao.remover(Medicamento.class, medicamento.getId());
	}

	public List<Medicamento> todosOsMedicamentos() {
		return dao.buscarTodos("select m from Medicamento m order by m.nome");
	}

}
