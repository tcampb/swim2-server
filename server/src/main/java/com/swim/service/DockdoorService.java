package com.swim.service;

import com.swim.Dao.DockdoorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DockdoorService {

    @Autowired
    private DockdoorDao dockdoorDao;


    public List<Integer> getDockdoor() {
             return dockdoorDao.getDockdoor();
         }



    public void createDockdoor() {
        dockdoorDao.createDockdoor();
    }

    public void deleteDockDoor(Integer id) {
        dockdoorDao.deleteDockDoorById(id);
    }
}
