package it.prova.gestioneordini.dao.articolo;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public class ArticoloDAOImpl implements ArticoloDAO {
	private EntityManager entityManager;

	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public Articolo findByIdFetching(Long id) {

		TypedQuery<Articolo> query = entityManager
				.createQuery("FROM Articolo a left join fetch a.categorie c where a.id = :idArticolo", Articolo.class);

		return query.setParameter("idArticolo", id).getSingleResult();
	}

	@Override
	public void update(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);
	}

	@Override
	public void delete(Articolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public Long sumPrezziOfArticoliFromCategoria(Categoria input) {
		TypedQuery<Long> query = entityManager.createQuery("SELECT sum(a.prezzoSingolo) FROM Articolo a join a.categorie c WHERE c.id = :idCategoria", Long.class);
		return query.setParameter("idCategoria", input.getId()).getSingleResult();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
