package com.example.taxibookingapplication.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "optimized-sequence")
    private Integer id;

    @NotNull
    private String taxiNumber;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    @OneToOne
    private User user;

}