package com.example.demo.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ScreeningDTO {

    private Long id;
    private String movieTitle;
    private List<Actor> actors;
    private Director director;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Date date;
    private String cinemaHall;

    public ScreeningDTO(Screening screening) {
        this.id = screening.getId();
        this.movieTitle = screening.getMovie().getTitle();
        this.startTime = screening.getStartTime();
        this.endTime = screening.getEndTime();
        this.director = screening.getMovie().getDirector();
        this.date = screening.getDate();
        this.cinemaHall = screening.getCinemaHall().getName();
    }
}
