package com.example.SpringBootJunit;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringBootJunit.entity.Movie;
import com.example.SpringBootJunit.repo.MovieRepository;

@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepo;

    @Test
    public void testInsertMovie() {
        Movie m = new Movie(104, "Big Bang Theory", "English", "Comedy", 4);
        Movie savedInDB = movieRepo.save(m);
        Optional<Movie> opt = movieRepo.findById(savedInDB.getId());
        assertTrue(opt.isPresent());
        Movie getFromDb = opt.get();
        assertEquals(savedInDB.getId(), getFromDb.getId());
    }
    @Test
    public void testGetAllMovies() {
    	List<Movie> list = movieRepo.findAll();
    	List <Movie> mlist=new ArrayList<>();
    	for(Movie m:list)
    		mlist.add(m);
    	assertThat(mlist.size()).isEqualto(2));
    }
    @Test
    public void testGetMovieById() {
    	Movie m = movieRepo.findById(102).get();
    	assertEquals(m.getType(),"Horror");
    }
    
}
