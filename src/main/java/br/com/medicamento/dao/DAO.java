package br.com.medicamento.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.com.medicamento.model.Base;

public class DAO<T extends Base> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static EntityManager manager = ConnectionFactory.getEntityManager();

	public T buscarPorId(Class<T> clazz, Long id) {
		return manager.find(clazz, id);
	}

	public void salvar(T entidade) {
		try {
			manager.getTransaction().begin();

			if (entidade.getId() == null) {
				manager.persist(entidade);
			} else {
				manager.merge(entidade);
			}

			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

}
