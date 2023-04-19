package vttp.MovieApplication.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vttp.MovieApplication.models.Movies;
import vttp.MovieApplication.services.MovieService;

@Controller
public class TrendingMovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/trending")
    public String generateTrendingMovies(Model model) {
        Optional<List<Movies>> optTrendingMovies = movieService.getTrendingMovies();
        
        if (optTrendingMovies.isEmpty()) {
            model.addAttribute("trendingMovies", new LinkedList<Movies>());
            return "trending";
        }

        List<Movies> trendingMovieList = optTrendingMovies.get();
        //System.out.println(trendingMovieList);

        model.addAttribute("trendingMovies", trendingMovieList);

        return "trending";
    }
}
