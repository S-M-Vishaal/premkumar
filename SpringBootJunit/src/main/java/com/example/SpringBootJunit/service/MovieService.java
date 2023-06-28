package com.example.SpringBootJunit.service;

import java.util.List;

import com.example.SpringBootJunit.entity.Movie;


public interface MovieService {
	 public Movie insertMovie(Movie m);
	 public List<Movie> getAllMovies();
	 public Movie getMovieById(Integer id);
}
