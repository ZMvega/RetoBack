package com.Reto.RetoBackend.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appoinments")
public class Appoinments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hour;

    @ManyToOne
    @JoinColumn(name = "idTest")
    private Tests idTest;

    @ManyToOne
    @JoinColumn(name = "idAffiliate")
    private Affiliates idAffiliate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public Tests getIdTest() {
        return idTest;
    }

    public void setIdTest(Tests idTest) {
        this.idTest = idTest;
    }

    public Affiliates getIdAffiliate() {
        return idAffiliate;
    }

    public void setIdAffiliate(Affiliates idAffiliate) {
        this.idAffiliate = idAffiliate;
    }

    public Appoinments(Integer id, LocalDate date, LocalTime hour, Tests idTest, Affiliates idAffiliate) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.idTest = idTest;
        this.idAffiliate = idAffiliate;
    }

    public Appoinments() {
    }
}
