package com.swim.Dao;

import com.swim.model.Dockdoor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class DockdoorDao {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    // Create a method to return the dockDoorId
    public List<Integer> getDockdoor() {
        List<Integer> ids = new ArrayList<>();
        List<Dockdoor> dockdoorList = jdbcTemplate.query("SELECT id FROM dockdoors",
                new BeanPropertyRowMapper<Dockdoor>(Dockdoor.class));

        for (Dockdoor dockdoor : dockdoorList) {
            ids.add(dockdoor.getId());
        }
        return ids;
    }

    // Method for creating a new Dockdoor
    public void createDockdoor(Integer id) {
        HashMap<String, Integer> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update("INSERT INTO dockdoors (id) VALUES (:id) ", params);


    }

    public void deleteDockDoorById(int id) {
        HashMap<String, Integer> testMap = new HashMap<>();
        testMap.put("id", id);
        jdbcTemplate.update("DELETE FROM dockdoors WHERE id = :id", testMap);


    }


}
