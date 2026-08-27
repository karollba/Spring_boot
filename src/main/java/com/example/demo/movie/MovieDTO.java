package com.example.demo.movie;


import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private Director director;
    private List<Actor> actors;
    private Genre genre;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.director = movie.getDirector();
        this.actors = movie.getActors();
        this.genre = movie.getGenre();
    }
}
