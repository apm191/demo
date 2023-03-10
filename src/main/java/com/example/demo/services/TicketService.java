package com.example.demo.services;

import com.example.demo.dao.Jpa.BusRepository;
import com.example.demo.dao.Jpa.TicketRepository;
import com.example.demo.models.Bus;
import com.example.demo.models.Request;
import com.example.demo.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService
{
    @Autowired
    private TicketRepository proRepo;

    @Autowired
    private BusRepository busRepo;

    public List<Ticket> getTickets()
    {
        return proRepo.findAll();
    }

    public Ticket getTicket(int Id)
    {

        return proRepo.findById(Id).get();
    }

    public void setTicket(Ticket ticket)
    {
        proRepo.save(ticket);
    }

    public void updateTicket(Ticket ticket)
    {
        proRepo.save(ticket);
    }


    public void deleteTicket(int id)
    {
        proRepo.deleteById(id);
    }

    public String checkAvailability(Request request)
    {
        List<Bus> busses = busRepo.findAll();

        for(int i=0;i<busses.size();i++)
        {
            if(busses.get(i).getBusDestination().contains(request.Source) && busses.get(i).getBusDestination().contains(request.Destination) && (busses.get(i).getTotalSeats()-busses.get(i).getBookedSeats() > 0)
            && busses.get(i).getBusDestination().indexOf(request.Source)<busses.get(i).getBusDestination().indexOf(request.Destination))
            {
                if(request.Reason.equals("CheckAvailability"))
                    return "Bus is Available!";
                else
                    return bookBus(request,busses.get(i));
            }
        }
        return "No Bus is Available";
    }

    private String bookBus(Request request, Bus bus)
    {
        bus.setBookedSeats(bus.getBookedSeats()+1);
        busRepo.save(bus);
        int fare = (bus.getBusDestination().indexOf(request.Destination)-bus.getBusDestination().indexOf(request.Source) +1)*100;
        Ticket ticket = new Ticket(request.Source,request.Destination,fare, bus.getId());
        proRepo.save(ticket);
        int ticket_id = ticket.getTid();
        return Integer.toString(ticket_id);
    }
}
