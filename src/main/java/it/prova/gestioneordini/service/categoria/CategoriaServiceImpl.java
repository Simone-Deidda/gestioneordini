package it.prova.gestioneordini.service.categoria;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.categoria.CategoriaDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class CategoriaServiceImpl implements CategoriaService {
	private CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			categoriaDAO.setEntityManager(entityManager);

			return categoriaDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Categoria caricaSingoloElemento(Long id) throws Exception {
		return null;
	}

	@Override
	public void aggiorna(Categoria categoriaInstance) throws Exception {
	}

	@Override
	public void inserisciNuovo(Categoria categoriaInstance) throws Exception {
	}

	@Override
	public void rimuovi(Long idCategoria) throws Exception {
	}

	@Override
	public List<Categoria> listAllCategorieDatoOrdine(Ordine input) throws Exception {
		return null;
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDao) {
		this.categoriaDAO = categoriaDao;
	}

}
