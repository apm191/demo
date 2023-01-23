package com.example.demo.services;

import com.example.demo.dao.Jdbc.Bus.BusRepository_JDBC;
import com.example.demo.dao.Jpa.BusRepository;
import com.example.demo.handler.BusServiceException;
import com.example.demo.models.Bus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class BusService
{
    @Autowired
    private BusRepository proRepo;

    @Autowired
    private BusRepository_JDBC proBusRepo;
    public void setBus(@Valid Bus bus)
    {
        proRepo.save(bus);
    }
    public void updateBus(Bus bus)
    {
        proRepo.save(bus);
    }
    public void deleteBus(int id)
    {
        proRepo.deleteById(id);

    }
    public Bus getBus(int Id){
        try{
            return proBusRepo.getBus(Id);
        }
        catch (Exception ex){
            throw new BusServiceException("Bus Not Found");
        }
    }

    public List<Bus>getBusses(){
        return proBusRepo.getBusList();
    }
}
