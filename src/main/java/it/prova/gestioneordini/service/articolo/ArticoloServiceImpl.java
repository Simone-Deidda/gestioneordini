package it.prova.gestioneordini.service.articolo;

import java.util.List;

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
		return null;
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
	}

	@Override
	public void rimuovi(Long idArticolo) throws Exception {
	}

	@Override
	public Integer sommaPrezziArticoliAppartenentiA(Categoria input) {
		return null;
	}

}
