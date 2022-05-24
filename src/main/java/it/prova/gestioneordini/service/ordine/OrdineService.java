package it.prova.gestioneordini.service.ordine;

import java.util.List;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineService {
	// setter
	public void setOrdineDAO(OrdineDAO ordineDao);

	// operazioni CRUD
	public List<Ordine> listAll() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Long idOrdine) throws Exception;

	// operazioni di Ordine
	public List<Ordine> listAllOrdiniAppartenentiA(Categoria input);

	public Ordine getOrdinePiuRecenteData(Categoria input);
}
