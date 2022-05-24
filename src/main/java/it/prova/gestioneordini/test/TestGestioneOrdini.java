package it.prova.gestioneordini.test;

import it.prova.gestioneordini.service.MyServiceFactory;
import it.prova.gestioneordini.service.articolo.ArticoloService;
import it.prova.gestioneordini.service.categoria.CategoriaService;
import it.prova.gestioneordini.service.ordine.OrdineService;

public class TestGestioneOrdini {

	public static void main(String[] args) {
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();

		try {
			System.out.println(
					"Nella tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"Nella tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"Nella tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
