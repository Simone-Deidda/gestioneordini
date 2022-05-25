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
			System.out.println("Nella tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"Nella tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");

			testInserimentoOrdine(ordineServiceInstance);

			testInserimentoCategoria(categoriaServiceInstance);

			testInserimentoArticolo(articoloServiceInstance, ordineServiceInstance);

			testAggiornaOrdine(ordineServiceInstance);

			testAggiornaCategoria(categoriaServiceInstance);

			testAggiornaArticolo(articoloServiceInstance, ordineServiceInstance);

			// testAggiungiArticoloAOrdine(ordineServiceInstance);

			// testRimuoviArticoloAOrdine(ordineServiceInstance);

			testAggiungiArticoloACategoria(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);

			// testRimuoviArticoloACategoria(ordineServiceInstance);

			testAggiungiCategoriaAdArticolo(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);

			// testRimuoviCategoriaAdArticolo(ordineServiceInstance);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testInserimentoOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testInserimentoOrdine >>>>>>>>>>");

		Ordine nuovoOrdine = new Ordine("Gianfranco Mura", "via Curiel",
				new SimpleDateFormat("dd/MM/yyyy").parse("24/09/2021"));
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
			throw new RuntimeException(
					"testInserimentoCategoria fallito: la Categoria non è stato inserito correttamente.");
		}

		System.out.println("\n<<<<<<<<<< Fine testInserimentoCategoria: PASSATO >>>>>>>>>>");
	}

	private static void testInserimentoArticolo(ArticoloService articoloServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testInserimentoArticolo >>>>>>>>>>");

		Articolo nuovoArticolo = new Articolo("Mela", "0001122233", 1,
				new SimpleDateFormat("dd/MM/yyyy").parse("22/05/2022"));
		Ordine primOrdine = ordineServiceInstance.listAll().get(0);
		nuovoArticolo.setOrdine(primOrdine);

		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		if (nuovoArticolo.getId() == null) {
			throw new RuntimeException(
					"testInserimentoArticolo fallito: l'Articolo non è stato inserito correttamente.");
		}

		System.out.println("\n<<<<<<<<<< Fine testInserimentoArticolo: PASSATO >>>>>>>>>>");
	}

	private static void testAggiornaOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testAggiornaOrdine >>>>>>>>>>");
		Ordine nuovoOrdine = new Ordine("", "via Mosca", new SimpleDateFormat("dd/MM/yyyy").parse("24/09/2020"));
		ordineServiceInstance.inserisciNuovo(nuovoOrdine);

		String nome = "Franco Serri";
		nuovoOrdine.setNomeDestinatario(nome);
		ordineServiceInstance.aggiorna(nuovoOrdine);

		Ordine foundById = ordineServiceInstance.caricaSingoloElemento(nuovoOrdine.getId());
		if (foundById == null || !foundById.getId().equals(nuovoOrdine.getId())) {
			throw new RuntimeException("testAggiornaOrdine fallito: l'Ordine ricercato per ID non combacia.");
		}

		if (foundById.getNomeDestinatario().isEmpty() || !foundById.getNomeDestinatario().equals(nome)) {
			throw new RuntimeException(
					"testAggiornaOrdine fallito: l'Ordine ricercato per ID non contiene i campi aggiornati.");
		}

		System.out.println("<<<<<<<<<< Fine testAggiornaOrdine: PASSATO >>>>>>>>>>");
	}

	private static void testAggiornaCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testAggiornaCategoria >>>>>>>>>>");
		Categoria nuovaCategoria = new Categoria("", "CODICE_007");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);

		String descrizione = "Pesce";
		nuovaCategoria.setDescrizione(descrizione);
		categoriaServiceInstance.aggiorna(nuovaCategoria);

		Categoria foundById = categoriaServiceInstance.caricaSingoloElemento(nuovaCategoria.getId());
		if (foundById == null || !foundById.getId().equals(nuovaCategoria.getId())) {
			throw new RuntimeException("testAggiornaCategoria fallito: la Categoria ricercata per ID non combacia.");
		}

		if (foundById.getDescrizione().isEmpty() || !foundById.getDescrizione().equals(descrizione)) {
			throw new RuntimeException(
					"testAggiornaCategoria fallito: la Categoria ricercata per ID non contiene i campi aggiornati.");
		}

		System.out.println("<<<<<<<<<< Fine testAggiornaCategoria: PASSATO >>>>>>>>>>");
	}

	private static void testAggiornaArticolo(ArticoloService articoloServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testAggiornaArticolo >>>>>>>>>>");
		Ordine primoOrdine = ordineServiceInstance.listAll().get(0);
		Articolo nuovoArticolo = new Articolo("", "5559966777", 20,
				new SimpleDateFormat("dd/MM/yyyy").parse("21/05/2022"));
		nuovoArticolo.setOrdine(primoOrdine);
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);

		String descrizione = "Merluzzo";
		nuovoArticolo.setDescrizione(descrizione);
		articoloServiceInstance.aggiorna(nuovoArticolo);

		Articolo foundById = articoloServiceInstance.caricaSingoloElemento(nuovoArticolo.getId());
		if (foundById == null || !foundById.getId().equals(nuovoArticolo.getId())) {
			throw new RuntimeException("testAggiornaArticolo fallito: l'Articolo ricercato per ID non combacia.");
		}

		if (foundById.getDescrizione().isEmpty() || !foundById.getDescrizione().equals(descrizione)) {
			throw new RuntimeException(
					"testAggiornaArticolo fallito: l'Articolo ricercato per ID non contiene i campi aggiornati.");
		}

		System.out.println("<<<<<<<<<< Fine testAggiornaArticolo: PASSATO >>>>>>>>>>");
	}

	private static void testAggiungiArticoloAOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testAggiungiArticoloAOrdine >>>>>>>>>>");

		System.out.println("<<<<<<<<<< Fine testAggiungiArticoloAOrdine: PASSATO >>>>>>>>>>");
	}

	private static void testRimuoviArticoloAOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testRimuoviArticoloAOrdine >>>>>>>>>>");

		System.out.println("<<<<<<<<<< Fine testRimuoviArticoloAOrdine: PASSATO >>>>>>>>>>");
	}

	private static void testAggiungiArticoloACategoria(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testAggiungiArticoloACategoria >>>>>>>>>>");
		
		Articolo nuovoArticolo = new Articolo("Gelato", "7775588833", 10, new SimpleDateFormat("dd/MM/yyyy").parse("18/05/2022"));
		nuovoArticolo.setOrdine(ordineServiceInstance.listAll().get(0));
		articoloServiceInstance.inserisciNuovo(nuovoArticolo);
		
		Categoria primaCategoria = categoriaServiceInstance.listAll().get(0);
		categoriaServiceInstance.aggiungiArticolo(primaCategoria, nuovoArticolo);
		
		Categoria eager = categoriaServiceInstance.caricaSingoloElementoEager(primaCategoria.getId());
		if (eager == null || !eager.getId().equals(primaCategoria.getId())) {
			throw new RuntimeException("testAggiungiArticoloACategoria fallito: la Categoria ricercato per ID (con eager Articoli) non combacia.");
		}
		
		if (eager.getArticoli() == null || eager.getArticoli().add(nuovoArticolo)) {
			throw new RuntimeException("testAggiungiArticoloACategoria fallito: l'Articolo non è stato inserto correttamente.");
		}

		System.out.println("<<<<<<<<<< Fine testAggiungiArticoloACategoria: PASSATO >>>>>>>>>>");
	}

	private static void testRimuoviArticoloACategoria(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testRimuoviArticoloACategoria >>>>>>>>>>");

		System.out.println("<<<<<<<<<< Fine testRimuoviArticoloACategoria: PASSATO >>>>>>>>>>");
	}

	private static void testAggiungiCategoriaAdArticolo(OrdineService ordineServiceInstance, ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testAggiungiCategoriaAdArticolo >>>>>>>>>>");
		
		Articolo primoArticolo = articoloServiceInstance.listAll().get(0);
		Categoria nuovaCategoria = new Categoria("Dolci", "CODICE_013");
		categoriaServiceInstance.inserisciNuovo(nuovaCategoria);
		
		articoloServiceInstance.aggiungiCategoria(nuovaCategoria, primoArticolo);
		
		Articolo eager = articoloServiceInstance.caricaSingoloElementoEager(primoArticolo.getId());
		if (eager == null || !eager.getId().equals(primoArticolo.getId())) {
			throw new RuntimeException("testAggiungiCategoriaAdArticolo fallito: l'Articolo ricercato per ID (con eager Categorie) non combacia.");
		}
		
		if (eager.getCategorie() == null || eager.getCategorie().add(nuovaCategoria)) {
			throw new RuntimeException("testAggiungiArticoloACategoria fallito: la Categoria non è stato inserto correttamente.");
		}
		System.out.println("<<<<<<<<<< Fine testAggiungiCategoriaAdArticolo: PASSATO >>>>>>>>>>");
	}

	private static void testRimuoviCategoriaAdArticolo(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("\n<<<<<<<<<< Inizio testRimuoviCategoriaAdArticolo >>>>>>>>>>");

		System.out.println("<<<<<<<<<< Fine testRimuoviCategoriaAdArticolo: PASSATO >>>>>>>>>>");
	}

}
