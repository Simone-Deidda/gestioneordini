package it.prova.gestioneordini.service.articolo;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

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
		return null;
	}

	@Override
	public void aggiorna(Articolo articoloInstance) throws Exception {
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
	public void rimuovi(Long idArticolo) throws Exception {
	}

	@Override
	public Integer sommaPrezziArticoliAppartenentiA(Categoria input) {
		return null;
	}

}
