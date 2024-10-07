package com.example.personal.bookmyshow.models;

import com.example.personal.bookmyshow.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theatre theatre;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;
}
