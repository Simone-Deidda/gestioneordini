package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;

import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;
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

			testInserimentoOrdine(ordineServiceInstance);
			
			testInserimentoCategoria(categoriaServiceInstance);
			
			testInserimentoArticolo(articoloServiceInstance, ordineServiceInstance);
			
			//testAggiornaOrdine(ordineServiceInstance);
			
			//testAggiungiArticoloAOrdine(ordineServiceInstance);
			
			//testRimuoviArticoloAOrdine(ordineServiceInstance);
			
			//testAggiungiArticoloACategoria(ordineServiceInstance);
			
			//testRimuoviArticoloACategoria(ordineServiceInstance);
			
			//testAggiungiCategoriaAdArticolo(ordineServiceInstance);
			
			//testRimuoviCategoriaAdArticolo(ordineServiceInstance);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testInserimentoOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testInserimentoOrdine >>>>>>>>>>");
		
		Ordine nuovoOrdine = new Ordine("Gianfranco Mura", "via Curiel", new SimpleDateFormat("dd/MM/yyyy").parse("24/09/2021"));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);
		if (nuovoOrdine.getId() == null) {
			throw new RuntimeException("testInserimentoOrdine fallito: l'Ordine non è stato inserito correttamente.");
		}
		
		System.out.println("\n<<<<<<<<<< Fine testInserimentoOrdine: PASSATO >>>>>>>>>>");
	}
	
	private static void testInserimentoCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testInserimentoCategoria >>>>>>>>>>");
		
		Categoria nuovoCategoria = new Categoria("Frutta", "CODICE_001");
		categoriaServiceInstance.inserisciNuovo(nuovoCategoria);
		if (nuovoCategoria.getId() == null) {
			throw new RuntimeException("testInserimentoCategoria fallito: la Categoria non è stato inserito correttamente.");
		}
		
		System.out.println("\n<<<<<<<<<< Fine testInserimentoCategoria: PASSATO >>>>>>>>>>");
	}
	
	private static void testInserimentoArticolo(ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testInserimentoArticolo >>>>>>>>>>");
		
		Articolo nuovoArticolo = new Articolo("Mela", "0001122233", 1, new SimpleDateFormat("dd/MM/yyyy").parse("22/05/2022"));
		Ordine primOrdine = ordineServiceInstance.listAll().get(0);
		nuovoArticolo.setOrdine(primOrdine);
		
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException("testInserimentoArticolo fallito: l'Articolo non è stato inserito correttamente.");
		}
		
		System.out.println("\n<<<<<<<<<< Fine testInserimentoArticolo: PASSATO >>>>>>>>>>");
	}

	private static void testAggiornaOrdine(OrdineService ordineServiceInstance) throws Exception  {
		System.out.println("\n<<<<<<<<<< Inizio testAggiornaOrdine >>>>>>>>>>");
		
		System.out.println("<<<<<<<<<< Fine testAggiornaOrdine: PASSATO >>>>>>>>>>");
	}

	private static void testAggiungiArticoloAOrdine(OrdineService ordineServiceInstance) throws Exception  {
		System.out.println("\n<<<<<<<<<< Inizio testAggiungiArticoloAOrdine >>>>>>>>>>");
		
		System.out.println("<<<<<<<<<< Fine testAggiungiArticoloAOrdine: PASSATO >>>>>>>>>>");
	}

	private static void testRimuoviArticoloAOrdine(OrdineService ordineServiceInstance) throws Exception  {
		System.out.println("\n<<<<<<<<<< Inizio testRimuoviArticoloAOrdine >>>>>>>>>>");
		
		System.out.println("<<<<<<<<<< Fine testRimuoviArticoloAOrdine: PASSATO >>>>>>>>>>");
	}

	private static void testAggiungiArticoloACategoria(OrdineService ordineServiceInstance) throws Exception  {
		System.out.println("\n<<<<<<<<<< Inizio testAggiungiArticoloACategoria >>>>>>>>>>");
		
		System.out.println("<<<<<<<<<< Fine testAggiungiArticoloACategoria: PASSATO >>>>>>>>>>");
	}

	private static void testRimuoviArticoloACategoria(OrdineService ordineServiceInstance) throws Exception  {
		System.out.println("\n<<<<<<<<<< Inizio testRimuoviArticoloACategoria >>>>>>>>>>");
		
		System.out.println("<<<<<<<<<< Fine testRimuoviArticoloACategoria: PASSATO >>>>>>>>>>");
	}

	private static void testAggiungiCategoriaAdArticolo(OrdineService ordineServiceInstance) throws Exception  {
		System.out.println("\n<<<<<<<<<< Inizio testAggiungiCategoriaAdArticolo >>>>>>>>>>");
		
		System.out.println("<<<<<<<<<< Fine testAggiungiCategoriaAdArticolo: PASSATO >>>>>>>>>>");
	}

	private static void testRimuoviCategoriaAdArticolo(OrdineService ordineServiceInstance) throws Exception  {
		System.out.println("\n<<<<<<<<<< Inizio testRimuoviCategoriaAdArticolo >>>>>>>>>>");
		
		System.out.println("<<<<<<<<<< Fine testRimuoviCategoriaAdArticolo: PASSATO >>>>>>>>>>");
	}

}
