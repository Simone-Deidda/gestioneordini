package it.prova.gestioneordini.service.ordine;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.exceptions.CannotDeleteArticoloContainingCategorieException;
import it.prova.gestioneordini.exceptions.CannotDeleteOrdineContainingArticoliException;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class OrdineServiceImpl implements OrdineService {
	private OrdineDAO ordineDao;

	@Override
	public void setOrdineDAO(OrdineDAO ordineDao) {
		this.ordineDao = ordineDao;
	}

	@Override
	public List<Ordine> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			ordineDao.setEntityManager(entityManager);

			return ordineDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Ordine caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			ordineDao.setEntityManager(entityManager);
			return ordineDao.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	
	@Override
	public Ordine caricaSingoloElementoEager(Long id) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			ordineDao.setEntityManager(entityManager);
			return ordineDao.findByIdFetching(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			ordineDao.setEntityManager(entityManager);
			ordineDao.update(ordineInstance);

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
	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			ordineDao.setEntityManager(entityManager);
			ordineDao.insert(ordineInstance);

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
	public void rimuoviArticolo(Ordine ordineInstance, Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			ordineDao.setEntityManager(entityManager);

			ordineInstance = entityManager.merge(ordineInstance);
			articoloInstance = entityManager.merge(articoloInstance);

			ordineInstance.getArticoli().remove(articoloInstance);

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
	public void rimuovi(Long idOrdine) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			ordineDao.setEntityManager(entityManager);
			
			Ordine ordine = ordineDao.findByIdFetching(idOrdine);
			if (ordine == null || !ordine.getArticoli().isEmpty()) {
				throw new CannotDeleteOrdineContainingArticoliException("Non puoi eliminare un Ordine avente Articoli associate.");
			}
			
			ordineDao.delete(ordine);

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
	public List<Ordine> listAllOrdiniAppartenentiA(Categoria input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			ordineDao.setEntityManager(entityManager);

			return ordineDao.listAllOrdiniOfCategoria(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Ordine getOrdinePiuRecenteData(Categoria input) {
		return null;
	}

}
