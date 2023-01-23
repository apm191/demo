package com.example.demo.dao.Jdbc.Bus;

import com.example.demo.models.Bus;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//public class BusRowMapper implements ResultSetExtractor {
//    public List<Bus> mapRow(ResultSet rs) throws SQLException
//    {
//        Map<Integer,Bus> destMap = new HashMap<>();
//        List<Bus> busList = new ArrayList<>();
//        while(rs.next())
//        {
//            if(destMap.containsKey(rs.getInt("id")))
//            {
//                destMap.get(rs.getInt("id")).BusDestination.add(rs.getString("arguments"));
//            }
//            else
//            {
//                Bus bus = new Bus();
//                bus.setId(rs.getInt("id"));
//                bus.setBusOperator(rs.getString("bus_operator"));
//                bus.setTotalSeats(rs.getInt("total_seats"));
//                bus.setBookedSeats(rs.getInt("booked_seats"));
//                bus.setBusSource(rs.getString("bus_source"));
//                List<String> dest_array = new ArrayList<String>();
//                dest_array.add(rs.getString("arguments"));
//                bus.setBusDestination(dest_array);
//                destMap.put(bus.Id,bus);
//            }
//        }
//
//        return busList;
//    }
//}
