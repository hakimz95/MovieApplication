package vttp.MovieApplication.restControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp.MovieApplication.models.Movies;
import vttp.MovieApplication.services.MovieService;

@CrossOrigin
@RestController
public class SearchMovieRestController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/api/search")
    public List<Movies> searchMovieAPI(Model model,@RequestParam(required = true) String query) {
        String queryString = query;
        System.out.println("Query String: " + queryString);

        Optional<List<Movies>> optSearchMovies = movieService.getSearchMovie(queryString);
        List<Movies> searchMoviesList = optSearchMovies.get();

        return searchMoviesList;
    }
    
}
