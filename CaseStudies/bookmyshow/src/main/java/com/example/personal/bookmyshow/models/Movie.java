package com.example.personal.bookmyshow.models;

import com.example.personal.bookmyshow.enums.Feature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends BaseModel {
    private String title;
    private String directedBy;
    private Date releaseDate;
    private String genre;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;
}
