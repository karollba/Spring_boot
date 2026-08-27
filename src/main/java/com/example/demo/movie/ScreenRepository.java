package com.example.demo.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


public interface ScreenRepository  extends JpaRepository<Screening, Long> {
    Screening findByDate(Date date);
}
