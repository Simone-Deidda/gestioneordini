package it.prova.gestioneordini.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface IBaseDAO<T> {

	public List<T> list() throws Exception;

	public T get(Long id) throws Exception;

	public void update(T o) throws Exception;

	public void insert(T o) throws Exception;

	public void delete(T o) throws Exception;

	// questo mi serve per l'injection
	public void setEntityManager(EntityManager entityManager);


}
