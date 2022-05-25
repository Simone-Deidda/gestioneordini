package it.prova.gestioneordini.service.articolo;

import java.util.List;

import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface ArticoloService {
	// setter
	public void setArticoloDAO(ArticoloDAO articoloDao);

	// operazioni CRUD
	public List<Articolo> listAll() throws Exception;

	public Articolo caricaSingoloElemento(Long id) throws Exception;
	
	public Articolo caricaSingoloElementoEager(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Long idArticolo) throws Exception;
	
	// operazioni di Articolo
	public void aggiungiCategoria(Categoria categoriaInstance, Articolo articoloInstance) throws Exception;
	
	public void rimuoviCategoria(Categoria categoriaInstance, Articolo articoloInstance) throws Exception;
	
	public Long sommaPrezziArticoliAppartenentiACategoria(Categoria input);

	public Long sommaPrezziArticoliAppartenentiADestinatario(Ordine nuovoOrdine);
}
