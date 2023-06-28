package com.example.SpringBootJunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootJunit.entity.Movie;
import com.example.SpringBootJunit.repo.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired

    MovieRepository movieRepo;
	
	@Override
	public Movie insertMovie(Movie m) {
		// TODO Auto-generated method stub
		return movieRepo.save(m);
	}
	@Override

    public List<Movie> getAllMovies() {

                   return movieRepo.findAll();

    }
	@Override
	public Movie getMovieById(Integer id) {
		// TODO Auto-generated method stub
		return movieRepo.findById(id).get();
	}

}
