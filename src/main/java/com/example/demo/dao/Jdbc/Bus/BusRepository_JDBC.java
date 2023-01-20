package com.example.demo.dao.Jdbc.Bus;

import com.example.demo.models.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class BusRepository_JDBC
{
    // JDBC Template Implementation
    @Autowired
    private JdbcTemplate jdbcTemplate;

        public Bus getBus(int Id)
        {
            String query = "select * from bus where Id=?";
            RowMapper<Bus> rowMapper = new BusRowMapper();
            Bus bus = this.jdbcTemplate.queryForObject(query, rowMapper,Id);
            return bus;
        }


    public List<Bus> getBusList()
    {
        String query = "select * from bus inner join bus_bus_destination";
        List<Bus> busList = this.jdbcTemplate.query(query,new BusRowMapper());
        return busList;
    }
}
