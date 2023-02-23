package com.example.Book_My_Show_Application.Entities;

import com.example.Book_My_Show_Application.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalTime showTime;
    private LocalDate showDate;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createOn;

    @UpdateTimestamp
    private Date updateOn;

    // theaterEntity and movieEntity are parent w.r.t showEntity
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;


    // ticketEntity and showSeatEntity are child w.r.t showEntity
    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    private  List<TicketEntity> listOfBookedTickets=new ArrayList<>();

    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfShowSeats=new ArrayList<>();


}
