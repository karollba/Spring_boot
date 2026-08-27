package com.example.demo.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface ScreenRepository  extends JpaRepository<Screening, Long> {

    @Query("select s from Screening s where cast(s.date as string) like %:date% ")
    List<Screening> findByDate(@Param("date") String date);
}
