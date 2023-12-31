package com.example.SpringBootJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.SpringBootJunit.entity.Movie;
import com.example.SpringBootJunit.repo.MovieRepository;
import com.example.SpringBootJunit.service.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MovieControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieServiceImpl movieImpl;

    @MockBean
    MovieRepository movieRepo;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testInsertMovie() throws Exception {
        Movie m = new Movie(105, "Tamil", "Pizza", "Thriller", 4);
        Mockito.when(movieRepo.save(m)).thenReturn(m);
        Mockito.when(movieImpl.insertMovie(ArgumentMatchers.any())).thenReturn(m);
        String movieJson = mapper.writeValueAsString(m);

        MvcResult result = mockMvc.perform(post("/movie/insertMovie").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8").content(movieJson).accept(MediaType.APPLICATION_JSON)).andReturn();
        String res = result.getResponse().getContentAsString();
        Movie mov = new ObjectMapper().readValue(res, Movie.class);
        assertEquals((Integer) 105, mov.getId());
    }

    @Test
    public void testGetAllMovies() throws Exception {
        List<Movie> l = new ArrayList<>();
        l.add(new Movie(106, "hindi", "Dangal", "Sports", 4));
        l.add(new Movie(107, "hindi", "Dhoom", "Thriller", 3));

        Mockito.when(movieImpl.getAllMovies()).thenReturn(l);
        MvcResult result = mockMvc.perform(get("/movie/movies")).andReturn();
        String res = result.getResponse().getContentAsString();
        List<Movie> mlist = Arrays.asList(mapper.readValue(res, Movie[].class));
        assertEquals(l.size(), mlist.size());
    }

    @Test
    public void testGetMovieById() throws Exception {
        Movie m = new Movie(108, "tamil", "robo", "action", 3);
        Mockito.when(movieImpl.getMovieById(Mockito.anyInt())).thenReturn(m);
        MvcResult result = mockMvc.perform(get("/movie/movieById/108")).andReturn();
        String res = result.getResponse().getContentAsString();
        Movie mov = new ObjectMapper().readValue(res, Movie.class);
        assertEquals(m.getName(), mov.getName());
    }
}
