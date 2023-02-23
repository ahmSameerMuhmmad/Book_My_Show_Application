package com.example.Book_My_Show_Application.Entities;

import com.example.Book_My_Show_Application.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="show_seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;
    private int price;  /// price of Classic seat for that particular
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Data bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
