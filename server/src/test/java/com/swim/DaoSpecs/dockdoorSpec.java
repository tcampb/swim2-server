package com.swim.DaoSpecs;

import com.swim.Dao.DockdoorDao;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class dockdoorSpec {

    @Autowired
    DockdoorDao dockdoorDao;


//    @Test
//    public void createDockdoor() {
//        int lastDoorAdded = dockdoorDao.getDockdoor().size();
//        dockdoorDao.createDockdoor();
//        Assert.assertEquals(dockdoorDao.getDockdoor().size(), (lastDoorAdded+1));
//
//    }

    @After
    public void cleanUp() {
        int lastDoorAdded = dockdoorDao.getDockdoor().size();
        dockdoorDao.deleteDockDoorById(lastDoorAdded);

    }
}
