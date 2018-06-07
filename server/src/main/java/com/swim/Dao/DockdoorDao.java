package com.swim.Dao;

import com.swim.model.Dockdoor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class DockdoorDao {



    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;






    //Create a method to return the dockDoorId
    public List<Integer> getDockdoor() {
        
        List<Integer> ids = new ArrayList<>();

        List<Dockdoor> dockdoorList = jdbcTemplate.query("SELECT id FROM dockdoors", new BeanPropertyRowMapper<Dockdoor>(Dockdoor.class));

        for (Dockdoor dockdoor : dockdoorList) {
            ids.add(dockdoor.getId());
        }
        return ids;


    }

}
