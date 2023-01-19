package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Ticket
{
    // Service layer me check availability by ID ka ek method banayenge
    // Service layer me ek booking ka method hoga jo availability ko check krega and fare calculate krke ticket ka pnr ya ticket return krega.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Tid;
    public String JourneySource;
    public String JourneyDestination;
    public int Fare;

    public int Bid;

    public Ticket() {
    }

    public Ticket(String journeySource, String journeyDestination, int fare, int bid) {
        JourneySource = journeySource;
        JourneyDestination = journeyDestination;
        Fare = fare;
        Bid = bid;
    }

    public String getJourneySource() {
        return JourneySource;
    }

    public void setJourneySource(String journeySource) {
        JourneySource = journeySource;
    }

    public String getJourneyDestination() {
        return JourneyDestination;
    }

    public void setJourneyDestination(String journeyDestination) {
        JourneyDestination = journeyDestination;
    }

    public int getFare() {
        return Fare;
    }

    public void setFare(int fare) {
        Fare = fare;
    }

    public int getBid() {
        return Bid;
    }

    public void setBid(int bid) {
        Bid = bid;
    }

    public int getTid() {
        return Tid;
    }
}
