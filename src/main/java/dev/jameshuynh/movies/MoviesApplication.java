package dev.jameshuynh.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class MoviesApplication {

	public static void main(String[] args) throws Exception {
		test();
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping("/")
	public ResponseEntity<String> apiRoot() {
		return new ResponseEntity<>("Hello, world!", HttpStatus.OK);
	}


	private static void test() {
		final int test = 1;

		// Exception handling
		try {
			System.out.println("throwing");
			throw new SecurityException("TestException");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("always executed");
		}
	}

}
