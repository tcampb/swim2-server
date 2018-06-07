package com.swim.controller;

import com.swim.Dao.DockdoorDao;
import com.swim.model.Dockdoor;
import com.swim.service.DockdoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DockdoorController {

    @Autowired
    DockdoorService dockdoorService;


    @RequestMapping("/dockdoor/get")
    public List<Integer> getDockdoor() {
        return dockdoorService.getDockdoor();
    }
}
