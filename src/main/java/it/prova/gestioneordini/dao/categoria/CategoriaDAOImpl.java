package it.prova.gestioneordini.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO {
	private EntityManager entityManager;

	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Categoria o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);
	}

	@Override
	public void delete(Categoria o) throws Exception {
	}

	@Override
	public List<Categoria> listAllCategorieOfOrdine(Ordine input) {
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
