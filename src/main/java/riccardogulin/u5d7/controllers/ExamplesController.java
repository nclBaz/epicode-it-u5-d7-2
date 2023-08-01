package riccardogulin.u5d7.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import riccardogulin.u5d7.entities.User;

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

	@PutMapping("/index")
	public String putExample() {
		return "CIAO SONO UNA PUT";
	}

	@DeleteMapping("/index")
	public String deleteExample() {
		return "CIAO SONO UNA DELETE";
	}

	@GetMapping("/queryParamsExample")
	public String queryParams(@RequestParam String name,
			@RequestParam(required = false) String surname) {

		System.out.println("QUERY PARAMS");
		System.out.println(name);
		System.out.println(surname);

		if (name != null && surname != null) {
			return "Hello " + name + " " + surname;
		} else {
			return "Hello non mi hai dato i tuoi dati";
		}
	}

	@GetMapping("/pathParamExample/{id}")
	public String pathParam(@PathVariable String id) {
		return "Ciao, sei sull'endpoint /pathParamExample/" + id;
	}

	@GetMapping("/pathParamExample")
	public String noPathParam() {
		return "Ciao, sei sull'endpoint /pathParamExample/";
	}

	@PostMapping("/payloadExample")
	public String payload(@RequestBody User user) {
		System.out.println(user);
		// Salva user a db
		return "bla bla bla";
	}

	@GetMapping("/example")
	@ResponseStatus(HttpStatus.NOT_FOUND) // La classe HttpStatus contiene l'elenco di tutti gli status code
	public String example() {
		return "example";
	}

	@GetMapping("/customResponseExample")
	public ResponseEntity<User> customResponse() {

		User body = new User(5, "Ajeje", "Brazorf");

		// Creo degli headers custom
		HttpHeaders headers = new HttpHeaders();
		headers.add("customHeader", "customValue");

//		return new ResponseEntity<>(body, headers, statuscode);
		return new ResponseEntity<User>(body, headers, HttpStatus.CREATED);
	}

	@GetMapping("/customUserResponseExample")
	public User customUserResponse() {

		User body = new User(5, "Ajeje", "Brazorf");
		return body; // Se il return type è un oggetto, Spring Web converte in JSON il body
	}
}
