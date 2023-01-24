package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonPropertyOrder({"id","busOperator","busSource","busDestination","totalSeats","bookedSeats"})
public class Bus implements Serializable
{
    public static final long serialVersionUID = -5280452824297682079L;
    @Id
    @NotNull(message = "Please specify the ID!!")
    private int Id;

    @NotNull(message = "Please specify Bus Operator Name!!")
    private String BusOperator;

    @Min(1)
    @Max(1000)
    private int TotalSeats;

    private int BookedSeats;

    private String BusSource;

    @Column(name="arguments")
    @ElementCollection(targetClass=String.class)
    private List<String> BusDestination;

    public Bus() {
    }

    @Override
    public String toString() {
        return "Bus{" +
                "Id=" + Id +
                ", BusOperator='" + BusOperator + '\'' +
                ", TotalSeats=" + TotalSeats +
                ", BookedSeats=" + BookedSeats +
                ", BusSource='" + BusSource + '\'' +
                ", BusDestination=" + BusDestination +
                '}';
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

    public Bus(int id, String busOperator, int totalSeats, int bookedSeats, String busSource, List<String> busDestination) {
        Id = id;
        BusOperator = busOperator;
        TotalSeats = totalSeats;
        BookedSeats = bookedSeats;
        BusSource = busSource;
        BusDestination = busDestination;
    }
}
