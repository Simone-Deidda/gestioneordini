package it.prova.gestioneordini.service.categoria;

import java.util.List;

import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.dao.categoria.CategoriaDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface CategoriaService {
	// setter
	public void setCategoriaDAO(CategoriaDAO categoriaDao);

	// operazioni CRUD
	public List<Categoria> listAll() throws Exception;

	public Categoria caricaSingoloElemento(Long id) throws Exception;
	
	public Categoria caricaSingoloElementoEager(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Long idCategoria) throws Exception;
	
	// operazioni di Categoria
	public void aggiungiArticolo(Categoria categoriaInstance, Articolo articoloInstance) throws Exception;
	
	public void rimuoviArticolo(Categoria categoriaInstance, Articolo articoloInstance) throws Exception;
	
	public List<Categoria> listAllCategorieDatoOrdine(Ordine input) throws Exception;

}
