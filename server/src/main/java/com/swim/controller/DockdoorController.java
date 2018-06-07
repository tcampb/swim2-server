package com.swim.controller;

import com.swim.service.DockdoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DockdoorController {

    @Autowired
    DockdoorService dockdoorService;


    @RequestMapping("/dockdoor/get")
    public List<Integer> getDockdoor() {
        return dockdoorService.getDockdoor();
    }


    @PostMapping("/api/create/dockdoor")
    public void createDockdoor(@RequestBody Map<String, Integer> myMap){
         dockdoorService.createDockdoor(myMap.get("id"));
    }





    
}
