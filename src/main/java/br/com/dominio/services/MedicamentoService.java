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
		if (medicamento.getNome().length() < 3) {
			throw new NegocioException("Nome do medicamento não pode ter menos que 3 caracteres");
		}

		dao.salvar(medicamento);
	}

	public void remover(Medicamento medicamento) throws NegocioException {
		dao.remover(Medicamento.class, medicamento.getId());
	}

	public List<Medicamento> todosOsMedicamentos() {
		// é só usar a classe no lugar da table
		return dao.buscarTodos("select m from Medicamento m order by m.nome");
	}

}
