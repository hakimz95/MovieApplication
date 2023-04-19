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
public class TrendingMovieRestController {

    @Autowired
    private MovieService movieService;
    
    @CrossOrigin
    @GetMapping("/api/trending")
    public List<Movies> getTrendingMoviesAPI(Model model) {

        Optional<List<Movies>> optTrendingMovies = movieService.getTrendingMovies();
        List<Movies> trendingMovieList = optTrendingMovies.get();

        return trendingMovieList;
    }
    
}
