package riccardogulin.u5d7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import riccardogulin.u5d7.entities.User;
import riccardogulin.u5d7.exceptions.NotFoundException;
import riccardogulin.u5d7.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	UsersService usersService;

	// 1. - POST http://localhost:3001/users (+ req.body)
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201
	public User saveUser(@RequestBody User body) throws Exception {
		User createdUser = usersService.save(body);
		return createdUser;
	}

	// 2. - GET http://localhost:3001/users (+ opzionalmente query params)
	@GetMapping("")
	public List<User> getUsers() {
		return usersService.getUsers();
	}

	// 3. - GET http://localhost:3001/users/{id}
	@GetMapping("/{userId}")
	public User findById(@PathVariable int userId) throws Exception {
		return usersService.findById(userId).orElseThrow(() -> new NotFoundException(userId));
	}

	// 4. - PUT http://localhost:3001/users/{id} (+ req.body)
	@PutMapping("/{userId}")
	public User findAndUpdate(@PathVariable int userId, @RequestBody User body) throws Exception {
		return usersService.findByIdAndUpdate(userId, body).orElseThrow(() -> new NotFoundException(userId));
	}

	// 5. - DELETE http://localhost:3001/users/{id}
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
	public void findAndDelete(@PathVariable int userId) {
		usersService.findByIdAndDelete(userId);
	}

}
