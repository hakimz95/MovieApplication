package vttp.MovieApplication.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.MovieApplication.models.Movies;
import vttp.MovieApplication.services.MovieService;

@Controller
public class SearchMovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping("/search")
    public String searchMovie(Model model,@RequestParam(required = true) String query) {
        String queryString = query;
        //System.out.println("Query String: " + queryString);

        Optional<List<Movies>> optSearchMovies = movieService.getSearchMovie(queryString);

        if (optSearchMovies.isEmpty()) {
            model.addAttribute("searchMovies", new LinkedList<Movies>());
            return "trending";
        }

        List<Movies> searchMoviesList = optSearchMovies.get();

        model.addAttribute("queryString", queryString);
        model.addAttribute("searchMovies", searchMoviesList);

        return "search";
    }
}
