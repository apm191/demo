package com.example.demo.dao.Jpa;

import com.example.demo.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Integer>
{

}
