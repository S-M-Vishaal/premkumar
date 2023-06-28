package com.example.SpringBootJunit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="movie1000")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id

	   private Integer id;

	   private String name;

	   private String language;

	   private String type;

	   private Integer rating;
}
