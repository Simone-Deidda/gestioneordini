package it.prova.gestioneordini.service.ordine;

import java.util.List;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.model.Articolo;
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
	public void rimuoviArticolo(Ordine ordineInstance, Articolo articoloInstance) throws Exception;
	
	public List<Ordine> listAllOrdiniAppartenentiA(Categoria input) throws Exception;

	public Ordine getOrdinePiuRecenteData(Categoria input);

	public Ordine caricaSingoloElementoEager(Long id);

	public List<String> listAllIndirizziOfNumeroSerialeArticoloContains(String stringa);
}
