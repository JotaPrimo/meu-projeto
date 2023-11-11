package br.com.medicamento.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	public void remover(Class<T> clazz, Long id) {
		T t = buscarPorId(clazz, id);
		try {
			manager.getTransaction().begin();

			manager.remove(t);

			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(String jpql) {
		Query query = manager.createQuery(jpql);

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> filtrar(String jpql) {
		System.out.println(jpql);
		Query query = manager.createQuery(jpql);

		return query.getResultList();
	}
	

}
