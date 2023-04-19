package vttp.MovieApplication.restControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.MovieApplication.models.Movies;
import vttp.MovieApplication.services.MovieService;

@RestController
public class TopRatedMovieRestController {
    
    @Autowired
    private MovieService movieService;

    @CrossOrigin
    @GetMapping("/api/topRated")
    public List<Movies> getTopRatedMoviesAPI(Model model) {

        Optional<List<Movies>> optTopRatedMovies = movieService.getTopRatedMovies();
        List<Movies> topRatedMovieList = optTopRatedMovies.get();

        return topRatedMovieList;
    }
    
}
