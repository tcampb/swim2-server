package com.swim.model;

import org.springframework.stereotype.Component;


public class Dockdoor {
    private int id;


   public Dockdoor(){
   } 

    public Dockdoor(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
