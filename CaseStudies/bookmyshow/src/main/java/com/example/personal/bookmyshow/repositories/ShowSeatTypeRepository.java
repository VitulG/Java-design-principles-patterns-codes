package com.example.personal.bookmyshow.repositories;

import com.example.personal.bookmyshow.models.Show;
import com.example.personal.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    ShowSeatType findByShow(Show show);

    List<ShowSeatType> findAllByShow(Show show);
}
