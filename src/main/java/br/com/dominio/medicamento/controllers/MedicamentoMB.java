package br.com.dominio.medicamento.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dominio.services.MedicamentoService;
import br.com.dominio.utility.Message;
import br.com.dominio.utility.NegocioException;
import br.com.medicamento.model.Medicamento;

@Named
@ViewScoped
public class MedicamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Medicamento medicamento;

	@Inject
	private MedicamentoService medicamentoService;

	private List<Medicamento> medicamentos;

	@PostConstruct
	public void carregar() {
		medicamentos = medicamentoService.todosOsMedicamentos();
	}

	public String adicionar() {
		try {
			medicamentoService.salvar(medicamento);
			medicamento = new Medicamento();
			medicamentos = medicamentoService.todosOsMedicamentos();

			Message.info("Medicamento adicionado com sucesso");
			return "";

		} catch (NegocioException negocioException) {
			Message.error(negocioException.getMessage());
			return "";
		}
	}

	public String excluir() {
		try {							
			
			medicamentoService.remover(medicamento);		
			
			medicamentos = medicamentoService.todosOsMedicamentos();

			Message.info("Medicamento removido com sucesso");
			return "";

		} catch (NegocioException negocioException) {
			Message.error(negocioException.getMessage());
			return "";
		}
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

}
