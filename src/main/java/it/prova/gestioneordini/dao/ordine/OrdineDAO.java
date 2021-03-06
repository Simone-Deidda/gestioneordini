package it.prova.gestioneordini.dao.ordine;

import java.util.List;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {
	public List<Ordine> listAllOrdiniOfCategoria(Categoria input);
	
	public Ordine getOrdineConSpedizionePiuRecenteOfCategoria(Categoria input);

	public Ordine findByIdFetching(Long idOrdine);

	public List<String> listAllIndirizziOfNumeroSerialeArticolo(String stringa);
	
	
}
