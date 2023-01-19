package com.example.demo.controller;

import com.example.demo.models.Request;
import com.example.demo.models.Ticket;
import com.example.demo.services.TicketService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController
{
    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket")
    public List<Ticket> getTickets()
    {
        return ticketService.getTickets();
    }

    @GetMapping("/ticket/{id}")
    public Ticket getTicket(@PathVariable int id) {
        return ticketService.getTicket(id);
    }

//    @PostMapping("/ticket")
//    public void addTicket(@RequestBody Ticket ticket)
//    {
//
//        ticketService.setTicket(ticket);
//    }

    @PutMapping("/ticket")
    public void updateTicket(@RequestBody Ticket ticket)
    {

        ticketService.updateTicket(ticket);
    }

    @DeleteMapping("/ticket/{id}")
    public void deleteTicket(@PathVariable int id)
    {
        ticketService.deleteTicket(id);
    }

    @PostMapping("/ticket")
    public String TicketCheck(@RequestBody Request req)
    {
        return ticketService.checkAvailability(req);
    }

}
