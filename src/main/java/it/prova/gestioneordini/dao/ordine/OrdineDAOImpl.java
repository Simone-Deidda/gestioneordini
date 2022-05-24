package it.prova.gestioneordini.dao.ordine;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	@Override
	public List<Ordine> list() throws Exception {
		return null;
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return null;
	}

	@Override
	public void update(Ordine o) throws Exception {
	}

	@Override
	public void insert(Ordine o) throws Exception {
	}

	@Override
	public void delete(Ordine o) throws Exception {
	}

	@Override
	public List<Ordine> listAllOrdiniOfCategoria(Categoria input) {
		return null;
	}
	

	@Override
	public Ordine getOrdinePiuRecenteOfCategoria(Categoria input) {
		return null;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
	}

}
