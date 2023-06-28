package com.example.SpringBootJunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJunit.entity.Movie;
import com.example.SpringBootJunit.service.MovieService;

@RestController

@RequestMapping("/movie")
public class MovieController {
	
	@Autowired

    MovieService movieService;

    @PostMapping(value="/insertMovie",consumes="application/json")
    public Movie insertMovie(@RequestBody Movie movie) {
                return movieService.insertMovie(movie);
       

}
    @GetMapping(value="/movies",produces="application/json")

    public List<Movie> getAllMovies(){

                   return movieService.getAllMovies();

    }
    
    @GetMapping("/movieById/{id}")
    public Movie getMovieById(@PathVariable("id") Integer mid) {
    	return movieService.getMovieById(mid);
    }

}
