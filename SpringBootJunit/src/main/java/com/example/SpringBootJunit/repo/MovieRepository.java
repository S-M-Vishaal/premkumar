package com.example.SpringBootJunit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootJunit.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
