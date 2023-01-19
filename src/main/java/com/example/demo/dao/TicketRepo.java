package com.example.demo.dao;

import com.example.demo.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket,Integer>
{

}
