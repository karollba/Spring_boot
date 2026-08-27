package com.example.demo.movie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getAll() {
        return movieRepository.findAll()
                .stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
    }

    public MovieDTO findById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return null;
        }
        return new MovieDTO(movie);
    }
}
