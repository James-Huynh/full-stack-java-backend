package dev.jameshuynh.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

	/*
	@GetMapping({"/", "/{year}"})
	public ResponseEntity<List<Movie>> getAllMovies(@PathVariable(required = false) String year) {
		return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
	}
	*/

    @GetMapping({"/", "/{releaseDate}"})
    public ResponseEntity<List<Movie>> getAllMovies(@PathVariable Optional<String> optReleaseDate) {

        List<Movie> movies = optReleaseDate.map(movieService::moviesByYear)
                .orElseGet(movieService::allMovies);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Optional<Movie>> getSingleMovie(@RequestParam String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
