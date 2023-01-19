package com.example.demo.services;

import com.example.demo.dao.BusRepository;
import com.example.demo.models.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService
{
    @Autowired
    private BusRepository proRepo;
    public List<Bus> getBusses()
    {
        return proRepo.findAll();
    }
    public Bus getBus(int Id)
    {
        return proRepo.findById(Id).get();
    }

    public void setBus(Bus bus) {
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
}
