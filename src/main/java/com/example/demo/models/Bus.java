package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Bus
{
    @Id
    @NotNull(message = "Please specify the ID!!")
    public int Id;

    @NotNull(message = "Please specify Bus Operator Name!!")
    public String BusOperator;

    @Min(1)
    @Max(1000)
    public int TotalSeats;

    public int BookedSeats;

    public String BusSource;
    @Column(name="arguments")
    @ElementCollection(targetClass=String.class)
    public List<String>BusDestination;
    public Bus() {
    }

    public Bus(int id, String busOperator, int totalSeats, int bookedSeats, String busSource, List<String> busDestination) {
        Id = id;
        BusOperator = busOperator;
        TotalSeats = totalSeats;
        BookedSeats = bookedSeats;
        BusSource = busSource;
        BusDestination = busDestination;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBusOperator() {
        return BusOperator;
    }

    public void setBusOperator(String busOperator) {
        BusOperator = busOperator;
    }

    public int getTotalSeats() {
        return TotalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        TotalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return BookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        BookedSeats = bookedSeats;
    }

    public String getBusSource() {
        return BusSource;
    }

    public void setBusSource(String busSource) {
        BusSource = busSource;
    }

    public List<String> getBusDestination() {
        return BusDestination;
    }

    public void setBusDestination(List<String> busDestination) {
        BusDestination = busDestination;
    }
}
