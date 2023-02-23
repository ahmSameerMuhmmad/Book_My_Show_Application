package com.example.Book_My_Show_Application.Entities;

import com.example.Book_My_Show_Application.Enums.Genre;
import com.example.Book_My_Show_Application.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = true)
    private String movieName;

    private double ratings;
    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    // MovieEntity is parent w.r.t shows
    @OneToMany(mappedBy = "movieEntity",cascade = CascadeType.ALL)
    private List<ShowEntity>showEntityList=new ArrayList<>();


}
