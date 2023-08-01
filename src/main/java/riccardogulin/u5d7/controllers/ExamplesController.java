package riccardogulin.u5d7.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Serve per definire una "collezione" di endpoints
@RequestMapping("/examples") // Serve per stabilire un prefisso comune a tutti gli endpoints di questo
								// controller
public class ExamplesController {

	@GetMapping("/index") // Tra le parentesi specifico la parte finale dell'URL
	public String index() {
		return "Pagina principale";
	}

	@GetMapping("/about")
	public String about() {
		return "Pagina about";
	}

	@PostMapping("/index")
	public String postExample() {
		return "CIAO SONO UNA POST";
	}

}
