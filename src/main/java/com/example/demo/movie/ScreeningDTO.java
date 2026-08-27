package com.example.demo.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ScreeningDTO {

    private Long id;
    private Movie movie;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private CinemaHall cinemaHall;
    private Date date;

    public ScreeningDTO(Screening screening) {
        this.id = screening.getId();
        this.movie = screening.getMovie();
        this.startTime = screening.getStartTime();
        this.endTime = screening.getEndTime();
        this.cinemaHall = screening.getCinemaHall();
        this.date = screening.getDate();
    }
}
