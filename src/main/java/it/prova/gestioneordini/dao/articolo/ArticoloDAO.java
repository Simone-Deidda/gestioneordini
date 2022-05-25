package it.prova.gestioneordini.dao.articolo;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface ArticoloDAO extends IBaseDAO<Articolo>{
	public Long sumPrezziOfArticoliFromCategoria(Categoria input);

	public Articolo findByIdFetching(Long id);

	public Long sumPrezziOfArticoliFromDestinatario(Ordine nuovoOrdine);
}
