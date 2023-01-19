package com.example.demo.models;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;

@Entity
public class Bus
{
    @Id
    public int Id;
    public String BusOperator;
    public int TotalSeats;

    public int BookedSeats;

    public String BusSource;

//    @ElementCollection
//    @CollectionTable(name = "RouteMapping",
//            joinColumns = {@JoinColumn(name = "BusId", referencedColumnName = "Id")})
//    @MapKeyColumn(name = "StationName")
//    @Column(name = "StationNumber")
//    public HashMap<String,Integer> BusDestination;

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