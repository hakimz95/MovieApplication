package vttp.MovieApplication.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import vttp.MovieApplication.models.Movies;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    //Get API key from environment variables in the computer system
    @Value("${TMDB_API_KEY}")
    private String apiKey;

    public Optional<List<Movies>> getTrendingMovies() {
        //API URL
        String trendingUrl = "https://api.themoviedb.org/3/trending/movie/week";

        //Create endpoint URL with query
        String trendingMovieUrl = UriComponentsBuilder.fromUriString(trendingUrl)
                                                    .queryParam("api_key", apiKey)
                                                    .queryParam("language", "en")
                                                    .toUriString();
        //logger.info("URL with params set up: " + trendingMovieUrl);
        List<Movies> trendingMovieList = new LinkedList<>();

        //Make a call to TMDB API
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;

        try {
            resp = template.getForEntity(trendingMovieUrl, String.class);
            trendingMovieList = Movies.createJsonGetMovies(resp.getBody());

            return Optional.of(trendingMovieList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<List<Movies>> getTopRatedMovies() {
        //API Url
        String topRatedUrl = "https://api.themoviedb.org/3/movie/top_rated";

        //Create endpoint URL with query
        String topRatedMovieUrl = UriComponentsBuilder.fromUriString(topRatedUrl)
                                                    .queryParam("api_key", apiKey)
                                                    .queryParam("language", "en")
                                                    .queryParam("page", "1")
                                                    .toUriString();
        List<Movies> topRatedMovieList = new LinkedList<>();

        //Make a call to TMDB API
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;

        try {
            resp = template.getForEntity(topRatedMovieUrl, String.class);
            topRatedMovieList = Movies.createJsonGetMovies(resp.getBody());

            return Optional.of(topRatedMovieList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<List<Movies>> getPopularMovies() {
        //API Url
        String popularUrl = "https://api.themoviedb.org/3/movie/popular";

        //Create endpoint URL with query
        String popularMovieUrl = UriComponentsBuilder.fromUriString(popularUrl)
                                                    .queryParam("api_key", apiKey)
                                                    .queryParam("language", "en")
                                                    .queryParam("page", "1")
                                                    .toUriString();
        List<Movies> popularMovieList = new LinkedList<>();

        //Make a call to TMDB API
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;

        try {
            resp = template.getForEntity(popularMovieUrl, String.class);
            popularMovieList = Movies.createJsonGetMovies(resp.getBody());

            return Optional.of(popularMovieList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<List<Movies>> getSearchMovie(String queryString) {
        //API Url
        String searchUrl = "https://api.themoviedb.org/3/search/movie";

        //Create endpoint URL with query
        String searchMovieUrl = UriComponentsBuilder.fromUriString(searchUrl)
                                                    .queryParam("api_key", apiKey)
                                                    .queryParam("language", "en")
                                                    .queryParam("query", queryString)
                                                    .queryParam("page", "1")
                                                    .queryParam("include_adult", "false")
                                                    .toUriString();
                                                    
        String searchUrlUpdate = searchMovieUrl.replace("%20", " ");
        logger.info("Search URL with query >>>" + searchMovieUrl);
        List<Movies> searchMovieList = new LinkedList<>();

        //Make a call to TMDB API
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;

        try {
            resp = template.getForEntity(searchUrlUpdate, String.class);
            searchMovieList = Movies.createJsonGetMovies(resp.getBody());
            //System.out.println("resp body: " + resp.getBody());
            
            return Optional.of(searchMovieList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movies> getMovieDetails(String id) {
        //API Url
        String detailsUrl = "https://api.themoviedb.org/3/movie/" + id + "?";

        //Create endpoint URL with query
        String movieDetailsUrl = UriComponentsBuilder.fromUriString(detailsUrl)
                                                    .queryParam("api_key", apiKey)
                                                    .queryParam("language", "en")
                                                    .toUriString();
        //logger.info("movieDetailsUrl: " + movieDetailsUrl);
        Movies movies = new Movies();

        //Make a call to TMDB API
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;

        try {
            resp = template.getForEntity(movieDetailsUrl, String.class);
            movies = Movies.createJsonMovieDetails(resp.getBody());
            //logger.info("resp body: " + resp.getBody());
            
            return Optional.of(movies);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
}
