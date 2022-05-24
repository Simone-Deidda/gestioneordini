package it.prova.gestioneordini.service.ordine;

import java.util.List;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
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
		return null;
	}

	@Override
	public Ordine caricaSingoloElemento(Long id) throws Exception {
		return null;
	}

	@Override
	public void aggiorna(Ordine ordineInstance) throws Exception {
	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
	}

	@Override
	public void rimuovi(Long idOrdine) throws Exception {
	}

	@Override
	public List<Ordine> listAllOrdiniAppartenentiA(Categoria input) {
		return null;
	}

	@Override
	public Ordine getOrdinePiuRecenteData(Categoria input) {
		return null;
	}

}
