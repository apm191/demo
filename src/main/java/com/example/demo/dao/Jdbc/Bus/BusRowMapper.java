package com.example.demo.dao.Jdbc.Bus;

import com.example.demo.models.Bus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusRowMapper implements RowMapper<Bus>
{
    public Bus mapRow(ResultSet rs,int rowNum) throws SQLException{
        Bus bus = new Bus();
        bus.setId(rs.getInt("id"));
        bus.setBusOperator(rs.getString("bus_operator"));
        bus.setTotalSeats(rs.getInt("total_seats"));
        bus.setBookedSeats(rs.getInt("booked_seats"));
        bus.setBusSource(rs.getString("bus_source"));
        List<String> dest_array = new ArrayList<String>();
        while(rs.next()){
            dest_array.add(rs.getString("arguments"));
        }
        bus.setBusDestination(dest_array);
        return bus;
    }
}
