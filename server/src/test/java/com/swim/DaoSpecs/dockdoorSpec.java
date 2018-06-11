package com.swim.DaoSpecs;

import com.swim.Dao.DockdoorDao;
import com.swim.model.Dockdoor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class dockdoorSpec {

    @Autowired
    DockdoorDao dockdoorDao;


    @Test
    public void createAsn() {
        List<Integer> dockDoorList = dockdoorDao.getDockdoor();
        Dockdoor dockDoor = new Dockdoor();
        dockDoor.setId(6);
        dockdoorDao.createDockdoor();

        Assert.assertEquals(dockDoor.getId(), 6);
    }

    @After
    public void cleanUp() {
        dockdoorDao.deleteDockDoorById(6);

    }
}
