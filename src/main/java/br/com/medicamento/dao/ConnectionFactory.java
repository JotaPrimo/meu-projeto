package br.com.medicamento.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CursoPU");

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
