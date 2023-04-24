package vttp.MovieApplication.restControllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vttp.MovieApplication.models.Movies;
import vttp.MovieApplication.services.MovieService;

@RestController
public class MovieDetailRestController {
    
    @Autowired
    private MovieService movieService;

    @CrossOrigin
    @GetMapping("/api/detail/{id}")
    public Movies generateMovieDetails(Model model, @PathVariable String id) {
        
        Optional<Movies> optMovie = movieService.getMovieDetails(id);
        Movies movieDetails = optMovie.get();

        return movieDetails;
    }
}
