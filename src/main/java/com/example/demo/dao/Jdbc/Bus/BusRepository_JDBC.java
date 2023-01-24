package com.example.demo.dao.Jdbc.Bus;

import com.example.demo.handler.BusServiceException;
import com.example.demo.models.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// JDBC Template Implementation
@Component
public class BusRepository_JDBC
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Bus getBus(int Id)
    {
        String query = "select * from bus inner join bus_bus_destination on bus.id = bus_bus_destination.bus_id and id=?";
        List<Bus> bus = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Bus>>()
        {
            @Override
            public List<Bus> extractData(ResultSet rs) throws SQLException, DataAccessException {
                Map<Integer, Bus> destMap = new HashMap<>();
                List<Bus> busList = new ArrayList<>();
                while (rs.next()) {
                    if (destMap.containsKey(rs.getInt("id"))) {
                        destMap.get(rs.getInt("id")).getBusDestination().add(rs.getString("arguments"));
                    } else {
                        Bus bus = new Bus();
                        bus.setId(rs.getInt("id"));
                        bus.setBusOperator(rs.getString("bus_operator"));
                        bus.setTotalSeats(rs.getInt("total_seats"));
                        bus.setBookedSeats(rs.getInt("booked_seats"));
                        bus.setBusSource(rs.getString("bus_source"));
                        List<String> dest_array = new ArrayList<String>();
                        dest_array.add(rs.getString("arguments"));
                        bus.setBusDestination(dest_array);
                        destMap.put(bus.getId(), bus);
                    }
                }

                for (Bus bus : destMap.values()) {
                    busList.add(bus);
                }
                return busList;
            }
        },Id);
        return bus.get(0);
    }
    public List<Bus> getBusList()
    {
        String query = "select * from bus inner join bus_bus_destination on bus.id = bus_bus_destination.bus_id order by id asc";
        List<Bus> rowMapper = new ArrayList<Bus>();
        List<Bus> bus = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Bus>>() {
            @Override
            public List<Bus> extractData(ResultSet rs) throws SQLException, DataAccessException {
                Map<Integer,Bus> destMap = new HashMap<>();
                List<Bus> busList = new ArrayList<>();
                while(rs.next())
                {
                    if(destMap.containsKey(rs.getInt("id")))
                    {
                        destMap.get(rs.getInt("id")).getBusDestination().add(rs.getString("arguments"));
                    }
                    else
                    {
                        Bus bus = new Bus();
                        bus.setId(rs.getInt("id"));
                        bus.setBusOperator(rs.getString("bus_operator"));
                        bus.setTotalSeats(rs.getInt("total_seats"));
                        bus.setBookedSeats(rs.getInt("booked_seats"));
                        bus.setBusSource(rs.getString("bus_source"));
                        List<String> dest_array = new ArrayList<String>();
                        dest_array.add(rs.getString("arguments"));
                        bus.setBusDestination(dest_array);
                        destMap.put(bus.getId(),bus);
                    }
                }

                for(Bus bus : destMap.values())
                {
                    busList.add(bus);
                }

                return busList;
            }
        });
        return bus;
    }
}
