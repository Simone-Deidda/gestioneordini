package it.prova.gestioneordini.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	public Categoria findByIdFetching(Long id) {
		TypedQuery<Categoria> query = entityManager
				.createQuery("select c FROM Categoria c left join fetch c.articoli a where c.id = :idCategoria", Categoria.class);
		query.setParameter("idCategoria", id);
		return query.getResultList().stream().findFirst().orElse(null);
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
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public List<Categoria> listAllCategorieOfOrdine(Ordine input) {
		TypedQuery<Categoria> query = entityManager.createQuery("select c from Categoria c join c.articoli a join a.ordine o where o.id = :idOrdine", Categoria.class);
		return query.setParameter("idOrdine", input.getId()).getResultList();
	}

	@Override
	public List<String> listAllCodesOfOrdineInFebbraio() {
		TypedQuery<String> query = entityManager.createQuery("select distinct c.codice from Categoria c join c.articoli a join a.ordine o where o.dataSpedizione between '2022-02-01' and '2022-02-28'", String.class);
		return query.getResultList();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	

}
