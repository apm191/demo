package com.example.demo.dao.Jpa;

import com.example.demo.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer>
{

}
