package com.example.healthcaresystem_project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "the room type must not null")
    @Column(columnDefinition = "varchar(3) not null, check( type = 'emergency' or type ='intensive care' or type = 'operating' or type = 'hypnosis')")
    private String roomtype;
    @Column(columnDefinition = "BOOLEAN not null default true")
    private Boolean availability = true;
    @NotNull(message = "patient id must not null")
    @Positive
    @Column(columnDefinition = "int not null")
    private Integer patientId;
}
