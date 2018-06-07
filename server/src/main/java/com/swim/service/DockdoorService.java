package com.swim.service;

import com.swim.Dao.DockdoorDao;
import com.swim.model.Dockdoor;
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



    public void createDockdoor(int id) {
        dockdoorDao.createDockdoor(id);
    }
}
