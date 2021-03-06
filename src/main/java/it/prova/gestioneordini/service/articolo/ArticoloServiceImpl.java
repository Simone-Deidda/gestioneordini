package it.prova.gestioneordini.service.articolo;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.exceptions.CannotDeleteArticoloContainingCategorieException;
import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class ArticoloServiceImpl implements ArticoloService {
	private ArticoloDAO articoloDao;

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDao) {
		this.articoloDao = articoloDao;
	}

	@Override
	public List<Articolo> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			articoloDao.setEntityManager(entityManager);

			return articoloDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Articolo caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			articoloDao.setEntityManager(entityManager);
			return articoloDao.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	
	@Override
	public Articolo caricaSingoloElementoEager(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			articoloDao.setEntityManager(entityManager);
			return articoloDao.findByIdFetching(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			articoloDao.setEntityManager(entityManager);
			articoloDao.update(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			articoloDao.setEntityManager(entityManager);
			articoloDao.insert(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiungiCategoria(Categoria categoriaInstance, Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			articoloDao.setEntityManager(entityManager);

			categoriaInstance = entityManager.merge(categoriaInstance);
			articoloInstance = entityManager.merge(articoloInstance);

			articoloInstance.getCategorie().add(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	
	@Override
	public void rimuoviCategoria(Categoria categoriaInstance, Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			articoloDao.setEntityManager(entityManager);

			categoriaInstance = entityManager.merge(categoriaInstance);
			articoloInstance = entityManager.merge(articoloInstance);

			articoloInstance.getCategorie().remove(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Long idArticolo) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			articoloDao.setEntityManager(entityManager);
			
			Articolo articolo = articoloDao.findByIdFetching(idArticolo);
			if (articolo == null || !articolo.getCategorie().isEmpty()) {
				throw new CannotDeleteArticoloContainingCategorieException("Non puoi eliminare una Articolo avente Categorie associate.");
			}
			
			articoloDao.delete(articolo);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Long sommaPrezziArticoliAppartenentiACategoria(Categoria input) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			articoloDao.setEntityManager(entityManager);

			return articoloDao.sumPrezziOfArticoliFromCategoria(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Long sommaPrezziArticoliAppartenentiADestinatario(Ordine nuovoOrdine) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			articoloDao.setEntityManager(entityManager);

			return articoloDao.sumPrezziOfArticoliFromDestinatario(nuovoOrdine);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

}
