package com.example.demo.controller;

import com.example.demo.models.Bus;
import com.example.demo.services.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BusController
{

    @Autowired
    private BusService busService;
    @GetMapping("/buses")
    public List<Bus> getAllBus(){
        return busService.getBusses();
    }

    @GetMapping("/buses/{id}")
    public Bus getBus(@PathVariable int id){
        return busService.getBus(id);
    }
    @PostMapping("/buses")
    public void addBus(@RequestBody @Valid Bus bus)
    {
        busService.setBus(bus);
    }

    @PutMapping("/buses")
    public void updateBus(@RequestBody Bus bus)
    {
        busService.updateBus(bus);
    }

    @DeleteMapping("/buses/{id}")
    public void deleteBus(@PathVariable int id)
    {
        busService.deleteBus(id);
    }
}
