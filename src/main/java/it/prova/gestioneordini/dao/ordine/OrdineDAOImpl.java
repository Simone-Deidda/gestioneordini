package it.prova.gestioneordini.dao.ordine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {
	private EntityManager entityManager;

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}
	
	@Override
	public Ordine findByIdFetching(Long idOrdine) {
		TypedQuery<Ordine> query = entityManager
				.createQuery("FROM Ordine o left join fetch o.articoli a where o.id = :idOrdine", Ordine.class);

		return query.setParameter("idOrdine", idOrdine).getSingleResult();
	}

	@Override
	public void update(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);
	}

	@Override
	public void delete(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public List<Ordine> listAllOrdiniOfCategoria(Categoria input) {
		TypedQuery<Ordine> query = entityManager.createQuery("select o from Ordine o join o.articoli a join a.categorie c where c.id = :idCategoria", Ordine.class);
		return query.setParameter("idCategoria", input.getId()).getResultList();
	}
	

	@Override
	public Ordine getOrdineConSpedizionePiuRecenteOfCategoria(Categoria input) {
		TypedQuery<Ordine> query = entityManager.createQuery("select o from Ordine o join o.articoli a join a.categorie c where c.id = ?1 order by o.dataSpedizione desc", Ordine.class);
		return query.setParameter(1, input.getId()).getResultList().get(0);
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	

}
